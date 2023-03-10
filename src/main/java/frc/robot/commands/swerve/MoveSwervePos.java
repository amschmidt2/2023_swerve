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
        m_drive.drive(-0.3, 0, 0, true); //5 
    }

    @Override
    public void initialize(){
        super.initialize();
        m_drive.setOdometry(new Pose2d(new Translation2d(0.0,0.0),new Rotation2d()));
    }
      
    // 55in --> 1.397 (1)
    // 90in --> 2.286 (2)
    // 132in --> 3.3528 (3)
    // 224in --> 5.6896 (grid to piece --> without cable) 
    // 95.25in --> 2.41935 (grid to cable protect)
    // 148.75in --> 3.77825 (cable to cube)
    // 65.69in --> 1.668272 (grid to ontop of charge)
    // 60.69in --> (grid to end of charge plat)
    public boolean isFinished(){
        System.out.println(this.getClass().getName() + " poseX "+m_drive.getPoseMeters().getX());
        System.out.println(this.getClass().getName() + " poseY "+m_drive.getPoseMeters().getY());
        boolean finished = m_drive.getPoseMeters().getX() < -1.25;
        if (finished) {
            System.out.println(this.getClass().getName() + " is finished");
        }
        return finished;
    }
} // <--
