package frc.robot.commands.armPositions;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ArmGoDown extends CommandBase {
    Arm arm;

    public ArmGoDown(Arm arm){
        addRequirements(arm);
        this.arm = arm;
    }

    public void execute(){
        arm.goDown();
    }

    @Override
    public void initialize() {
        System.out.println("Constructing the "+this.getClass().getName());
    }

    public boolean isFinished(){
        return arm.isArmDown();
    }


}
