package frc.robot.commands.auto.RedAuto.RightAuto;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.armIntake.IntakeArmConeExtractCommand;
import frc.robot.commands.armIntake.IntakeArmStopCommand;
import frc.robot.commands.armPositions.ArmColaspeCommand;
import frc.robot.commands.armPositions.ArmConeHighCommand;
import frc.robot.commands.armPositions.ArmGoDown;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.IntakeArm;
import frc.robot.subsystems.DriveSubsystem;


public class RR_HighCone extends SequentialCommandGroup{
    
    public RR_HighCone(DriveSubsystem swerveDrive, Arm arm, IntakeArm intakeArm){
        addCommands(
        new ArmConeHighCommand(arm).andThen(new IntakeArmConeExtractCommand(intakeArm)),

        new IntakeArmStopCommand(intakeArm).andThen(new ArmGoDown(arm))

        );

    }


} // <--
