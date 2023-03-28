package frc.robot.commands.auto.BlueAuto.LeftAuto;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.armIntake.IntakeArmConeExtractCommand;
import frc.robot.commands.armIntake.IntakeArmStopCommand;
import frc.robot.commands.armPositions.ArmConeHighCommand;
import frc.robot.commands.armPositions.ArmGoDown;
import frc.robot.commands.swerve.LongerCommunity;
import frc.robot.commands.swerve.OverCPlatt;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.IntakeArm;
import frc.robot.subsystems.DriveSubsystem;

public class OverCharged extends SequentialCommandGroup{
    //Copy that, over and out.
    public OverCharged(Arm arm, IntakeArm Aintake, DriveSubsystem m_drive){
        addCommands(
        new ArmConeHighCommand(arm).andThen(new IntakeArmConeExtractCommand(Aintake))

        .andThen(new IntakeArmStopCommand(Aintake)).andThen(new ArmGoDown(arm))
        
        .andThen(new LongerCommunity(m_drive)).andThen(() -> m_drive.drive(0, 0, 0, false))
        
        .andThen(new OverCPlatt(m_drive)).andThen(() -> m_drive.drive(0,0,0,false))

        );
    }


}
