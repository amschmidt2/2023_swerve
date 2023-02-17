package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FloorIntake;

public class FloorIntakeCollectCommand extends CommandBase{
    FloorIntake floorIntake;

    public FloorIntakeCollectCommand(FloorIntake floorIntake){
        addRequirements(floorIntake);
        this.floorIntake = floorIntake;
    }

    public void execute(){
        floorIntake.collectCube();
    }


} // <-- keep brace 
