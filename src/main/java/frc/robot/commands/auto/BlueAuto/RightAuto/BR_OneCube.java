package frc.robot.commands.auto.BlueAuto.RightAuto;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.armPositions.ArmConeHighCommand;
import frc.robot.commands.armPositions.ArmCubeHighCommand;
import frc.robot.commands.armIntake.IntakeArmConeExtractCommand;
import frc.robot.commands.armIntake.IntakeArmCubeCommand;
import frc.robot.commands.armIntake.IntakeArmCubeExtractCommand;
import frc.robot.commands.armIntake.IntakeArmStopCommand;
import frc.robot.commands.armPositions.ArmGoDown;
import frc.robot.commands.compressor.CompressorCommandExtend;
import frc.robot.commands.compressor.CompressorCommandRetract;
import frc.robot.commands.conveyor.ConveyorGoCommand;
import frc.robot.commands.conveyor.ConveyorStopCommand;
import frc.robot.commands.floorIntake.FloorIntakeCollectCommand;
import frc.robot.commands.floorIntake.FloorIntakeStopCommand;
import frc.robot.commands.swerve.SetSwerveIdleMode;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.IntakeArm;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Compressor;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.FloorIntake;


public class BR_OneCube extends SequentialCommandGroup {
    
    public BR_OneCube(DriveSubsystem swerveDrive, Arm arm, IntakeArm intakeArm, Compressor compressor, Conveyor conveyor, FloorIntake floorIntake){
        addCommands(
            //Arm goes to high and drops cube
            new ArmConeHighCommand(arm).andThen(new IntakeArmConeExtractCommand(intakeArm)),
            //IntakeArm stops and Arm drops
            new IntakeArmStopCommand(intakeArm).andThen(new ArmGoDown(arm)),
            //Robot Moves back
            new SetSwerveIdleMode(swerveDrive, true).andThen(() -> swerveDrive.drive(-0.5, 0, 0, false)),
            //Compress out and FloorIntake Munch, then wheels stop
            new CompressorCommandExtend(compressor).andThen(new FloorIntakeCollectCommand(floorIntake)).
            andThen(new SetSwerveIdleMode(swerveDrive, false).andThen(() -> swerveDrive.drive(0, 0, 0, false))),
            //Compress In and FloorIntake stop
            new CompressorCommandRetract(compressor).andThen(new FloorIntakeStopCommand(floorIntake)),
            //Convey go and IntakeArm go
            new ConveyorGoCommand(conveyor).andThen(new IntakeArmCubeCommand(intakeArm)),
            // Convey Stop and IntakeArm stop
            new ConveyorStopCommand(conveyor).andThen(new IntakeArmStopCommand(intakeArm)),
            //Robot Moves Forward
            new SetSwerveIdleMode(swerveDrive, true).andThen(() -> swerveDrive.drive(0.5, 0, 0, false)).     
            andThen(new SetSwerveIdleMode(swerveDrive, false).andThen(() -> swerveDrive.drive(0, 0, 0, false))),
            //Robot Moves Left
            new SetSwerveIdleMode(swerveDrive, true).andThen(() -> swerveDrive.drive(0, -0.3, 0, false)).
            andThen(new SetSwerveIdleMode(swerveDrive, false).andThen(() -> swerveDrive.drive(0, 0, 0, false))),
            //Cube High 
            new ArmCubeHighCommand(arm).andThen(new IntakeArmCubeExtractCommand(intakeArm)),
            //Arm Down
            new IntakeArmStopCommand(intakeArm).andThen(new ArmGoDown(arm))
            // ~Fin~

        );


    }





} // <-- 
