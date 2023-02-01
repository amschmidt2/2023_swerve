package frc.robot.subsystems;
import com.revrobotics.CANSparkMax; 


public class Arm extends SubsystemBase{
    //neo motor that is geared 75:1
    private CANSparkMax armMotor = new CANSparkMax(0, MotorType.kBrushless);

    public Arm(){

    }


    public void talk(){
        System.out.println("hello");
    }


}