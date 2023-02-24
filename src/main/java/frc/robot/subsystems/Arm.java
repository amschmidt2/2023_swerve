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

<<<<<<< HEAD
    // make sure you reset your robot to 0 every time you refreash it, this way it does not 
    // over extend, also you might want a linebreak sensor that tells you when the arm is fully down

    //Cone Position 
    public void armHighCone(){
      armMotor.set(controller.calculate(sir_eyespy_coder.getPosition(), 32));
    }

    public void armMidCone(){
      armMotor.set(controller.calculate(sir_eyespy_coder.getPosition(), 18));
    }

    public void armFloorCone(){
      armMotor.set(controller.calculate(sir_eyespy_coder.getPosition(), 10));
    }

    public void armHumanCone(){
      armMotor.set(controller.calculate(sir_eyespy_coder.getPosition(), 34));// 31
    }


    //Cube Posistion
    public void armHighCube(){
      armMotor.set(controller.calculate(sir_eyespy_coder.getPosition(), 30));
    }

    public void armMidCube(){
      armMotor.set(controller.calculate(sir_eyespy_coder.getPosition(), 18));
    }

    public void armFloorCube(){
      armMotor.set(controller.calculate(sir_eyespy_coder.getPosition(), 10));
    }

    public void armConveyCube(){
      armMotor.set(controller.calculate(sir_eyespy_coder.getPosition(), -1));
    }

    public void armHumanCube(){
      armMotor.set(controller.calculate(sir_eyespy_coder.getPosition(),30)); // 28
    }
  
=======
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
>>>>>>> parent of 410e4b3 (Got code for positions :))
        
} // keep brace 