package frc.robot.commands.armIntake;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.LoggingCommandBase;
import frc.robot.subsystems.IntakeArm;

public class IntakeArmCubeCommand extends LoggingCommandBase {
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

    public boolean isFinished(){
        return intakeArm.isIntakeingCube();
    }


}// <-- keep brace
