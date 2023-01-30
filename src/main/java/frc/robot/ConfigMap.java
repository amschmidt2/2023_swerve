package frc.robot;
import com.swervedrivespecialties.swervelib.SdsModuleConfigurations;

import edu.wpi.first.math.util.Units;

/**
 * Place IDS here
 */
public class ConfigMap {
    /*
    * ##############################
    * ## CAN IDs
    * ##############################
    */

    //Drive train left
    public static final int FRONT_LEFT_MODULE_DRIVE_MOTOR = 4;
    public static final int FRONT_LEFT_MODULE_STEER_MOTOR = 3;
    public static final int BACK_LEFT_MODULE_DRIVE_MOTOR = 6;
    public static final int BACK_LEFT_MODULE_STEER_MOTOR = 5;

    //Drive train right
    public static final int FRONT_RIGHT_MODULE_DRIVE_MOTOR = 2;
    public static final int FRONT_RIGHT_MODULE_STEER_MOTOR = 1;
    public static final int BACK_RIGHT_MODULE_DRIVE_MOTOR = 15;
    public static final int BACK_RIGHT_MODULE_STEER_MOTOR = 7;

    // steer encoder 
    public static final int FRONT_LEFT_MODULE_STEER_ENCODER = 22; // 
    public static final int FRONT_RIGHT_MODULE_STEER_ENCODER = 21; // 2 --> 23
    public static final int BACK_LEFT_MODULE_STEER_ENCODER = 23; // 6 --> 21
    public static final int BACK_RIGHT_MODULE_STEER_ENCODER = 24; // 24 --> 22



    /*
     * ##############################
     * ## DIO PORTS
     * ##############################
     */

    /*
     * ##############################
     * ## CONSTANTS
     * ##############################
     */

    // SWERVE DRIVE
    public static final double DRIVETRAIN_TRACKWIDTH_METERS = Units.inchesToMeters(30);
    public static final double DRIVETRAIN_WHEELBASE_METERS = Units.inchesToMeters(25);

    // off sets
    public static final double FRONT_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(79); //pos - 78.514 --> 79.277
    public static final double FRONT_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(52); // pos - 50.977 --> 52.207 new
    public static final double BACK_LEFT_MODULE_STEER_OFFSET = -Math.toRadians(17); // pos 17.402 --> 17.139 new
    public static final double BACK_RIGHT_MODULE_STEER_OFFSET = -Math.toRadians(304); // pos- 247.412 --> 304.146 new

    public static final double MAX_VOLTAGE = 12.0;
    public static final double MAX_VELOCITY_METERS_PER_SECOND = 8000.0 / 60.0 *
            SdsModuleConfigurations.MK4I_L2.getDriveReduction() *
            SdsModuleConfigurations.MK4I_L2.getWheelDiameter() * Math.PI;
    public static final double AUTO_MAX_VELOCITY_METERS_PER_SECOND = 6;
    public static final double MAX_ANGULAR_VELOCITY_RADIANS_PER_SECOND = (MAX_VELOCITY_METERS_PER_SECOND /
            Math.hypot(DRIVETRAIN_TRACKWIDTH_METERS / 2.0, DRIVETRAIN_WHEELBASE_METERS / 2.0));

    /*
     * ##############################
     * ## CONTROLS
     * ##############################
     */

    public static final int DRIVER_CONTROLLER = 0;

    public static final String RESET_NAVX = "X";
    public static final String TOGGLE_FIELD_ORIENTED = "Y";
    public static final String RESET_ODOMETRY = "A";



} // <-- Keep brace 
