package frc.robot.commands.auto;
import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.PathPlannerTrajectory;
import com.pathplanner.lib.commands.PPSwerveControllerCommand;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.swerve.SetSwerveIdleMode;
import frc.robot.commands.swerve.SetSwerveOdometry;
import frc.robot.subsystems.DriveSubsystem;

public class BasicAuto extends SequentialCommandGroup {
    public BasicAuto(DriveSubsystem swerveDrive){
        PathPlannerTrajectory trajectory = PathPlanner.loadPath("Test Path.path", Units.feetToMeters(2),
        Units.feetToMeters(2), false);

        PPSwerveControllerCommand command = new PPSwerveControllerCommand(
            trajectory,
            swerveDrive::getPoseMeters,
            swerveDrive.kSwerveKinematics,
            swerveDrive.getXPidController(),
            swerveDrive.getYPidController(),
            swerveDrive.getRotationController(),
            swerveDrive::setSwerveModuleStatesAuto,
            false,
            swerveDrive);
        addCommands(
            new SetSwerveOdometry(swerveDrive, trajectory.getInitialPose()),
            command,
            new SetSwerveIdleMode(swerveDrive, false)
                .andThen(() -> swerveDrive.drive(0, 0, 0, false)));
    }
} // <-- keep brace
