package frc.robot.commands.IntakeArm;
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




} // <-- keep brace 
