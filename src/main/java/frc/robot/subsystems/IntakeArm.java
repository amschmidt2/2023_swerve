package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.RelativeEncoder; 

public class IntakeArm extends SubsystemBase {
    private CANSparkMax intakeMotor;
    RelativeEncoder jr_spyeye_coder;
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
    private int counter = 0;

    public IntakeArm(){
        intakeMotor = new CANSparkMax(11, MotorType.kBrushless); // 12
        jr_spyeye_coder = intakeMotor.getEncoder();

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

    public boolean isIntakeingCube(){
        double position = jr_spyeye_coder.getPosition();
        if(position > 22){
            return true;
        }
        return false;
    }

    public void intakeCone(){
        intakePower = -intakeOutputPower;
        intakeAmps = intakeCurrentLimit;
        lastGamePiece = cone;
        setIntakeMotor(intakePower, intakeAmps);
    }

    public void resetPosition() {
        jr_spyeye_coder.setPosition(0.0);
    }

    public void stopArmIntake(){
        intakePower = 0;
        intakeAmps = 0;  
        setIntakeMotor(intakePower, intakeAmps);
    }

    public boolean isArmIntakeStop(){
        double position = jr_spyeye_coder.getPosition();
        if (counter++ % 10 == 0) {
            System.out.println("Intake arm position: " + position);
        }
        double threshold = 0.01;
        return Math.abs(position) < threshold;
    }



    public void extractCone(){
        intakePower = intakeOutputPower;
        intakeAmps = -intakeCurrentLimit;
        setIntakeMotor(intakePower, intakeAmps);
    }

    public boolean isExtractingCone(){
        double position = jr_spyeye_coder.getPosition();
        if (counter++ % 10 == 0) {
            System.out.println("isExtractingCone position: " + position);
        }
        if(position > 21){
            return true;
        }
        return false;
    }


    public void extractCube(){
        intakePower = -intakeOutputPower;
        intakeAmps = -intakeCurrentLimit;
        setIntakeMotor(intakePower, intakeAmps);
    }

}    // leave brace