package frc.robot.commands.armPositions;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ArmConeFloorCommand extends CommandBase {
    Arm arm;

    public ArmConeFloorCommand(Arm arm){
        addRequirements(arm);
        this.arm = arm;
    }

    public void execute(){
        arm.armFloorCone();
    }
    
    public boolean isFinished(){
        return arm.isAtFloorSetpoint();
    }
}
