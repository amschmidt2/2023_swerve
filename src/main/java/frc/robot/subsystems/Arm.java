package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
//import com.revrobotics.CANSparkMax.ControlType;
//import com.revrobotics.CANSparkMax.ControlType.kPosition;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Arm extends SubsystemBase{
    //neo motor that is geared 75:1
    private CANSparkMax armMotor = new CANSparkMax(10, MotorType.kBrushless);
    //private int armCurrentLimit = 20;
    private double armOutputPower = 0.2; // speed  
  //  private boolean armExtended = false;
    private double armPower;
  //  private double kPosition = 0;
    private SparkMaxPIDController m_pidController; // = new SparkMaxPIDController();
    private double kDt = 0.02;
    SparkMaxPIDController PID;
   public RelativeEncoder sir_eyespy_coder;
    TrapezoidProfile.Constraints m_Constraints = new TrapezoidProfile.Constraints(300, 150);
    ProfiledPIDController controller = new ProfiledPIDController(0.05, 0.02, 0, m_Constraints, kDt);


    public Arm(){
      //armMotor.setInverted(true);
     // sir_eyespy_coder.setPosition(0);
      armMotor.restoreFactoryDefaults();
      sir_eyespy_coder = armMotor.getEncoder();
      PID = armMotor.getPIDController();
    }

    //@Override
    // public void init(){
    //   sir_eyespy_coder.setPositionConversionFactor(1.0 / 360.0 * 2.0 * Math.PI * 1.5);
    // }

    @Override
    public void periodic() {
    // This method will be called once per scheduler run
     sir_eyespy_coder = armMotor.getEncoder();
     //System.out.println(sir_eyespy_coder.getPosition());

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

  
    public void armColapse(){
        armPower = armOutputPower;
        setArmMotor(armPower);
        
    }

    public void armExtend(){
        armPower = -armOutputPower;
        setArmMotor(armPower);
        System.out.println(sir_eyespy_coder.getPosition());
    }

    public void armHold(){
      armPower = 0;
      setArmMotor(armPower);
    }


    //************************************************************************************


    //Cone Position 
    public void armHighCone(){
      armMotor.set(controller.calculate(sir_eyespy_coder.getPosition(), 36)); //32
    } 

    public boolean isAtHighSetpoint(){
     // System.out.println("======="+sir_eyespy_coder.getPosition());
      if(sir_eyespy_coder.getPosition() > 36){
        return true;
      }
      return false;
    }

    public void armMidCone(){
      armMotor.set(controller.calculate(sir_eyespy_coder.getPosition(), 13));// 15
    }

    public boolean isAtMidSetpoint(){
     // System.out.println("====="+sir_eyespy_coder.getPosition());
      if(sir_eyespy_coder.getPosition() > 15){ //find new setpoint
        return true;
      }
      return false;
      
    }

    public void armFloorCone(){
      armMotor.set(controller.calculate(sir_eyespy_coder.getPosition(), 10)); // 10
    }

    public boolean isAtFloorSetpoint(){
      // System.out.println("====="+sir_eyespy_coder.getPosition());
      if(sir_eyespy_coder.getPosition() > 10){
        return true;
      }
      return false; 
    }

    public void armHumanCone(){
      armMotor.set(controller.calculate(sir_eyespy_coder.getPosition(), 34));// 31
    }

    public void collapse(){
      armMotor.set(controller.calculate(sir_eyespy_coder.getPosition(), -1));
    }


    //************************************************************************************

    //Cube Posistion
    public void armHighCube(){
      armMotor.set(controller.calculate(sir_eyespy_coder.getPosition(), 38)); // 30
    }

    public boolean isCubeHighSetpoint(){
      // System.out.println("====="+sir_eyespy_coder.getPosition());
      if(sir_eyespy_coder.getPosition() > 32){
        return true;
      }
      return false;
    }

    public void armMidCube(){
      armMotor.set(controller.calculate(sir_eyespy_coder.getPosition(), 15)); // 15 
    }

    public boolean isCubeMidSetpoint(){
      // System.out.println("====="+sir_eyespy_coder.getPosition());
      if(sir_eyespy_coder.getPosition() > 13){
        return true;
      }
      return false;
    }

    public void armFloorCube(){
      armMotor.set(controller.calculate(sir_eyespy_coder.getPosition(), 11)); // 10
    }

    public boolean isCubeFloorSetpoint(){
     // System.out.println("====="+sir_eyespy_coder.getPosition()); 
      if(sir_eyespy_coder.getPosition() > 11){
        return true; 
      }
      return false;
    }
   

    public void armConveyCube(){
      armMotor.set(controller.calculate(sir_eyespy_coder.getPosition(), -1)); // -1
    }

    public void armHumanCube(){
      armMotor.set(controller.calculate(sir_eyespy_coder.getPosition(),31)); // 28
    }

    public void goDown(){
      armMotor.set(controller.calculate(sir_eyespy_coder.getPosition(),-1));
    }

    public boolean isArmDown(){
      if(sir_eyespy_coder.getPosition() < 0.2){
        return true;
      }
      return false;
    }


  
        
} // keep brace 