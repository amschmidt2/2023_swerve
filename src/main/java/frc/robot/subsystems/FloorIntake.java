package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.RelativeEncoder; 


public class FloorIntake extends SubsystemBase {
    private CANSparkMax floorMotor;
    private double superSpeed = 0.4;
    public RelativeEncoder eyespy_coder;
    //private int counter = 0;
   
    public FloorIntake(){
        floorMotor = new CANSparkMax(12, MotorType.kBrushless);
        eyespy_coder = floorMotor.getEncoder();
        eyespy_coder.setPosition(0);
    }

    public void collectCube(){
        floorMotor.set(superSpeed);
    }

    public boolean isCollectingCube(){
        double position = eyespy_coder.getPosition();
        if(position > 30){
            return true;
        }
        return false;
    }

    public void fartCube(){
        floorMotor.set(-superSpeed);
    }

    public boolean isMunchCube(){
        double position = eyespy_coder.getPosition();
        if(position < -100.0){
            System.out.println("RUNNN" + position);
            return true;
        }
        System.out.println("Stopped" + position);
        return false; 
    }

    public void stopFloorIntake(){
        floorMotor.set(0);
    }
 
    public boolean isOff(){
        double position = eyespy_coder.getPosition();
        if(position > -300.0){
            return true;
        }
        return false;
    }

    



}
