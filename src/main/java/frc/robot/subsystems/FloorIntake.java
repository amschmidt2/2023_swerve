package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.MotorCommutation;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FloorIntake extends SubsystemBase {
    private CANSparkMax floorMotor = new CANSparkMax(12, MotorType.kBrushless);
    private double superSpeed = 0.4;
   
    public FloorIntake(){

    }

    public void collectCube(){
        floorMotor.set(superSpeed);
    }

    public void fartCube(){
        floorMotor.set(-superSpeed);
    }

    public void stopFloorIntake(){
        floorMotor.set(0);
    }



}
