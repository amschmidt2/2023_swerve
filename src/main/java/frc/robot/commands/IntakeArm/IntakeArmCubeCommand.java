package frc.robot.commands.IntakeArm;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeArm;

public class IntakeArmCubeCommand extends CommandBase {
    private boolean intakeExtended = false; 
    IntakeArm intakeArm;

    public IntakeArmCubeCommand(IntakeArm intakeArm){
        addRequirements(intakeArm);
        this.intakeArm = intakeArm;
    }

    public void execute(){
        intakeArm.intakeCube();
    }

    public boolean isIntakeExtended(){
        return intakeExtended;
    }


}// <-- keep brace
