package frc.robot.commands.armPositions;
import frc.robot.commands.LoggingCommandBase;
import frc.robot.subsystems.Arm;

public class ArmGoDown extends LoggingCommandBase {
    Arm arm;

    public ArmGoDown(Arm arm){
        addRequirements(arm);
        this.arm = arm;
    }

    public void execute(){
        arm.goDown();
    }

    public boolean isFinished(){
        boolean finished = arm.isArmDown();
        if (finished) {
            System.out.println(this.getClass().getName() + " is finished");
        }
        return finished;
    }
}
