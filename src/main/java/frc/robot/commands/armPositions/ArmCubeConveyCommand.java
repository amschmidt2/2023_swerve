package frc.robot.commands.armPositions;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;
public class ArmCubeConveyCommand extends CommandBase{
    Arm arm;

    public ArmCubeConveyCommand(Arm arm){
        addRequirements(arm);
        this.arm = arm;
    }

    public void execute(){
        arm.armConveyCube();
    }
}
