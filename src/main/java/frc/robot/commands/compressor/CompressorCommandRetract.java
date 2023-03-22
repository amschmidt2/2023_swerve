// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.compressor;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.LoggingCommandBase;
import frc.robot.subsystems.Compressor;

public class CompressorCommandRetract extends LoggingCommandBase {
  Compressor compressor;

  public CompressorCommandRetract(Compressor compressor) {
    addRequirements(compressor);
    this.compressor = compressor;
  }

  @Override
  public void execute() {
    System.out.println("Executing " + this.getClass().getName());
    compressor.reverse();
  }

  public boolean isFinished(){
    return compressor.isReverse();
  }
} // <-- leave this bracket
