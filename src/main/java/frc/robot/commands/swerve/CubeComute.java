package frc.robot.commands.swerve;
import frc.robot.commands.LoggingCommandBase;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import frc.robot.subsystems.DriveSubsystem;

public class CubeComute extends LoggingCommandBase{
    private DriveSubsystem m_drive;

    public CubeComute(DriveSubsystem m_drive){
        this.m_drive = m_drive;
        addRequirements(m_drive);

    }

    @Override
    public void execute(){
        m_drive.drive(-0.3, -0.05, 0, true);
    }

    @Override
    public void initialize(){
        super.initialize();
        m_drive.setOdometry(new Pose2d(new Translation2d(0.0, 0.0), new Rotation2d()));
    }

    public boolean isFinished(){
        boolean finished = m_drive.getPoseMeters().getX() < -4.05;
        if(finished){
            System.out.println(this.getClass().getName() + " cube Finished!");
            m_drive.drive(0, 0, 0, false);
        }
        return finished;
    }



} // <-_-
