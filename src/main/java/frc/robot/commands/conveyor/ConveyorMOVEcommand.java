package frc.robot.commands.conveyor;
import frc.robot.subsystems.Conveyor;

import java.lang.reflect.Executable;

import frc.robot.commands.LoggingCommandBase;

public class ConveyorMOVEcommand extends LoggingCommandBase{
    Conveyor conveyor;
    public ConveyorMOVEcommand(Conveyor conveyor){
        this.conveyor = conveyor;
        addRequirements(conveyor);
        
    }

    public void execute(){
     conveyor.go();   
    }

    public boolean isFinished(){
        return conveyor.gogo();
    }

    
}
