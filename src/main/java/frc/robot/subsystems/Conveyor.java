package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder; 


public class Conveyor extends SubsystemBase{

    private CANSparkMax conveyorMotor; 
    private double speed = 0.6;
    public RelativeEncoder sirSpyeye_coder;

    public Conveyor(){
        conveyorMotor = new CANSparkMax(13, MotorType.kBrushless); 
        sirSpyeye_coder = conveyorMotor.getEncoder();
        sirSpyeye_coder.setPosition(0);
    }

    public void go(){
        conveyorMotor.set(speed);
    }

    public boolean conveyGo(){
        double position = sirSpyeye_coder.getPosition();
        if(position > 12){
            System.out.println("RUNNN" + position);
            return true;
        }
        System.out.println("Stopped" + position);
        return false;
    }

    public boolean gogo(){
        double position = sirSpyeye_coder.getPosition();
        if(position > 175){
            return true;
        }
        return false;
    }

    public void stop(){
        conveyorMotor.set(0);
    }

    public boolean isFinished(){
        double position = sirSpyeye_coder.getPosition();
        if(position > 143){
            return true;
        }
        return false;
    } 

    public boolean conveyorStop(){
        double position = sirSpyeye_coder.getPosition();
        double threshold = 0.01;
        return Math.abs(position) < threshold;
    }

    public boolean STOP(){
        double position = sirSpyeye_coder.getPosition();
        if(position > 160){
            return true;
        }
        return false;
    }

    public void reverse(){
        conveyorMotor.set(-speed);
    }




} // <-- keep brace