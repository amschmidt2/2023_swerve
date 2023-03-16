package frc.robot.commands.auto;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.swerve.BackToDaCube;
import frc.robot.commands.swerve.LeftStrafe;
import frc.robot.commands.swerve.LongerCommunity;
import frc.robot.commands.swerve.SlowMode;
import frc.robot.subsystems.DriveSubsystem;

public class TestDrive extends SequentialCommandGroup {
    
    public TestDrive(DriveSubsystem swerveDrive){
        addCommands(
            andThen(new LongerCommunity(swerveDrive)).andThen(new LeftStrafe(swerveDrive)).

            andThen(new SlowMode(swerveDrive)).andThen(() -> swerveDrive.drive( 0, 0, 0, false)).

            andThen(new BackToDaCube(swerveDrive)).andThen(() -> swerveDrive.drive(0, 0, 0, false))


        );

    }



} // <- (.O.)
