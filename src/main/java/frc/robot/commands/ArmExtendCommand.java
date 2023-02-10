package frc.robot.commands;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;


public class ArmExtendCommand extends CommandBase{
  CANSparkMax armMotor = new CANSparkMax(12, MotorType.kBrushless);
   private boolean armExtended = false;
   private double armPower = 0; 
   Arm arm;


   public ArmExtendCommand(Arm arm){
   this.arm = arm;
   }

   public void execute(){
      if(armExtended == true){
            arm.armExtend();
            System.out.println("Can you see me?" + getClass());
      } 
      else{
            arm.setArmMotor(armPower);
      }
   }

   public boolean isArmExtended(){
     return armExtended; 
   }



} // <-- keep brace