package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

public abstract class LoggingCommandBase extends CommandBase {
    @Override
    public void initialize() {
        System.out.println("Initializing the " + this.getClass().getName());
    }
}
