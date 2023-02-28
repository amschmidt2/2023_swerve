package frc.robot.commands.armPositions;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ArmExtendCommand extends CommandBase {
      private boolean armExtended = false;
      private double armPower = 0;
      Arm arm;

      public ArmExtendCommand(Arm arm) {
            addRequirements(arm);
            this.arm = arm;
      }

      public void execute() {
            arm.armExtend();
      }

      public boolean isArmExtended() {
            return armExtended;
      }

} // <-- keep brace