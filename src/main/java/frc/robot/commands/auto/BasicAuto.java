package frc.robot.commands.auto;
import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.PathPlannerTrajectory;
import com.pathplanner.lib.commands.PPSwerveControllerCommand;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.DriveConstants;
import frc.robot.commands.swerve.SetSwerveIdleMode;
import frc.robot.commands.swerve.SetSwerveOdometry;
import frc.robot.subsystems.DriveSubsystem;

public class BasicAuto extends SequentialCommandGroup {
   //DriveSubsystem swerveDrive;
    public BasicAuto(DriveSubsystem swerveDriver){
        PathPlannerTrajectory trajectory = PathPlanner.loadPath("BasicAuto", Units.feetToMeters(2), 
        Units.feetToMeters(2), false);
        PPSwerveControllerCommand testing = new PPSwerveControllerCommand(trajectory, null, null, null, null, null, null);


        // PPSwerveControllerCommand command = new PPSwerveControllerCommand(
        //     trajectory,
        //     swerveDrive::getPoseMeters,
        //     DriveConstants.kSwerveKinematics,
        //     swerveDrive.getXPidController(),
        //     swerveDrive.getYPidController(),
        //     swerveDrive.getThetaPidController(),
        //     swerveDrive::setSwerveModuleStatesAuto,
        //     swerveDrive);
        // addCommands(
        //     new SetSwerveOdometry(swerveDrive, trajectory.getInitialPose()),
        //     command,
        //     new SetSwerveIdleMode(swerveDrive, false)
        //         .andThen(() -> swerveDrive.drive(0, 0, 0, false)));
    }
} // <-- keep brace
