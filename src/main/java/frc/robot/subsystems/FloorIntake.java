package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.RelativeEncoder; 


public class FloorIntake extends SubsystemBase {
    private CANSparkMax floorMotor;
    private double superSpeed = 0.4;
    RelativeEncoder sir_eyespy_coder;
    private int counter = 0;
   
    public FloorIntake(){
        floorMotor = new CANSparkMax(12, MotorType.kBrushless);
        sir_eyespy_coder = floorMotor.getEncoder();
    }

    public void collectCube(){
        floorMotor.set(superSpeed);
    }

    public boolean isCollectingCube(){
        double position = sir_eyespy_coder.getPosition();
        if(position > 30){
            return true;
        }
        return false;
    }

    public void fartCube(){
        floorMotor.set(-superSpeed);
    }

    public void stopFloorIntake(){
        floorMotor.set(0);
    }



}
