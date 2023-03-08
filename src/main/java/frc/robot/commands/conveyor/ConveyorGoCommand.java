package frc.robot.commands.conveyor;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Conveyor;

public class ConveyorGoCommand extends CommandBase{
    Conveyor conveyor;

    public ConveyorGoCommand(Conveyor conveyor){
        addRequirements(conveyor);
        this.conveyor = conveyor;
    }

    public void execute(){
        conveyor.go();
    }

    public boolean isFinished(){
        return conveyor.conveyGo();
    }

} // <-- kep brace 
