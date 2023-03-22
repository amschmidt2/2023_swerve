package frc.robot.commands.floorIntake;
import frc.robot.commands.LoggingCommandBase;
import frc.robot.subsystems.FloorIntake;

public class FloorIntakeStopCommand extends LoggingCommandBase{
    FloorIntake floorIntake;

    public FloorIntakeStopCommand(FloorIntake floorIntake){
        addRequirements(floorIntake);
        this.floorIntake = floorIntake;
    }
    
    public void execute(){
        floorIntake.stopFloorIntake();
    }
 
    public boolean isFinished(){
        return floorIntake.isOff(); 
    }


} // <-- keep brace
