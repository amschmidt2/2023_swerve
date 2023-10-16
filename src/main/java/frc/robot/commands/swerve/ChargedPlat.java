package frc.robot.commands.swerve;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Translation2d;
import frc.robot.commands.LoggingCommandBase;
import frc.robot.subsystems.DriveSubsystem;
  

public class ChargedPlat extends LoggingCommandBase {
    private DriveSubsystem m_drive;
    private int m_AutoBalanceState = 0;
    private boolean isFinished = false;

    public ChargedPlat(DriveSubsystem m_drive){
        this.m_drive = m_drive;
        addRequirements(m_drive);
    }

    @Override
    public void execute(){
        if(m_AutoBalanceState == 0){
            System.out.println("RUNNING");
            if(m_drive.getPitch() < -8 && m_drive.getPoseMeters().getX() > 1.5){ //tune angle (-14) // 2.0
                m_AutoBalanceState = 1;
                m_drive.drive(.1, 0, 0, true); //.075 <
            }
            else{
                m_drive.drive(.3, 0, 0, true);
            } 
        }

        else if(m_AutoBalanceState == 1){
            System.out.println("Can YOU SeE mE");
            if(m_drive.getPitch() < -4.5){ // tune angle (-10) <
                m_drive.drive(.1, 0, 0, true); //tune speed // .075
            }
            else{
                m_drive.drive(0, 0.02, 0, false); //STOP! Collaborate & Listen, ice is back w/a brand new addiction...
                isFinished = true;
            }

        }

        if(m_drive.getPoseMeters().getX() > 5){
            System.out.println("white line");
            m_drive.drive(0, 0, 0, false);
            isFinished = true;
        }

    }

    @Override
    public void initialize(){
        super.initialize();
        m_drive.setOdometry(new Pose2d(new Translation2d(0.0, 0.0), new Rotation2d()));
        System.out.println("I AM ON");
    }

    public boolean isFinished(){
        return isFinished;
    }

    public void end(boolean interrupted){
        isFinished = true;
    }



} //<--
