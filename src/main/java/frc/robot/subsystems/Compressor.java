// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

//import com.ctre.phoenix.motorcontrol.InvertType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

public class Compressor extends SubsystemBase {
  /** Creates a new Compressor. */
  DoubleSolenoid rightDS = new DoubleSolenoid((PneumaticsModuleType.REVPH), 14, 15); //object
  DoubleSolenoid leftDS = new DoubleSolenoid((PneumaticsModuleType.REVPH), 1, 0); //object

  // DoubleSolenoid rightDS = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 3, 4);

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

  public boolean isReverse(){
    if(leftDS.getRevChannel() == 0){ //&& rightDS.getRevChannel() == 0){
      return true;
    }
    return false; 
  }

  public void forward() {
    leftDS.set(Value.kForward);
    rightDS.set(Value.kForward);
  }

  public boolean isForward(){
    if(leftDS.getFwdChannel() == 1){ //&& rightDS.getFwdChannel() == 1){
      return true;
    }
    return false;
  }

  public void stop(){
    leftDS.set(Value.kOff);
    rightDS.set(Value.kOff);
  }


} // <-- leave this bracket 


