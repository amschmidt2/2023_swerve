package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.swerve.MoveSwervePos;
import frc.robot.commands.swerve.SetSwerveIdleMode;
import frc.robot.subsystems.DriveSubsystem;

public class DistanceAuto extends SequentialCommandGroup{
    
    public DistanceAuto(DriveSubsystem swerveDrive){
        addCommands(
            new MoveSwervePos(swerveDrive).andThen(new SetSwerveIdleMode(swerveDrive, true)).andThen(() -> swerveDrive.drive(0, 0, 0, false))

        );
    }


} // <--
