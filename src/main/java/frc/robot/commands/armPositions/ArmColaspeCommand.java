package frc.robot.commands.armPositions;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ArmColaspeCommand extends CommandBase {
    private boolean armExtended = false;
    private double armPower = 0;
    Arm arm;


    public  ArmColaspeCommand(Arm arm){
        addRequirements(arm);
        this.arm = arm;
    }
    @Override
    public void execute(){
        arm.armColapse();
    
    }

    public boolean isArmExtended() {
        return armExtended;
    }

} // <-- keep brace