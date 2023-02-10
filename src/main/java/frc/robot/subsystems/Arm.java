package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Arm extends SubsystemBase{
    //neo motor that is geared 75:1
    private CANSparkMax armMotor = new CANSparkMax(10, MotorType.kBrushless);
    //private int armCurrentLimit = 20;
    private double armOutputPower = 0.4; // speed  
    private boolean armExtended = false;
    private double armPower;


    public Arm(){
        //armMotor.setInverted(true);
    }

    @Override
    public void periodic() {
    // This method will be called once per scheduler run
    }

    public void setArmMotor(double percent){
        armMotor.set(percent);    
    }

    public void armColapse(){
        armPower = armOutputPower;
        setArmMotor(armPower);
    }

    public void armExtend(){
        armPower = -armOutputPower;
        setArmMotor(armPower);
    }

    public void armHold(){
      armPower = 0;
      setArmMotor(armPower);
    }

  // public void armColapse(){
    //    if(armExtended == true){
            //lowers arm
      //      armPower = armOutputPower;
        //}  
       // else if(armExtended == false){
            //raises arm
         //   armPower = -armOutputPower;
        //}  
        //else{
          //  armPower = 0.0;
        //}
        //setArmMotor(armPower);
       //else{
          //  armPower = 0.0;
        //}
        //setArmMotor(armPower);
  // }    
   
  // public void armExtend(){
       
  // }
        
} // keep brace 