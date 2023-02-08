package frc.robot.commands;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeArm;

public class IntakeArmCommand extends CommandBase{
    CANSparkMax intakeMotor = new CANSparkMax(5, MotorType.kBrushless);
    private boolean intakeExtended = false;
    IntakeArm intakeArm;

    public IntakeArmCommand(IntakeArm intakeArm){
        this.intakeArm = intakeArm;
    }
    
    public void execute(){
        intakeArm.intakeCone();
    }

    public boolean isIntakeExtended(){
        return intakeExtended;
    }
    

} // <-- keep brace 
