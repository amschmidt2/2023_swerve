package frc.robot.commands.auto.BlueAuto.LeftAuto;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeArm;
import frc.robot.commands.armPositions.ArmConeHighCommand;
import frc.robot.commands.armPositions.ArmGoDown;
import frc.robot.commands.armIntake.IntakeArmConeExtractCommand;
import frc.robot.commands.armIntake.IntakeArmStopCommand;
import frc.robot.commands.swerve.ChargedPlat;
import frc.robot.commands.swerve.SetSwerveIdleMode;
import com.kauailabs.navx.frc.AHRS;


public class BL_Charged extends SequentialCommandGroup {
    DriveSubsystem swerveDrive;
    private int m_AutoBalanceState;
    private int pitch;
    private int tilt;
    DriveSubsystem targetAngle; 

    public BL_Charged(DriveSubsystem swerveDrive, Arm arm, IntakeArm intakeArm){
      this.swerveDrive = swerveDrive;
      addCommands(
        new ArmConeHighCommand(arm).andThen(new IntakeArmConeExtractCommand(intakeArm))
        
        .andThen(new IntakeArmStopCommand(intakeArm)).andThen(new ArmGoDown(arm))

        .andThen(new ChargedPlat(swerveDrive))//.andThen(new Balance())
      );
      

    }

    public void Balance(){
        if(m_AutoBalanceState == 0){
            if(pitch < -14 && swerveDrive.getPoseMeters().getX() < -2.0){
                m_AutoBalanceState = 1;
                swerveDrive.drive(.075, 0, 0, true);
            }
            else{
                swerveDrive.drive(.05, 0, 0, true);
            }
        }

        else if(m_AutoBalanceState == 1){
            if(tilt < -10){
                swerveDrive.drive(.075, 0, 0, true);

            }
            else{
                swerveDrive.drive(0, 0, 0, false); //STOP! Collaborate & Listen, ice is back w/a brand new addiction...
            }
        }

        if(swerveDrive.getPoseMeters().getX() < -5){
            swerveDrive.drive(0, 0, 0, false);
        }
    }

    


} //<--
