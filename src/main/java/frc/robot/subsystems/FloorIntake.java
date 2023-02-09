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
   //DoubleSolenoid leftFC = new DoubleSolenoid(PneumaticsModuleType.REVPH, 0, 1);
    //DoubleSolenoid rightFC = new DoubleSolenoid(PneumaticsModuleType.REVPH, 3, 4);
    private boolean extended = false;

    public FloorIntake(){
        
    }

    public void forward(){
        floorMotor.set(0.5);
    }

    public void reverse(){
        floorMotor.set(-0.5);
    }

    public boolean isExtended(){
        return extended;
    }

    




} // <-- Keep brace
