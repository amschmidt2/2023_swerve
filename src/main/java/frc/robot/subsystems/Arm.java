package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
/*
    Has encoder for position of where the Arm is  
    Line Break Sensor 
    Make States for Arm:
        Sleeping --> Arm Turn oof

    Make States for ArmIntake:
        Listens to Arm States
        Collecting --> getting from connor 

    ArmIntake picks up the cube from connor 
*/

public class Arm extends SubsystemBase{
    //neo motor that is geared 75:1
    private CANSparkMax armMotor = new CANSparkMax(0, MotorType.kBrushless);
    // private String state = "sleeping";

    //Arm and the Arm Intake 

    public Arm(){

    }


    public void talk(){
        System.out.println("hello");
    }


}