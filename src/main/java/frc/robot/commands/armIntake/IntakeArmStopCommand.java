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

    @Override
    public void initialize() {
        System.out.println("Constructing the "+this.getClass().getName());
    }

    public boolean isFinished(){
        return intakeArm.isArmIntakeStop();
    }




} // <-- keep brace
