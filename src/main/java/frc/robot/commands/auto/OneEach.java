package frc.robot.commands.auto;

import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.armIntake.IntakeArmConeExtractCommand;
import frc.robot.commands.armIntake.IntakeArmCubeCommand;
import frc.robot.commands.armIntake.IntakeArmCubeExtractCommand;
import frc.robot.commands.armIntake.IntakeArmStopCommand;
import frc.robot.commands.armPositions.ArmColaspeCommand;
import frc.robot.commands.armPositions.ArmConeHighCommand;
import frc.robot.commands.armPositions.ArmCubeHighCommand;
import frc.robot.commands.compressor.CompressorCommandExtend;
import frc.robot.commands.compressor.CompressorCommandRetract;
import frc.robot.commands.conveyor.ConveyorGoCommand;
import frc.robot.commands.conveyor.ConveyorStopCommand;
import frc.robot.commands.floorIntake.FloorIntakeCollectCommand;
import frc.robot.commands.swerve.SetSwerveIdleMode;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Compressor;
import frc.robot.subsystems.IntakeArm;
import frc.robot.subsystems.SwerveModuleSparkMax;
import frc.robot.subsystems.FloorIntake;
import frc.robot.subsystems.Compressor;
import frc.robot.subsystems.Conveyor;

public class OneEach extends SequentialCommandGroup{

    public OneEach(DriveSubsystem swerveDrive, Arm arm, IntakeArm intakeArm, FloorIntake floorIntake, Compressor compressor, Conveyor conveyor){
        addCommands(
            new ArmConeHighCommand(arm).andThen(new IntakeArmConeExtractCommand(intakeArm)).andThen(new ArmColaspeCommand(arm)),

            new SetSwerveIdleMode(swerveDrive, false).andThen(() -> swerveDrive.drive(-0.5, 0, 0, false)),

            new SetSwerveIdleMode(swerveDrive, false).andThen(() -> swerveDrive.drive(0, -0.5, 0, false)),

            new SetSwerveIdleMode(swerveDrive, false).andThen(() -> swerveDrive.drive(-0.5, 0, 0, false)).
            andThen(new SetSwerveIdleMode(swerveDrive, false).andThen(() -> swerveDrive.drive(0, 0, 0, false))),

            new CompressorCommandExtend(compressor).andThen(new FloorIntakeCollectCommand(floorIntake)),

            new SetSwerveIdleMode(swerveDrive, false).andThen(() -> swerveDrive.drive(-0.3, 0, 0, false)),

            new CompressorCommandRetract(compressor).andThen(new ConveyorGoCommand(conveyor)).andThen(new IntakeArmCubeCommand(intakeArm)).
            andThen(new ConveyorStopCommand(conveyor)).andThen(new IntakeArmStopCommand(intakeArm)),

            new SetSwerveIdleMode(swerveDrive, false).andThen(() -> swerveDrive.drive(0.5, 0, 0, false)).
            andThen(new SetSwerveIdleMode(swerveDrive, false).andThen(() -> swerveDrive.drive(0, 0, 0, false))),

            new ArmCubeHighCommand(arm).andThen(new IntakeArmCubeExtractCommand(intakeArm)).andThen(new ArmColaspeCommand(arm))

        );

    }
    
}
