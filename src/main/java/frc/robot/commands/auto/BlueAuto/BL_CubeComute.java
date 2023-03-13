package frc.robot.commands.auto.BlueAuto;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.armIntake.IntakeArmCubeExtractCommand;
import frc.robot.commands.armIntake.IntakeArmStopCommand;
import frc.robot.commands.armPositions.ArmCubeHighCommand;
import frc.robot.commands.armPositions.ArmGoDown;
import frc.robot.commands.swerve.CubeComute;
import frc.robot.commands.swerve.SetSwerveIdleMode;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.IntakeArm;
import frc.robot.subsystems.DriveSubsystem;



public class BL_CubeComute extends SequentialCommandGroup{
    
    public BL_CubeComute(DriveSubsystem swerveDrive, Arm arm, IntakeArm intakeArm){
        addCommands(
            new ArmCubeHighCommand(arm).andThen(new IntakeArmCubeExtractCommand(intakeArm)).
            
            andThen(new IntakeArmStopCommand(intakeArm)).andThen(new ArmGoDown(arm)).

            andThen(new CubeComute(swerveDrive)).andThen(new SetSwerveIdleMode(swerveDrive, false)).andThen(() -> swerveDrive.drive(0, 0, 0, false))


        );


    }



} // <-ouo-
