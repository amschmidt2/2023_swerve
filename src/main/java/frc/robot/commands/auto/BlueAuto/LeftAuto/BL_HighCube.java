package frc.robot.commands.auto.BlueAuto.LeftAuto;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.armIntake.IntakeArmCubeExtractCommand;
import frc.robot.commands.armIntake.IntakeArmStopCommand;
import frc.robot.commands.armPositions.ArmCubeHighCommand;
import frc.robot.commands.armPositions.ArmGoDown;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.IntakeArm;

public class BL_HighCube extends SequentialCommandGroup {
    
    public BL_HighCube(DriveSubsystem swerveDrive, Arm arm, IntakeArm intakeArm){
        addCommands(
        new ArmCubeHighCommand(arm).andThen(new IntakeArmCubeExtractCommand(intakeArm)).
        
        andThen(new IntakeArmStopCommand(intakeArm)).andThen(new ArmGoDown(arm))


        );
    }


} // <-_-
