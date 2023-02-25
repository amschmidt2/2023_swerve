package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Conveyor extends SubsystemBase{

    private CANSparkMax conveyorMotor = new CANSparkMax(13, MotorType.kBrushless); 
    private double speed = 0.45;

    public Conveyor(){


    }

    public void go(){
        conveyorMotor.set(speed);
    }

    public void stop(){
        conveyorMotor.set(0);
    }

    public void reverse(){
        conveyorMotor.set(-speed);
    }




} // <-- keep brace