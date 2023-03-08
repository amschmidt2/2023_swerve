package frc.robot.commands.swerve;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class MoveSwervePos extends CommandBase{
   
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

    @Override
    public void initialize() {
        System.out.println("Constructing the "+this.getClass().getName());
    }
    
    public boolean isFinished(){
        if(m_drive.getPoseMeters().getX() < 1){
            System.out.println(this.getClass().getName()+ "is finished");
            return true;
        }
        return false;
    }








} // <--
