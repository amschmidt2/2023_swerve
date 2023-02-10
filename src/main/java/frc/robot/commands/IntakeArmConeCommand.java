package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeArm;
public class IntakeArmConeCommand extends CommandBase{
  private boolean intakeExtended = false;
  IntakeArm intakeArm;

  public IntakeArmConeCommand(IntakeArm intakeArm) {
    addRequirements(intakeArm);
     this.intakeArm = intakeArm;
  }
  
  public void execute(){
      intakeArm.intakeCone();
  }
  public boolean isIntakeExtended(){
      return intakeExtended;
  }
  
} // <-- keep brace 
