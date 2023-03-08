package frc.robot.commands.swerve;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import frc.robot.commands.LoggingCommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class MoveSwervePos extends LoggingCommandBase {
   
    private DriveSubsystem m_drive;

    public MoveSwervePos(DriveSubsystem m_drive){
        this.m_drive = m_drive;
        //this.m_mp = m_mp;
        addRequirements(m_drive);
    }

    
    @Override
    public void execute(){
        m_drive.drive(1, 0, 0, false); //5 
    }

    @Override
    public void initialize(){
        super.initialize();
        m_drive.setOdometry(new Pose2d(new Translation2d(0.0,0.0),new Rotation2d()));
    }

    public boolean isFinished(){
        System.out.println(this.getClass().getName() + " poseX "+m_drive.getPoseMeters().getX());
        System.out.println(this.getClass().getName() + " poseY "+m_drive.getPoseMeters().getY());
        boolean finished = m_drive.getPoseMeters().getX() > 0.1;
        if (finished) {
            System.out.println(this.getClass().getName() + " is finished");
        }
        return finished;
    }
} // <--
