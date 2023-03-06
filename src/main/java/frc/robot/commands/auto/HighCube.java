package frc.robot.commands.auto;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.armIntake.IntakeArmCubeExtractCommand;
import frc.robot.commands.armPositions.ArmCubeHighCommand;
import frc.robot.subsystems.Arm; 
import frc.robot.subsystems.IntakeArm;
import frc.robot.commands.swerve.SetSwerveIdleMode;

public class HighCube extends SequentialCommandGroup{
    
    public HighCube(DriveSubsystem swerveDrive, Arm arm, IntakeArm intakeArm){
        addCommands(
            new ArmCubeHighCommand(arm).andThen(new IntakeArmCubeExtractCommand(intakeArm)),

            new SetSwerveIdleMode(swerveDrive, false).andThen(() -> swerveDrive.drive(0, 0, 0, false))

        );


    }



} // <-- Keep Brace
