package frc.robot.commands.auto.BlueAuto.LeftAuto;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.armIntake.IntakeArmConeExtractCommand;
import frc.robot.commands.armIntake.IntakeArmCubeCommand;
import frc.robot.commands.armIntake.IntakeArmCubeExtractCommand;
import frc.robot.commands.armIntake.IntakeArmStopCommand;
import frc.robot.commands.armPositions.ArmConeHighCommand;
import frc.robot.commands.armPositions.ArmCubeHighCommand;
import frc.robot.commands.armPositions.ArmGoDown;
import frc.robot.commands.compressor.CompressorCommandExtend;
import frc.robot.commands.compressor.CompressorCommandRetract;
import frc.robot.commands.conveyor.ConveyorGoCommand;
import frc.robot.commands.conveyor.ConveyorStopCommand;
import frc.robot.commands.floorIntake.FloorIntakeFartCommand;
import frc.robot.commands.floorIntake.FloorIntakeStopCommand;
import frc.robot.commands.swerve.BackToDaCube;
import frc.robot.commands.swerve.LeftStrafe;
import frc.robot.commands.swerve.LongerCommunity;
import frc.robot.commands.swerve.SetSwerveIdleMode;
import frc.robot.commands.swerve.SlowMode;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.IntakeArm;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Compressor;
import frc.robot.subsystems.FloorIntake;
  
public class Left_OneCube extends SequentialCommandGroup{
    
    public Left_OneCube(Arm arm, IntakeArm intakeArm, DriveSubsystem swerveDrive, Conveyor convey, Compressor comp, FloorIntake Fintake){
        addCommands(
            new ArmConeHighCommand(arm).andThen(new IntakeArmConeExtractCommand(intakeArm)).
            
            andThen(new IntakeArmStopCommand(intakeArm)).andThen(new ArmGoDown(arm)).

            andThen(new LongerCommunity(swerveDrive)).andThen(new LeftStrafe(swerveDrive)).
            
            andThen(new SetSwerveIdleMode(swerveDrive, true)).andThen(() -> swerveDrive.drive(0,0,0, false)).
 
            andThen(new CompressorCommandExtend(comp)).andThen(new FloorIntakeFartCommand(Fintake)).

            andThen(new ConveyorGoCommand(convey)).andThen(new SlowMode(swerveDrive)).andThen(() -> swerveDrive.drive( 0, 0, 0, false)).
            
            andThen(new ConveyorStopCommand(convey)).andThen(new FloorIntakeStopCommand(Fintake)).andThen(new CompressorCommandRetract(comp)).
            
            andThen(new BackToDaCube(swerveDrive)).andThen(new SetSwerveIdleMode(swerveDrive, true)).andThen(() -> swerveDrive.drive(0, 0, 0, false)).

            andThen(new ConveyorGoCommand(convey)).andThen(new IntakeArmCubeCommand(intakeArm)).
            
            andThen(new ConveyorStopCommand(convey)).andThen(new IntakeArmStopCommand(intakeArm)).
    
            andThen(new ArmCubeHighCommand(arm)).andThen(new IntakeArmCubeExtractCommand(intakeArm)).
            
            andThen(new IntakeArmStopCommand(intakeArm)).andThen(new ArmGoDown(arm)) 
        );
    }



} // <- (0-0 )
