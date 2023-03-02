package frc.robot.commands.compressor;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Compressor;

public class LinebreakFalseCommand extends CommandBase {
    Compressor compressor;

    public LinebreakFalseCommand(Compressor compressor){
        addRequirements(compressor);
        this.compressor = compressor;
    }

    public void execute(){
     //   compressor.lineForward();
    }

}
