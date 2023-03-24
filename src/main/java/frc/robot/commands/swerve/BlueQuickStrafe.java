package frc.robot.commands.swerve;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.LoggingCommandBase;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;

public class BlueQuickStrafe extends LoggingCommandBase{
    private DriveSubsystem m_swerve;

    public BlueQuickStrafe(DriveSubsystem m_swerve){
        this.m_swerve = m_swerve;
        addRequirements(m_swerve);
    }
    @Override
    public void execute(){
        m_swerve.drive(0, -0.2, -0.1, false);
    }

    @Override
    public void initialize(){
        super.initialize();
        m_swerve.setOdometry(new Pose2d(new Translation2d(0.0, 0.0), new Rotation2d()));
    }

    public boolean isFinished(){
        boolean finished = m_swerve.getPoseMeters().getY() < -0.025; //Change Distance 
        return finished;
    }
}
