package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder; 


public class Conveyor extends SubsystemBase{

    private CANSparkMax conveyorMotor; 
    private double speed = 0.6;
    RelativeEncoder sir_spyeye_coder;

    public Conveyor(){
        conveyorMotor = new CANSparkMax(13, MotorType.kBrushless); 
        sir_spyeye_coder = conveyorMotor.getEncoder();
    }

    public void go(){
        conveyorMotor.set(speed);
    }

    public boolean conveyGo(){
        double position = sir_spyeye_coder.getPosition();
        if(position > 40){
            return true;
        }
        return false;
    }

    public void stop(){
        conveyorMotor.set(0);
    }

    public void reverse(){
        conveyorMotor.set(-speed);
    }




} // <-- keep brace