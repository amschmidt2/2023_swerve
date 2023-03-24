package frc.robot.commands.auto.BlueAuto.LeftAuto;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.armIntake.IntakeArmConeExtractCommand;
import frc.robot.commands.armIntake.IntakeArmStopCommand;
import frc.robot.commands.armPositions.ArmConeHighCommand;
import frc.robot.commands.armPositions.ArmGoDown;
import frc.robot.commands.compressor.CompressorCommandRetract;
import frc.robot.commands.conveyor.ConveyorGoCommand;
import frc.robot.commands.conveyor.ConveyorStopCommand;
import frc.robot.commands.floorIntake.FloorIntakeStopCommand;
import frc.robot.commands.swerve.LeftStrafe;
import frc.robot.commands.swerve.LongerCommunity;
import frc.robot.commands.swerve.SetSwerveIdleMode;
import frc.robot.commands.swerve.SlowMode;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.IntakeArm;
import frc.robot.subsystems.Compressor;
import frc.robot.subsystems.FloorIntake;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.Conveyor;

public class RedRight_Cube extends SequentialCommandGroup {
   
    public RedRight_Cube(Arm arm, IntakeArm Aintake, Compressor comp, FloorIntake Fintake, DriveSubsystem swerveDrive, Conveyor convey){
        addCommands(
            new ArmConeHighCommand(arm).andThen(new IntakeArmConeExtractCommand(Aintake))

            .andThen(new IntakeArmStopCommand(Aintake)).andThen(new ArmGoDown(arm))
        
            .andThen(new LongerCommunity(swerveDrive)).andThen(new LeftStrafe(swerveDrive))

            .andThen(new SetSwerveIdleMode(swerveDrive, true)).andThen(() -> swerveDrive.drive(0, 0, 0, false))
        
            .andThen(new ConveyorGoCommand(convey)).andThen(new SlowMode(swerveDrive)).andThen(() -> swerveDrive.drive( 0, 0, 0, false))
            
            .andThen(new ConveyorStopCommand(convey)).andThen(new CompressorCommandRetract(comp)).andThen(new FloorIntakeStopCommand(Fintake))
        
            .andThen(new SetSwerveIdleMode(swerveDrive, true)).andThen(() -> swerveDrive.drive(0, 0, 0, false))

        );
    }


}
