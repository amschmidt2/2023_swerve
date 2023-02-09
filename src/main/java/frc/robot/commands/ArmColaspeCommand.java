package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.subsystems.Arm;


public class ArmColaspeCommand extends CommandBase{
    CANSparkMax armMotor = new CANSparkMax(10, MotorType.kBrushless);
    private boolean armExtended = false;
    Arm arm;


    public ArmColaspeCommand(Arm arm){
        this.arm = arm;
    }

    public void execute(){
        arm.armColapse();
    }

    public boolean isArmExtended(){
        return armExtended; 
    }




} // <-- keep brace 