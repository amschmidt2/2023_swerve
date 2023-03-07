package frc.robot.commands.auto.BlueAuto.LeftAuto;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.armIntake.IntakeArmConeExtractCommand;
import frc.robot.commands.armIntake.IntakeArmStopCommand;
import frc.robot.commands.armPositions.ArmConeHighCommand;
import frc.robot.commands.armPositions.ArmGoDown;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeArm;

public class BL_HighCone extends SequentialCommandGroup {
    
    public BL_HighCone(DriveSubsystem swerveDrive, Arm arm, IntakeArm intakeArm){
        addCommands(
            new ArmConeHighCommand(arm).andThen(new IntakeArmConeExtractCommand(intakeArm)),

            new IntakeArmStopCommand(intakeArm).andThen(new ArmGoDown(arm))

        );
    }



} // <-- 
