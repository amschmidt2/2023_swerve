package frc.robot.commands.conveyor;
import frc.robot.subsystems.Conveyor;
import frc.robot.commands.LoggingCommandBase;

public class ConveyorSTOP  extends LoggingCommandBase{
    Conveyor conveyor;
    public ConveyorSTOP(Conveyor conveyor){
        this.conveyor = conveyor;
        addRequirements(conveyor);
    }

    public void execute(){
        conveyor.stop();
    }

    public boolean isFinished(){
        return conveyor.STOP();
    }
}
