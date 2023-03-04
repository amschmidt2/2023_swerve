package frc.robot.commands.auto;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.AutoConstants;
import frc.robot.commands.IntakeArm.IntakeArmConeCommand;
import frc.robot.commands.armPositions.ArmColaspeCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Compressor;
import frc.robot.subsystems.FloorIntake;
import frc.robot.subsystems.IntakeArm;
import frc.robot.subsystems.Conveyor;

public class FirstAuto extends SequentialCommandGroup{
    
    public FirstAuto(DriveSubsystem drive, Arm arm, Compressor compressor,
        FloorIntake floorIntake, Conveyor conveyor, IntakeArm intakeArm){
            addCommands(

            new ArmColaspeCommand(arm),
            new IntakeArmConeCommand(intakeArm)
            

            );
        }




} //<-- Keep brace
