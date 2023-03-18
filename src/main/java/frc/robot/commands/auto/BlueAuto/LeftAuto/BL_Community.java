package frc.robot.commands.auto.BlueAuto.LeftAuto;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.armIntake.IntakeArmConeExtractCommand;
import frc.robot.commands.armIntake.IntakeArmStopCommand;
import frc.robot.commands.armPositions.ArmConeHighCommand;
import frc.robot.commands.armPositions.ArmGoDown;
import frc.robot.commands.swerve.CommunitySwerve;
import frc.robot.commands.swerve.SetSwerveIdleMode;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.IntakeArm;

public class BL_Community extends SequentialCommandGroup{
    
    public BL_Community(DriveSubsystem swerveDrive, Arm arm, IntakeArm intakeArm){
        addCommands(
            new ArmConeHighCommand(arm).andThen(new IntakeArmConeExtractCommand(intakeArm)).
            
            andThen(new IntakeArmStopCommand(intakeArm)).andThen(new ArmGoDown(arm)).
            
            andThen(new CommunitySwerve(swerveDrive)).andThen(new SetSwerveIdleMode(swerveDrive, true).andThen(() -> swerveDrive.drive(0, 0, 0, false)))
        );
    }








} //<-_- T^T auto is so mean
