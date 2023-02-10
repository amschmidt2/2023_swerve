package frc.robot.commands;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ArmHoldCommand extends CommandBase{
Arm arm;

public ArmHoldCommand(Arm arm){
 this.arm = arm;
}

public void execute(){
    arm.armHold();
}

    



} // <-- keepy brace
