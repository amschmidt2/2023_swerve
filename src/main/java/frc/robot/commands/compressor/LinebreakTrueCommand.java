package frc.robot.commands.compressor;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Compressor;

public class LinebreakTrueCommand extends CommandBase {
    Compressor compressor;

    public LinebreakTrueCommand(Compressor compressor){
        addRequirements(compressor);
        this.compressor = compressor;
    }

    public void execute(){
        compressor.lineReverse();
    }

} // <-- keep brace 
