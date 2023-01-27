package frc.robot.subsystems;
import edu.wpi.first.networktables.DoubleEntry;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

public class Compressor {
    DoubleSolenoid leftCubeIntake = new DoubleSolenoid((PneumaticsModuleType.CTREPCM), 1, 2);
    DoubleSolenoid rightCubeIntake = new DoubleSolenoid((PneumaticsModuleType.CTREPCM), 3, 4);

    DoubleSolenoid leftConeIntake = new DoubleSolenoid((PneumaticsModuleType.CTREPCM), 5, 6);
    DoubleSolenoid rightConeIntake = new DoubleSolenoid((PneumaticsModuleType.CTREPCM), 7, 8);
    
    private boolean cubeExtended = false;
    
    public Compressor(String name){
        this.name = name;

        
    }




} // <-- leave brace 
