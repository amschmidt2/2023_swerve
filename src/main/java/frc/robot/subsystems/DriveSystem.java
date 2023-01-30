package frc.robot.subsystems;
import com.kauailabs.navx.frc.AHRS;
import com.swervedrivespecialties.swervelib.Mk4iSwerveModuleHelper;
import com.swervedrivespecialties.swervelib.SwerveModule;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

import frc.robot.ConfigMap;

public class DriveSystem {
        private ShuffleboardTab m_tab = Shuffleboard.getTab("Subsystem outputs");
        private GenericEntry m_navXOutput = m_tab.add("NavX:", 0).getEntry();
        private GenericEntry m_isFieldOrientedEntry = m_tab.add("Field oriented Status: ", false).getEntry();
        private GenericEntry m_currentX = m_tab.add("Current X: ", 0).getEntry();
        private GenericEntry m_currentY = m_tab.add("Current Y: ", 0).getEntry();
        private GenericEntry m_currentHeading = m_tab.add("Current Heading: ", 0).getEntry();

        public static final PIDController autonomousDrivePID = new PIDController(0.7,0,0);
        public static final PIDController autonomousRotPID = new PIDController(0, 0, 0);

        private final SwerveDriveKinematics m_kinematics = new SwerveDriveKinematics(
                        // Front left
                        new Translation2d(ConfigMap.DRIVETRAIN_TRACKWIDTH_METERS / 2.0,
                        ConfigMap.DRIVETRAIN_WHEELBASE_METERS / 2.0),
                        // Front right
                        new Translation2d(ConfigMap.DRIVETRAIN_TRACKWIDTH_METERS / 2.0,
                                        -ConfigMap.DRIVETRAIN_WHEELBASE_METERS / 2.0),
                        // Back left
                        new Translation2d(-ConfigMap.DRIVETRAIN_TRACKWIDTH_METERS / 2.0,
                        ConfigMap.DRIVETRAIN_WHEELBASE_METERS / 2.0),
                        // Back right
                        new Translation2d(-ConfigMap.DRIVETRAIN_TRACKWIDTH_METERS / 2.0,
                                        -ConfigMap.DRIVETRAIN_WHEELBASE_METERS / 2.0));

        private AHRS m_navx = new AHRS(SerialPort.Port.kUSB);

        private final SwerveModule m_frontLeftModule;
        private final SwerveModule m_frontRightModule;
        private final SwerveModule m_backLeftModule;
        private final SwerveModule m_backRightModule;
        
        private SwerveDriveOdometry m_odometry;
        
        private SlewRateLimiter m_driveXLimiter = new SlewRateLimiter(0.999);
        private SlewRateLimiter m_driveYLimiter = new SlewRateLimiter(0.999);
        private SlewRateLimiter m_driveRotLimiter = new SlewRateLimiter(0.999);

        private ChassisSpeeds m_chassisSpeeds;
        private boolean m_isFieldOriented = true;

        public DriveSystem() {
                
            m_frontLeftModule = Mk4iSwerveModuleHelper.createNeo(
                            Mk4iSwerveModuleHelper.GearRatio.L2,
                            ConfigMap.FRONT_LEFT_MODULE_DRIVE_MOTOR,
                            ConfigMap.FRONT_LEFT_MODULE_STEER_MOTOR,
                            ConfigMap.FRONT_LEFT_MODULE_STEER_ENCODER,
                            ConfigMap.FRONT_LEFT_MODULE_STEER_OFFSET);

            // We will do the same for the other modules
            m_frontRightModule = Mk4iSwerveModuleHelper.createNeo(
                            Mk4iSwerveModuleHelper.GearRatio.L2,
                            ConfigMap.FRONT_RIGHT_MODULE_DRIVE_MOTOR,
                            ConfigMap.FRONT_RIGHT_MODULE_STEER_MOTOR,
                            ConfigMap.FRONT_RIGHT_MODULE_STEER_ENCODER,
                            ConfigMap.FRONT_RIGHT_MODULE_STEER_OFFSET);

            m_backLeftModule = Mk4iSwerveModuleHelper.createNeo(
                            Mk4iSwerveModuleHelper.GearRatio.L2,
                            ConfigMap.BACK_LEFT_MODULE_DRIVE_MOTOR,
                            ConfigMap.BACK_LEFT_MODULE_STEER_MOTOR,
                            ConfigMap.BACK_LEFT_MODULE_STEER_ENCODER,
                            ConfigMap.BACK_LEFT_MODULE_STEER_OFFSET);

            m_backRightModule = Mk4iSwerveModuleHelper.createNeo(
                            Mk4iSwerveModuleHelper.GearRatio.L2,
                            ConfigMap.BACK_RIGHT_MODULE_DRIVE_MOTOR,
                            ConfigMap.BACK_RIGHT_MODULE_STEER_MOTOR,
                            ConfigMap.BACK_RIGHT_MODULE_STEER_ENCODER,
                            ConfigMap.BACK_RIGHT_MODULE_STEER_OFFSET);

            SwerveModulePosition frontLeft = new SwerveModulePosition(m_frontLeftModule.getDriveVelocity(),
                            new Rotation2d(m_frontLeftModule.getSteerAngle()));
            SwerveModulePosition frontRight = new SwerveModulePosition(m_frontRightModule.getDriveVelocity(),
                            new Rotation2d(m_frontRightModule.getSteerAngle()));
            SwerveModulePosition backLeft = new SwerveModulePosition(m_backLeftModule.getDriveVelocity(),
                            new Rotation2d(m_backLeftModule.getSteerAngle()));
            SwerveModulePosition backRight = new SwerveModulePosition(m_backRightModule.getDriveVelocity(),
                            new Rotation2d(m_backRightModule.getSteerAngle()));

            SwerveModulePosition[] positions = {frontLeft, frontRight, backLeft, backRight};                             
            m_odometry = new SwerveDriveOdometry(m_kinematics, getGyro(), positions);
            

            zeroGyro();
            resetOdometry();
    }

    public void auto() {
        updateOdometry();
    }

    public void test() {
        //teleop();
    }   
    public void teleop(double translationX, double translationY, double rotationX) {
        updateOdometry();
        
        double xTranslation, yTranslation, rotAxis;

        rotAxis = m_driveRotLimiter.calculate(rotationX);
        xTranslation = m_driveXLimiter.calculate(translationX);
        yTranslation = m_driveYLimiter.calculate(translationY);
        m_isFieldOrientedEntry.setBoolean(m_isFieldOriented);
        if (m_isFieldOriented) {
                drive(ChassisSpeeds.fromFieldRelativeSpeeds(
                                -yTranslation * ConfigMap.MAX_VELOCITY_METERS_PER_SECOND,
                                -xTranslation * ConfigMap.MAX_VELOCITY_METERS_PER_SECOND,
                                (rotAxis * ConfigMap.MAX_ANGULAR_VELOCITY_RADIANS_PER_SECOND) * 0.5,
                                getGyro()), 
                                false

                );
        } else {
                drive(new ChassisSpeeds(
                                -yTranslation * ConfigMap.MAX_VELOCITY_METERS_PER_SECOND,
                                -xTranslation * ConfigMap.MAX_VELOCITY_METERS_PER_SECOND,
                                rotAxis * ConfigMap.MAX_ANGULAR_VELOCITY_RADIANS_PER_SECOND), false);
        }

        m_navXOutput.setDouble(getGyro().getRadians());
}

 /**
         * Drives and sets the chassisSpeeds in one function
         * 
         * @param chassisSpeeds the desired chassisSpeeds, field oriented or not
         */
        public void drive(ChassisSpeeds chassisSpeeds , boolean isAuto) {
            System.out.println("Front Left: " + m_frontLeftModule.getSteerAngle());
            System.out.println("Front Right: " + m_frontRightModule.getSteerAngle());
            System.out.println("Back Left: " + m_backLeftModule.getSteerAngle());
            System.out.println("Back Right: " + m_backRightModule.getSteerAngle());
            m_chassisSpeeds = chassisSpeeds;
            double maxVelo = isAuto ? ConfigMap.AUTO_MAX_VELOCITY_METERS_PER_SECOND : ConfigMap.MAX_VELOCITY_METERS_PER_SECOND;
            SwerveModuleState[] states = m_kinematics.toSwerveModuleStates(m_chassisSpeeds);
            SwerveDriveKinematics.desaturateWheelSpeeds(states, maxVelo);
            m_frontLeftModule.set(
                            states[0].speedMetersPerSecond / maxVelo
                                            * ConfigMap.MAX_VOLTAGE,
                            states[0].angle.getRadians());
            m_frontRightModule.set(
                            states[1].speedMetersPerSecond / maxVelo
                                            * ConfigMap.MAX_VOLTAGE,
                            states[1].angle.getRadians());
            m_backLeftModule.set(
                            states[2].speedMetersPerSecond / maxVelo
                                            * ConfigMap.MAX_VOLTAGE,
                            states[2].angle.getRadians());
            m_backRightModule.set(
                            states[3].speedMetersPerSecond / maxVelo
                                            * ConfigMap.MAX_VOLTAGE,
                            states[3].angle.getRadians());

    }

    /**
     * Updates the swerve drive odometry, most useful during autonomous
     * 
     * @author Vincent Dizon
     */
    private void updateOdometry() {

    }

    private SwerveModulePosition[] modulePositions() {
           // double frontLeftPosition = m_frontLeftDrive.getEncoder().getPosition();
           // double frontRightPosition = m_frontRightDrive.getEncoder().getPosition();
           // double backLeftPosition = m_backLeftDrive.getEncoder().getPosition();
           // double backRightPosition = m_backRightDrive.getEncoder().getPosition();

           /*  return new SwerveModulePosition[] {
                            new SwerveModulePosition(frontLeftPosition, new Rotation2d(m_frontLeftModule.getSteerAngle())),
                            new SwerveModulePosition(frontRightPosition, new Rotation2d(m_frontRightModule.getSteerAngle())),
                            new SwerveModulePosition(backLeftPosition, new Rotation2d(m_backLeftModule.getSteerAngle())),
                            new SwerveModulePosition(backRightPosition, new Rotation2d(m_backRightModule.getSteerAngle()))
                            */
            return new SwerveModulePosition[] {
                    new SwerveModulePosition(m_frontLeftModule.getDriveVelocity(), new Rotation2d(m_frontLeftModule.getSteerAngle())),
                    new SwerveModulePosition(m_frontRightModule.getDriveVelocity(), new Rotation2d(m_frontLeftModule.getSteerAngle())),
                    new SwerveModulePosition(m_backLeftModule.getDriveVelocity(), new Rotation2d(m_frontLeftModule.getSteerAngle())),
                    new SwerveModulePosition(m_backRightModule.getDriveVelocity(), new Rotation2d(m_frontLeftModule.getSteerAngle()))}; 
    }
    
    /**
     * Zeros the navx
     * 
     * @author Vincent Dizon
     */
    private void zeroGyro() {
            m_navx.zeroYaw();
    }

    /**
     * Resets the odometry to a new position of 0,0, but keeps the gyro the same.
     */
    private void resetOdometry() {
            SwerveModulePosition frontLeft = new SwerveModulePosition(0,
                            new Rotation2d(m_frontLeftModule.getSteerAngle()));
            SwerveModulePosition frontRight = new SwerveModulePosition(0,
                            new Rotation2d(m_frontRightModule.getSteerAngle()));
            SwerveModulePosition backLeft = new SwerveModulePosition(0,
                            new Rotation2d(m_backLeftModule.getSteerAngle()));
            SwerveModulePosition backRight = new SwerveModulePosition(0,
                            new Rotation2d(m_backRightModule.getSteerAngle()));

            SwerveModulePosition[] positions = {frontLeft, frontRight, backLeft, backRight}; 

            m_odometry.resetPosition(getGyro(), positions, new Pose2d());
    }

    /**
     * Automatically resets the navx reading if it is out of range for odometry
     * reasons
     * 
     * @return the current gyro (modified) of the navx
     * @author Vincent Dizon
     */
    public Rotation2d getGyro() {
            Rotation2d temp = m_navx.getRotation2d();
            double radians = temp.getRadians();
            if (radians > Math.PI * 2 || radians < -Math.PI * 2) {
                    zeroGyro();
                    temp = m_navx.getRotation2d();
            }

            return new Rotation2d(-temp.getRadians());
    }






} // <-- Keep brace
