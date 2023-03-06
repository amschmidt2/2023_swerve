package frc.robot.commands.armPositions;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ArmCubeMidCommand extends CommandBase{
    Arm arm;
    
    public ArmCubeMidCommand(Arm arm){
        addRequirements(arm);
        this.arm = arm;
    }


    public void execute(){
        arm.armMidCube();
    }
    
    public boolean isFinished(){
        return arm.isAtMidSetpoint();
    }
}
