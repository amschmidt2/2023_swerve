package frc.robot.commands.auto.BlueAuto.LeftAuto;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.armIntake.IntakeArmConeExtractCommand;
import frc.robot.commands.armIntake.IntakeArmStopCommand;
import frc.robot.commands.armPositions.ArmConeHighCommand;
import frc.robot.commands.armPositions.ArmGoDown;
import frc.robot.commands.compressor.CompressorCommandExtend;
import frc.robot.commands.compressor.CompressorCommandRetract;
import frc.robot.commands.swerve.ChargedPlat;
import frc.robot.commands.swerve.QuickStrafe;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeArm;
import frc.robot.commands.swerve.SetSwerveIdleMode;
import frc.robot.subsystems.Compressor;


public class BL_Charged extends SequentialCommandGroup {
    
    public BL_Charged(DriveSubsystem swerveDrive, Arm arm, IntakeArm intakeArm, Compressor compressor){
        addCommands(
            new ArmConeHighCommand(arm).andThen(new IntakeArmConeExtractCommand(intakeArm)).
           
            andThen(new IntakeArmStopCommand(intakeArm)).andThen(new ArmGoDown(arm)).

            andThen(new CompressorCommandExtend(compressor)).andThen(new ChargedPlat(swerveDrive))//.
            
            // andThen(new CompressorCommandRetract(compressor)).andThen(new QuickStrafe(swerveDrive)).
            
            // andThen(new SetSwerveIdleMode(swerveDrive, false)).andThen(() -> swerveDrive.drive(0, 0, 0, false))

            );

    }


} //<--
