package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;


public class IntakeArm extends SubsystemBase {
    private CANSparkMax intakeMotor = new CANSparkMax(11, MotorType.kBrushless); // 12
    private int intakeCurrentLimit = 25;
    private int intakeHoldCurrentLimit = 5;
    private double intakeOutputPower = 0.6;
    private double intakeHoldPower = 0.07;

    private boolean intakeExtended = false; 
    private int cone = 1;
    private int cube = 2;
    private int lastGamePiece;
    private double intakePower;
    private int intakeAmps;
    DigitalInput lineBreak = new DigitalInput(1); //Might need to change  


    public IntakeArm(){

    }

    public void setIntakeMotor(double percent, int amps){
        intakeMotor.set(percent);
    }

    public void intakeCube(){
        intakePower = intakeOutputPower;
        intakeAmps = intakeCurrentLimit;
        lastGamePiece = cube;
        setIntakeMotor(intakePower, intakeAmps);
    }

    public void intakeCone(){
        intakePower = -intakeOutputPower;
        intakeAmps = intakeCurrentLimit;
        lastGamePiece = cone;
        setIntakeMotor(intakePower, intakeAmps);
    }

    public void stopArmIntake(){
        intakePower = 0;
        intakeAmps = 0;  
        setIntakeMotor(intakePower, intakeAmps);
    }

    public void extractCone(){
        intakePower = intakeOutputPower;
        intakeAmps = -intakeCurrentLimit;
        setIntakeMotor(intakePower, intakeAmps);
    }

    public void extractCube(){
        intakePower = -intakeOutputPower;
        intakeAmps = -intakeCurrentLimit;
        setIntakeMotor(intakePower, intakeAmps);
    }

}    // leave brace