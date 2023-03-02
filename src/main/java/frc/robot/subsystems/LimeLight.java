package frc.robot.subsystems;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class LimeLight extends SubsystemBase{
    public NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    public NetworkTableEntry tx = table.getEntry("tx");
    public NetworkTableEntry ty = table.getEntry("ty");
    public NetworkTableEntry ta = table.getEntry("ta");
    public double le_angles[] = {0,0};

    public LimeLight(){
        
    }

    public void calculate(){
        vogue();
       // SmartDashboard.putNumber("Limelight_Vision0", le_angles[0]);
       // SmartDashboard.putNumber("Limelight_Vision1", le_angles[1]);
    }

    public void vogue(){
        le_angles[0] = tx.getDouble(0.0);
        le_angles[1] = ty.getDouble(0.0);
    }

    public double[] angles(){
        return le_angles;
    }

    public void lights(boolean on){
        if(on){
            table.getEntry("ledMode").setNumber(3);
        }
        else{
            table.getEntry("ledMode").setNumber(1);
        }
    }




} // <-- keep Brace
