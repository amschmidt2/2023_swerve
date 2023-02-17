package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.SoftLimitDirection; // old elle on monke had these limits
// the limit was upsiedaise or wutever and it was the max limit. 
import com.revrobotics.CANSparkMax.ControlType;
//import com.revrobotics.CANSparkMax.ControlType.kPosition;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Arm extends SubsystemBase{
    //neo motor that is geared 75:1
    private CANSparkMax armMotor = new CANSparkMax(10, MotorType.kBrushless);
    //private int armCurrentLimit = 20;
    private double armOutputPower = 0.2; // speed  
    private boolean armExtended = false;
    private double armPower;
    private double kPosition = 0;
    private SparkMaxPIDController m_pidController;
    RelativeEncoder sir_eyespy_coder; 
    private double kP, kI, kD, kF, kMaxOutput, kminOutput;


    public Arm(){
      //armMotor.setInverted(true);
      kP = .05; // speed? 
      kI = 0; // 
      kD = 0;
      kF = 0;
      kMaxOutput = 1;
      kminOutput = -1;

      m_pidController.setP(kP);
      m_pidController.setI(kI);
      m_pidController.setD(kD);
      m_pidController.setFF(kF); //armOutputPower
      m_pidController.setOutputRange(kminOutput, kMaxOutput);

      m_pidController.setReference(armOutputPower, CANSparkMax.ControlType.kPosition);


    }

    @Override
    public void periodic() {
    // This method will be called once per scheduler run
     sir_eyespy_coder = armMotor.getEncoder();
     System.out.println(sir_eyespy_coder.getPosition());
     // sir_eyespy_coder.getPosition(kPosition);
    }

    public void setArmMotor(double percent){
        armMotor.set(percent);    
    //    System.out.println("Can you see me " + sir_eyespy_coder.setPosition(kPosition));
    }

    /* Spark Maxs Have reative encoders 
     *  We need to have for the Arm Setpoint:
     *  1. High: Cone, Cube --> 30 or 32, who knows
     *  2. Mid: Cone, Cube --> 18
     *  3. Floor: Both Game pieces -->  
     *  4. Human Station Hight
     *  5. Fully Closed
     *  6. Eat Conveyor Food --> -1 
     *  Add position on a slider in Dashboard or print 
     */

    public void moveToMidway(){
      m_pidController.setReference(armOutputPower, CANSparkMax.ControlType.kPosition, 18);
      sir_eyespy_coder.getPosition(); //) == armMotor.getEncoder();
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