package frc.robot.commands.floorIntake;
import frc.robot.commands.LoggingCommandBase;
import frc.robot.subsystems.FloorIntake;

public class FloorIntakeStopCommand extends LoggingCommandBase{
    FloorIntake floorIntake;
    boolean isDone = false;

    public FloorIntakeStopCommand(FloorIntake floorIntake){
        addRequirements(floorIntake);
        this.floorIntake = floorIntake;
    }
    
    @Override
    public void execute(){
        floorIntake.stopFloorIntake();
    }
 
    @Override
    public boolean isFinished(){
        System.out.println(this.getClass() + " isFinished() is Done: " + isDone);
        if(!isDone){
            isDone = true;
            return false;
        }
        else{
            return true;
        }
        
        
        //return true;
        //floorIntake.isOff(); 
    }

    @Override
    public void end(boolean interrupted){
        System.out.println(this.getClass() + " end()");
        floorIntake.stopFloorIntake();
    }

} // <-- keep brace
