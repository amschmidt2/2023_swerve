package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeArm;

public class IntakeArmCubeExtractCommand extends CommandBase{
    IntakeArm intakeArm;

    public IntakeArmCubeExtractCommand(IntakeArm intakeArm){
        addRequirements(intakeArm);
        this.intakeArm = intakeArm;
    }

    public void execute(){
        intakeArm.extractCube();
    }


} // <-- keep brace 
