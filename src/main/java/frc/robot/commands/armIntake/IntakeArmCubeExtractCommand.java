package frc.robot.commands.armIntake;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.LoggingCommandBase;
import frc.robot.subsystems.IntakeArm;

public class IntakeArmCubeExtractCommand extends LoggingCommandBase{
    IntakeArm intakeArm;

    public IntakeArmCubeExtractCommand(IntakeArm intakeArm){
        addRequirements(intakeArm);
        this.intakeArm = intakeArm;
    }

    public void execute(){
        intakeArm.extractCube();
    }

    public boolean isFinished(){
        return intakeArm.isExtractingCube();
    }


} // <-- keep brace 
