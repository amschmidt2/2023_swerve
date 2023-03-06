package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Compressor;

public class CompressorCommandStop extends CommandBase{
    Compressor compressor;

    public CompressorCommandStop(Compressor compressor){
        addRequirements(compressor);
        this.compressor = compressor;
    }

    public void execute(){
        compressor.stop();
    }


} // <-- keep brace 
