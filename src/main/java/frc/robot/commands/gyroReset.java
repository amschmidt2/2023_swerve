package frc.robot.commands;
import frc.robot.subsystems.DriveSubsystem;

public class gyroReset extends LoggingCommandBase{
    DriveSubsystem drive;

    public gyroReset(DriveSubsystem drive){
        this.drive = drive;
    }

    @Override
    public void execute(){
        drive.resetGyro();
    }

    @Override
    public boolean isFinished(){
        return true;
    }


    


}
