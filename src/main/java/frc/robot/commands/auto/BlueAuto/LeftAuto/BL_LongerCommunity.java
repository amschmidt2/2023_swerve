package frc.robot.commands.auto.BlueAuto.LeftAuto;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.armIntake.IntakeArmConeExtractCommand;
import frc.robot.commands.armIntake.IntakeArmStopCommand;
import frc.robot.commands.armPositions.ArmConeHighCommand;
import frc.robot.commands.armPositions.ArmGoDown;
import frc.robot.commands.swerve.LongerCommunity;
import frc.robot.commands.swerve.SetSwerveIdleMode;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.IntakeArm;
import frc.robot.subsystems.DriveSubsystem;


public class BL_LongerCommunity extends SequentialCommandGroup{
    
    public BL_LongerCommunity(DriveSubsystem swerveDrive, Arm arm, IntakeArm intakeArm){
        addCommands(
            new ArmConeHighCommand(arm).andThen(new IntakeArmConeExtractCommand(intakeArm)).
            
            andThen(new IntakeArmStopCommand(intakeArm)).andThen(new ArmGoDown(arm)).

            andThen(new LongerCommunity(swerveDrive)).andThen(new SetSwerveIdleMode(swerveDrive, true).andThen(() -> swerveDrive.drive(0, 0, 0, false)))
        

        );
    }


} // <-'U'
