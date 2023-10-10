package frc.robot.commands.swerve;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class XFactorCommand extends CommandBase{
    private boolean isXFactoring;
    DriveSubsystem driveSubsystem;
    
    public XFactorCommand(DriveSubsystem driveSubsystem){
        addRequirements(driveSubsystem);
        this.driveSubsystem = driveSubsystem;
    }

    public void execute(){
        driveSubsystem.XFactor();
    }

    public boolean isXFactorFactoring(){
        return isXFactoring;
    }



} // <-- Kep brace
