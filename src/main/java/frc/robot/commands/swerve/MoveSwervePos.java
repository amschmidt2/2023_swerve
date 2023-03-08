package frc.robot.commands.swerve;
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
        m_drive.drive(0.25, 0, 0, false);
    }
    
    public boolean isFinished(){
        boolean finished = m_drive.getPoseMeters().getX() < 1;
        if (finished) {
            System.out.println(this.getClass().getName() + " is finished");
        }
        return finished;
    }
} // <--
