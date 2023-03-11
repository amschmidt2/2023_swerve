package frc.robot.commands.auto.BlueAuto.LeftAuto;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.armIntake.IntakeArmCubeExtractCommand;
import frc.robot.commands.armIntake.IntakeArmStopCommand;
import frc.robot.commands.armPositions.ArmCubeHighCommand;
import frc.robot.commands.armPositions.ArmGoDown;
import frc.robot.commands.compressor.CompressorCommandExtend;
import frc.robot.commands.compressor.CompressorCommandRetract;
import frc.robot.commands.floorIntake.FloorIntakeFartCommand;
import frc.robot.commands.floorIntake.FloorIntakeStopCommand;
import frc.robot.commands.swerve.MoveSwervePos;
import frc.robot.commands.swerve.SetSwerveIdleMode;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.IntakeArm;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Compressor;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.FloorIntake;

public class BL_TwoCube extends SequentialCommandGroup{
    public BL_TwoCube(DriveSubsystem swerveDrive, Arm arm, IntakeArm intakeArm, FloorIntake floorIntake, Compressor compressor, Conveyor conveyor){
        addCommands(
           new ArmCubeHighCommand(arm).andThen(new IntakeArmCubeExtractCommand(intakeArm)).
           
           andThen(new IntakeArmStopCommand(intakeArm)).andThen(new ArmGoDown(arm)).
           
           andThen(new CompressorCommandExtend(compressor)).andThen(new FloorIntakeFartCommand(floorIntake)).
           
           andThen(new MoveSwervePos(swerveDrive)).andThen(new SetSwerveIdleMode(swerveDrive, false)).andThen(() -> swerveDrive.drive(0, 0, 0, false)).
           
           andThen(new CompressorCommandRetract(compressor)).andThen(new FloorIntakeStopCommand(floorIntake))
             
        );  


    }
    
} // <--
