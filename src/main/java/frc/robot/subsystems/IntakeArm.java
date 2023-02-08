package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class IntakeArm{
private CANSparkMax intakeMotor = new CANSparkMax(11, MotorType.kBrushless);
private int intakeCurrentLimit = 25;
private int intakeHoldCurrentLimit = 5;
private double intakeOutputPower = 1.0;
private double intakeHoldPower = 0.07;

private boolean intakeExtended = false; 
private int cone = 1;
private int cube = 2;
private int lastGamePiece;
private double intakePower;
private int intakeAmps;

public IntakeArm(){

}

public void setIntakeMotor(double percent, int amps){
    intakeMotor.set(percent);
}

public void intakeCube(){
    if(intakeExtended == true){
        intakePower = intakeOutputPower;
        intakeAmps = intakeCurrentLimit;
        lastGamePiece = cube;
    }
    else if(lastGamePiece == cube){
        intakePower = intakeHoldPower;
        intakeAmps = intakeHoldCurrentLimit; 
    }
    else{
        intakePower = 0.0;
        intakeAmps = 0;
    }
    setIntakeMotor(intakePower, intakeAmps);
}

public void intakeCone(){
    if(intakeExtended == true){
        intakePower = -intakeOutputPower;
        intakeAmps = intakeCurrentLimit;
        lastGamePiece = cone;
    }
    else if(lastGamePiece == cone){
        intakePower = -intakeHoldPower;
        intakeAmps = intakeHoldCurrentLimit;
    }
    else{
        intakePower = 0.0;
        intakeAmps = 0; 
    }
    setIntakeMotor(intakePower, intakeAmps);
}




} //<-- leave brace