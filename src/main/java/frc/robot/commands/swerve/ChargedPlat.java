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
            if(m_drive.getPitch() < -8 && m_drive.getPoseMeters().getX() < 2.0){ //tune angle (-14)
                m_AutoBalanceState = 1;
                m_drive.drive(.075, 0, 0, true);
            }
            else{
                m_drive.drive(.3, 0, 0, true);
            } 
        }

        else if(m_AutoBalanceState == 1){
            if(m_drive.getPitch() < -6){ // tune angle (-10)
                m_drive.drive(.075, 0, 0, true); //tune speed

            }
            else{
                m_drive.drive(0, 0, 0, false); //STOP! Collaborate & Listen, ice is back w/a brand new addiction...
                isFinished = true;
            }

        }

        if(m_drive.getPoseMeters().getX() < 5){
            m_drive.drive(0, 0, 0, false);
            isFinished = true;
        }

    }

    @Override
    public void initialize(){
        super.initialize();
        m_drive.setOdometry(new Pose2d(new Translation2d(0.0, 0.0), new Rotation2d()));
    }

    public boolean isFinished(){
        // System.out.println(this.getClass().getName() + " pose X " + m_drive.getPoseMeters().getX());
        // System.out.println(this.getClass().getName() + " pose Y " + m_drive.getPoseMeters().getY());
        // boolean finished = m_drive.getPoseMeters().getX() < -1.65;
        // if(finished){
        //     System.out.println(this.getClass().getName()+ " is finished");
        //     m_drive.drive(0, 0, 0, false);
        // }
        return isFinished;
    }



} //<--
