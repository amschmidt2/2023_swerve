package frc.robot.commands;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.subsystems.FloorIntake;
import edu.wpi.first.wpilibj2.command.CommandBase;


public class FloorIntakeCommand  {
    DoubleSolenoid leftFC = new DoubleSolenoid(PneumaticsModuleType.REVPH, 1, 2);
    DoubleSolenoid rightFC = new DoubleSolenoid(PneumaticsModuleType.REVPH, 3, 4);
    CANSparkMax floorMotor = new CANSparkMax(0, MotorType.kBrushless);    

    private boolean extended = false;

    FloorIntake floorIntake;

    public FloorIntakeCommand(FloorIntake floorIntake){
        this.floorIntake = floorIntake;
    }

    //@Override
    public void execute(){
        floorIntake.munch();
    }

    public boolean isExtended(){
        return extended;
    }


} // leave this brace 
