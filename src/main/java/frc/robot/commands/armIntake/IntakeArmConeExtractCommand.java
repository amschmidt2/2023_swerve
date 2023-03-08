package frc.robot.commands.armIntake;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeArm;

public class IntakeArmConeExtractCommand extends CommandBase{
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
        System.out.println("Constructing the "+this.getClass().getName());
    }

    public boolean isFinished(){
        return intakeArm.isExtractingCone();
    }



} // <-- keep brace 
