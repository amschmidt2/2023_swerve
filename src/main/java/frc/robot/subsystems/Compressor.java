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

    private boolean extended = false;
    private String name; 
    
    public Compressor(String name){
        this.name = name;

        
    }
    
    public void cubeExtend(){
        if(extended == true){
            leftCubeIntake.set(Value.kForward);
            rightCubeIntake.set(Value.kForward);
        }
        else{
            leftCubeIntake.set(Value.kReverse);
            leftCubeIntake.set(Value.kReverse);
        }
    }



} // <-- leave brace 
