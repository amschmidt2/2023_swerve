package frc.robot.subsystems;
//import com.fasterxml.jackson.databind.node.DoubleNode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

//import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FloorIntake extends SubsystemBase{
    CANSparkMax floorMotor = new CANSparkMax(0,MotorType.kBrushless);
    DoubleSolenoid leftFC = new DoubleSolenoid(PneumaticsModuleType.REVPH, 1, 2);
    DoubleSolenoid rightFC = new DoubleSolenoid(PneumaticsModuleType.REVPH, 3, 4);
    private boolean extended = false;

    public FloorIntake(){
        
    }

    public void munch(){
        if(extended){
            leftFC.set(Value.kReverse);
            leftFC.set(Value.kReverse);
            floorMotor.set(0);
        }
        else{
            leftFC.set(Value.kForward);
            rightFC.set(Value.kForward);
            floorMotor.set(0.5);
        }
        extended = !extended;

    }

    public boolean isExtended(){
        return extended;
    }

    




} // <-- Keep brace
