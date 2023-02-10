package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ArmColaspeCommand extends CommandBase {
    private boolean armExtended = false;
    private double armPower = 0;
    Arm arm;

    public ArmColaspeCommand(Arm arm) {
        addRequirements(arm);
        this.arm = arm;
    }

    public void execute() {
        System.out.println("Executing " + this.getClass().getName());
        if (armExtended == true) {
            arm.armColapse();
        } else {
            System.out.println(this.getClass().getName()+": arm power "+armPower);
            arm.setArmMotor(armPower);
        }
    }

    public boolean isArmExtended() {
        return armExtended;
    }

} // <-- keep brace