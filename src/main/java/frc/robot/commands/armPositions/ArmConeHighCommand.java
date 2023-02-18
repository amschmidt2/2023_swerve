package frc.robot.commands.armPositions;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ArmConeHighCommand extends CommandBase{
    Arm arm;
    
    public ArmConeHighCommand(Arm arm){
        addRequirements(arm);
        this.arm = arm;
    }

    public void execute(){
        arm.armHighCone();
    }

    
} // <-- keep brace
