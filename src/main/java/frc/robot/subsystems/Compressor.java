// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
import edu.wpi.first.wpilibj.DigitalInput;


public class Compressor extends SubsystemBase {
  /** Creates a new Compressor. */
  DoubleSolenoid rightDS = new DoubleSolenoid((PneumaticsModuleType.REVPH), 14, 15); //object
  DoubleSolenoid leftDS = new DoubleSolenoid((PneumaticsModuleType.REVPH), 1, 0); //object
  //DigitalInput lineBreak = new DigitalInput(0); 

  // DoubleSolenoid rightDS = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 3, 4);
  // if onTrue is being pressed for like break. 
  public Compressor() {
    //this.name = name;
    
    leftDS.set(Value.kReverse);
    rightDS.set(Value.kReverse);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

  }

  public void reverse() {
    leftDS.set(Value.kReverse);
    rightDS.set(Value.kReverse);
  }

  public void forward() {
    leftDS.set(Value.kForward);
    rightDS.set(Value.kForward);
  }

  public void stop(){
    leftDS.set(Value.kOff);
    rightDS.set(Value.kOff);
  }

  // public void lineForward(){
  //   if(lineBreak.isAnalogTrigger() == true){
  //     leftDS.set(Value.kForward);
  //     rightDS.set(Value.kForward);
  //   }
  // }

  // public void lineReverse(){
  //   if(lineBreak.isAnalogTrigger() == false){
  //     leftDS.set(Value.kReverse);
  //     rightDS.set(Value.kReverse);
  //   }
  //}

} // <-- leave this bracket 


