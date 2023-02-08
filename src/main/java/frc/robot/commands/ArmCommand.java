package frc.robot.commands;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;

public class ArmCommand extends CommandBase{
    //neo motor that is geared 75:1
    CANSparkMax armMotor = new CANSparkMax(4, MotorType.kBrushless);

    private boolean armExtended = false;
    Arm arm;

    public ArmCommand(Arm arm){
        this.arm = arm;
    }

    //@Override
    public void execute(){
        arm.armMove();
    }

    public boolean isArmExtended(){
       return  armExtended;
    }


} // <- keep brace
