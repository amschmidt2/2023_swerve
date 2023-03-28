package frc.robot.commands.armIntake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.commands.LoggingCommandBase;
import frc.robot.subsystems.IntakeArm;

public class IntakeArmConeCommand extends LoggingCommandBase{
  private boolean intakeExtended = false;
  IntakeArm intakeArm;

  public IntakeArmConeCommand(IntakeArm intakeArm) {
    addRequirements(intakeArm);
    this.intakeArm = intakeArm;
  }

  public void execute() {
    intakeArm.intakeCone();
  }

  public boolean isIntakeExtended() {
    return intakeExtended;
  }

  public boolean isFinished(){
    return intakeArm.isIntakeCone();
  }
  }
