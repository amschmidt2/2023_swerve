package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FloorIntake;

public class FloorIntakeFartCommand extends CommandBase {
    FloorIntake floorIntake;

    public FloorIntakeFartCommand(FloorIntake floorIntake){
        addRequirements(floorIntake);
        this.floorIntake = floorIntake;
    }

    public void execute(){
        floorIntake.fartCube();
    }

} // <-- keep brace 
