package frc.robot.commands.armIntake;

import frc.robot.commands.LoggingCommandBase;
import frc.robot.subsystems.IntakeArm;

public class IntakeArmStopCommand extends LoggingCommandBase {
    IntakeArm intakeArm;

    public IntakeArmStopCommand(IntakeArm intakeArm){
       addRequirements(intakeArm);
        this.intakeArm = intakeArm;
    }

    public void execute(){
        intakeArm.stopArmIntake();
    }

    public boolean isFinished(){
        return true;
    }
} //
 