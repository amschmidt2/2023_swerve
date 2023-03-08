package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.RelativeEncoder; 


public class FloorIntake extends SubsystemBase {
    private CANSparkMax floorMotor = new CANSparkMax(12, MotorType.kBrushless);
    private double superSpeed = 0.4;
    RelativeEncoder sir_eyespy_coder;
    private int counter = 0;
   
    public FloorIntake(){

    }

    public void collectCube(){
        floorMotor.set(superSpeed);
    }

    public boolean isCollectingCube(){
        double position = sir_eyespy_coder.getPosition();
       double threshold = 0.01;
       return Math.abs(position) < threshold;
    }

    public void fartCube(){
        floorMotor.set(-superSpeed);
    }

    public void stopFloorIntake(){
        floorMotor.set(0);
    }



}
