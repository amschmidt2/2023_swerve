package frc.robot.commands.auto.BlueAuto.LeftAuto;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeArm;
import frc.robot.commands.armPositions.ArmConeHighCommand;
import frc.robot.commands.armPositions.ArmGoDown;
import frc.robot.commands.armIntake.IntakeArmConeExtractCommand;
import frc.robot.commands.armIntake.IntakeArmStopCommand;
import frc.robot.commands.swerve.ChargedPlat;


public class BL_Charged extends SequentialCommandGroup {
    DriveSubsystem targetAngle; 

    public BL_Charged(DriveSubsystem swerveDrive, Arm arm, IntakeArm intakeArm){
      addCommands(
        new ArmConeHighCommand(arm).andThen(new IntakeArmConeExtractCommand(intakeArm))
        
        .andThen(new IntakeArmStopCommand(intakeArm)).andThen(new ArmGoDown(arm))

        .andThen(new ChargedPlat(swerveDrive)).andThen(() -> swerveDrive.drive(0, 0, 0, false))
      );
      

    }

  

    


} //<--
