// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
import frc.robot.subsystems.Compressor;

public class CompressorCommandRetract extends CommandBase {
  /** Creates a new Compressor. */
  DoubleSolenoid leftDS = new DoubleSolenoid((PneumaticsModuleType.CTREPCM), 1, 2); //object
  DoubleSolenoid rightDS = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 3, 4);

  Compressor compressor;

  public CompressorCommandRetract(Compressor compressor ) {
    this.compressor = compressor;
  }
  @Override
  public void execute() {
    System.out.println("Executing "+ this.getClass().getName());
    compressor.reverse();
  }

} // <-- leave this bracket 


