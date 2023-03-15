package frc.robot.commands.auto.BlueAuto.LeftAuto;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.armIntake.IntakeArmConeExtractCommand;
import frc.robot.commands.armIntake.IntakeArmStopCommand;
import frc.robot.commands.armPositions.ArmConeHighCommand;
import frc.robot.commands.armPositions.ArmGoDown;
import frc.robot.commands.swerve.LongerCommunity;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.IntakeArm;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.Conveyor;
import frc.robot.subsystems.Compressor;


public class Right_OneCube extends SequentialCommandGroup {
    
    public Right_OneCube(Arm arm, IntakeArm intakeArm, DriveSubsystem swerveDrive, Conveyor convey, Compressor comp){
        addCommands(
            new ArmConeHighCommand(arm).andThen(new IntakeArmConeExtractCommand(intakeArm)).
            
            andThen(new IntakeArmStopCommand(intakeArm)).andThen(new ArmGoDown(arm)).
            
            andThen(new LongerCommunity(swerveDrive))
        );
    }





}// <- (0-0 )
