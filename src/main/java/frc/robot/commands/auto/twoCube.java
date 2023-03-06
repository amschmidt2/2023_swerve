package frc.robot.commands.auto;

import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.armIntake.IntakeArmConeExtractCommand;
import frc.robot.commands.armPositions.ArmColaspeCommand;
import frc.robot.commands.armPositions.ArmConeHighCommand;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.IntakeArm;

public class twoCube extends SequentialCommandGroup{

    public twoCube(DriveSubsystem swerveDrive, Arm arm, IntakeArm intakeArm){
        addCommands(
        new ArmConeHighCommand(arm).andThen(new IntakeArmConeExtractCommand(intakeArm)),

        new ArmColaspeCommand(arm).andThen(new SwerveDriveOdometry())


        );

    }
    
}
