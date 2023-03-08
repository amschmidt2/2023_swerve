package frc.robot.commands.floorIntake;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FloorIntake;

public class FloorIntakeStopCommand extends CommandBase{
    FloorIntake floorIntake;

    public FloorIntakeStopCommand(FloorIntake floorIntake){
        addRequirements(floorIntake);
        this.floorIntake = floorIntake;
    }
    
    public void execute(){
        floorIntake.stopFloorIntake();
    }

    public boolean isFinished(){
        return true; 
    }


} // <-- keep brace
