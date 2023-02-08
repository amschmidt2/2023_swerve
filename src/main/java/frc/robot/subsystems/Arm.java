package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Arm extends SubsystemBase{
    //neo motor that is geared 75:1
    private CANSparkMax armMotor = new CANSparkMax(10, MotorType.kBrushless);
    private int armCurrentLimit = 20;
    private double armOutputPower = 0.4; 
    private boolean armExtended = false;
    private double armPower;


    public Arm(){
        //armMotor.setInverted(true);
    }

    @Override
    public void periodic() {
    // This method will be called once per scheduler run
    }

    public void setArmMotor(){
        armMotor.set(0.5);    
    }

   public void armMove(){
        if(armExtended == true){
            armPower = -armOutputPower;

        }    
   }            
        
}