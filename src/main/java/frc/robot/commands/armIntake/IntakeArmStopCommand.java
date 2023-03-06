package frc.robot.commands.armIntake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeArm;

public class IntakeArmStopCommand extends CommandBase{
    IntakeArm intakeArm;

    public IntakeArmStopCommand(IntakeArm intakeArm){
       addRequirements(intakeArm);
        this.intakeArm = intakeArm;
    }

    public void execute(){
        intakeArm.stopArmIntake();
    }




} // <-- keep brace
