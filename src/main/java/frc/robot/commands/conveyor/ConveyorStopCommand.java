package frc.robot.commands.conveyor;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.LoggingCommandBase;
import frc.robot.subsystems.Conveyor;


public class ConveyorStopCommand extends LoggingCommandBase {
    Conveyor conveyor;

    public ConveyorStopCommand(Conveyor conveyor){
        addRequirements(conveyor);
        this.conveyor = conveyor;
    }

    public void execute(){
        conveyor.stop();
    }

    public boolean isFinished(){
        return conveyor.isFinished();
    }




} // <-- kep brace 
