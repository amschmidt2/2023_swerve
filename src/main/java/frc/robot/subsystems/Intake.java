package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;

/*
    Make States for Intake:
        Sleeping --> When robot turns off, motor off
        Munching --> Out and Looking around, motor out and looking 
        

    Has a Line Break Sensor --> moving line sensor, 
    once sensor breaks then izzy will move back to sleeping 
*/

public class Intake extends SubsystemBase{
    private CANSparkMax izzyMotor = new CANSparkMax(0, MotorType.kBrushless); 
    private String state = "sleeping";

    public Intake(){
        
    }

    public void talk(){
        System.out.println("hello!");
    }

    public void roll(){
        if(izzyMotor == true){
            izzyMotor.set(1);
        }
        else{
            izzyMotor.set(0);
        }
    }

    

} // keep brace