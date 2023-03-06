package frc.robot.commands;
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


} // <-- keep brace
