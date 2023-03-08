package frc.robot.commands.armIntake;
import frc.robot.commands.LoggingCommandBase;
import frc.robot.subsystems.IntakeArm;

public class IntakeArmConeExtractCommand extends LoggingCommandBase {
    IntakeArm intakeArm;

    public IntakeArmConeExtractCommand(IntakeArm intakeArm){
        addRequirements(intakeArm);
        this.intakeArm = intakeArm;

    }

    public void execute(){
        intakeArm.extractCone();
    }

    public boolean isFinished(){
        return intakeArm.isExtractingCone();
    }



} // <-- keep brace 
