package frc.robot.commands.auto.BlueAuto.LeftAuto;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeArm;
import frc.robot.commands.swerve.SetSwerveIdleMode;


public class BL_Charged extends SequentialCommandGroup {
    DriveSubsystem swerveDrive;
    private int m_AutoBalanceState;

    public BL_Charged(DriveSubsystem swerveDrive, Arm arm, IntakeArm intakeArm){
      this.swerveDrive = swerveDrive;

    }

    public void Balance(){
        if(m_AutoBalanceState == 0){
            


        }
    }

    


} //<--
