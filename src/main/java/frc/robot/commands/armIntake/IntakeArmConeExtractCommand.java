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

    @Override
    public void initialize() {
        intakeArm.resetPosition();
    }

    public boolean isFinished(){
        boolean finished = intakeArm.isExtractingCone();
        if (finished) {
            System.out.println(this.getClass().getName() + " is finished");
        }
        return finished;
    }
} // <-- keep brace
