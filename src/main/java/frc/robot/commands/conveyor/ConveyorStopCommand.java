package frc.robot.commands.conveyor;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Conveyor;


public class ConveyorStopCommand extends CommandBase {
    Conveyor conveyor;

    public ConveyorStopCommand(Conveyor conveyor){
        addRequirements(conveyor);
        this.conveyor = conveyor;
    }

    public void execute(){
        conveyor.stop();
    }




} // <-- kep brace 
