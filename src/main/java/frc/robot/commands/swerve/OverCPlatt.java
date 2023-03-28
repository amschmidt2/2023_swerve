package frc.robot.commands.swerve;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Translation2d;
import frc.robot.commands.LoggingCommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class OverCPlatt extends LoggingCommandBase{
    private DriveSubsystem m_drive;
    private int m_AutoBalanceState = 0;
    private boolean isFinished = false;

    public OverCPlatt(DriveSubsystem m_drive){
        this.m_drive = m_drive;
        addRequirements(m_drive);
    }

    @Override
    public void execute(){
        if(m_AutoBalanceState == 0){
            if(m_drive.getPitch() < 8 && m_drive.getPoseMeters().getX() > 5){
                m_AutoBalanceState = 1;
                m_drive.drive(-.1, 0, 0, true);
            }
            else{
                m_drive.drive(-.3, 0, 0, true);
                isFinished = true;
            }

        }
        else if(m_AutoBalanceState == 1){
            if(m_drive.getPitch() < 6){
            m_drive.drive(-.1, 0, 0, true);
            }
            else{
                m_drive.drive(0, 0, 0, false);
                isFinished = true;
            }
        }
        if(m_drive.getPoseMeters().getX() > 5){
            m_drive.drive(0, 0, 0, false);
            isFinished = true;
        }
    }

    @Override
    public void initialize(){
        super.initialize();
        m_drive.setOdometry(new Pose2d(new Translation2d(0.0, 0.0), new Rotation2d()));
    }

    public boolean isFinished(){
        return isFinished;
    }

    public void end(boolean interrupted){
        isFinished = true;
    }


} // <--
