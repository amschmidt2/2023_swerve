package frc.robot.commands.armPositions;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ArmConeMidCommand extends CommandBase{
    Arm arm;

    public ArmConeMidCommand(Arm arm){
        addRequirements(arm);
        this.arm = arm;
    }

    public void execute(){
        arm.armMidCone();
    }

    public boolean isFinished(){
        return arm.isAtMidSetpoint();
    }

} // <-- keep brace 
