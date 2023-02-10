package frc.robot.commands;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;


public class ArmExtendCommand extends CommandBase{
  CANSparkMax armMotor = new CANSparkMax(12, MotorType.kBrushless);
   private boolean armExtended = false;
   Arm arm;


   public ArmExtendCommand(Arm arm){
   this.arm = arm;
   }

   public void execute(){
       arm.armExtend();
   }

   public boolean isArmExtended(){
     return armExtended; 
   }



} // <-- keep brace