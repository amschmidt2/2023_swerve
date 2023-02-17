package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ArmToMidwayCommand extends CommandBase{
    Arm arm;

    public ArmToMidwayCommand(Arm arm){
        addRequirements(arm);
        this.arm = arm;
    }

    public void execute(){
        arm.moveToMidway();
    }

}
