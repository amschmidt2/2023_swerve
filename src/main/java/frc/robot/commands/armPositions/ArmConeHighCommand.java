package frc.robot.commands.armPositions;
import frc.robot.commands.LoggingCommandBase;
import frc.robot.subsystems.Arm;

public class ArmConeHighCommand extends LoggingCommandBase {
    Arm arm;
    
    public ArmConeHighCommand(Arm arm){
        addRequirements(arm);
        this.arm = arm;
    }

    public void execute(){
        arm.armHighCone();
    }

    public boolean isFinished(){
        return arm.isAtHighSetpoint(); 
    }
} // <-- keep brace
