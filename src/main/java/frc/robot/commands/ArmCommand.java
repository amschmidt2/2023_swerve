package frc.robot.commands;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;


public class ArmCommand extends CommandBase{
    private CANSparkMax armMotor = new CANSparkMax(5, MotorType.kBrushless);
    private boolean armExtended = false;
    Arm arm;


    public ArmCommand(Arm arm){
    this.arm = arm;
    }

    public void execute(){
        arm.armMove();
    }



} // <-- keep brace