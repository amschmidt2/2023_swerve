package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeArm;

public class IntakeArmCommand extends CommandBase {

  private boolean intakeExtended = false;
  IntakeArm intakeArm;

  public IntakeArmCommand(IntakeArm intakeArm) {
    addRequirements(intakeArm);
    this.intakeArm = intakeArm;
  }

  public void execute() {
    System.out.println("Executing " + this.getClass().getName());
    intakeArm.intakeCone();
  }

  public boolean isIntakeExtended() {
    return intakeExtended;
  }

} // <-- keep brace
