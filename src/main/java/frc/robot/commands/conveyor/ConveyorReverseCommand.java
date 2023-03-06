package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Conveyor;


public class ConveyorReverseCommand extends CommandBase{
    Conveyor conveyor;

    public ConveyorReverseCommand(Conveyor conveyor){
        addRequirements(conveyor);
        this.conveyor = conveyor; 
    }

    public void execute(){ 
        conveyor.reverse();
    }


} // <-- kep brace 
