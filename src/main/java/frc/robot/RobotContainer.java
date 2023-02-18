// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.DriveConstants.ModulePosition;
import frc.robot.Constants.OIConstants;
import frc.robot.commands.ToggleFieldOriented;
// import frc.robot.commands.auto.DriveForward;
// import frc.robot.commands.auto.FiveBallAuto;
import frc.robot.commands.swerve.JogDriveModule;
import frc.robot.commands.swerve.JogTurnModule;
import frc.robot.commands.swerve.PositionTurnModule;
import frc.robot.commands.swerve.SetSwerveDrive;
import frc.robot.simulation.FieldSim;
//import subsystems here
import frc.robot.subsystems.DriveSubsystem;
//import frc.robot.commands.CompressorCommandExtend;
//import frc.robot.commands.CompressorCommandRetract;

import frc.robot.subsystems.IntakeArm;
import frc.robot.commands.IntakeArmConeCommand;
import frc.robot.commands.IntakeArmCubeCommand;
import frc.robot.commands.IntakeArmStopCommand;
import frc.robot.commands.IntakeArmConeExtractCommand;
import frc.robot.commands.IntakeArmCubeExtractCommand;

import frc.robot.subsystems.Arm;
import frc.robot.commands.ArmColaspeCommand;
import frc.robot.commands.ArmExtendCommand;
import frc.robot.commands.ArmHoldCommand;

import frc.robot.subsystems.Compressor; 
import frc.robot.commands.CompressorCommandExtend;
import frc.robot.commands.CompressorCommandRetract;
import frc.robot.commands.CompressorCommandStop;

import frc.robot.subsystems.Conveyor; 
import frc.robot.commands.ConveyorGoCommand;
import frc.robot.commands.ConveyorReverseCommand;
import frc.robot.commands.ConveyorStopCommand;

import frc.robot.subsystems.FloorIntake;
import frc.robot.commands.FloorIntakeCollectCommand;
import frc.robot.commands.FloorIntakeFartCommand;
import frc.robot.commands.FloorIntakeStopCommand;

/*
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems
  final DriveSubsystem m_robotDrive = new DriveSubsystem();

  public final FieldSim m_fieldSim = new FieldSim(m_robotDrive);

  private final SendableChooser<Command> m_autoChooser = new SendableChooser<Command>();

  // The gunners controller
  private XboxController m_coDriverController = new XboxController(OIConstants.kCoDriverControllerPort);
  final GamepadButtons gunner = new GamepadButtons(m_coDriverController, true);
  static Joystick leftJoystick = new Joystick(OIConstants.kDriverControllerPort);
  static Joystick rightJoystick = new Joystick(OIConstants.kDriverControllerPort);

  // The drivers controller
  private XboxController m_DriverController = new XboxController(OIConstants.kCoDriverControllerPort);
  final GamepadButtons driver = new GamepadButtons(m_DriverController, true);
  static Joystick secondLeftJoystick = new Joystick(OIConstants.kCoDriverControllerPort);
  static Joystick secondRightJoystick = new Joystick(OIConstants.kCoDriverControllerPort);

  
  Compressor compressor = new Compressor();
  Arm arm = new Arm();
  Conveyor conveyor = new Conveyor();
  IntakeArm intakeArm = new IntakeArm();
  FloorIntake floorIntake = new FloorIntake();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Preferences.removeAll();
    Pref.deleteUnused();
    Pref.addMissing();
    SmartDashboard.putData("Scheduler", CommandScheduler.getInstance());
    // Configure the button bindings

    m_fieldSim.initSim();
    initializeAutoChooser();
    // sc.showAll();
    // Configure default commands
  // m_robotDrive.setDefaultCommand(
        // The left stick controls translation of the robot.
        // Turning is controlled by the X axis of the right stick.
        // new SetSwerveDrive(
         //m_robotDrive,

        // () -> -m_coDriverController.getRawAxis(1),
         //() -> -m_coDriverController.getRawAxis(0),
         //() -> -m_coDriverController.getRawAxis(4)));
       m_robotDrive.setDefaultCommand(
        new SetSwerveDrive(
            m_robotDrive,
           () -> leftJoystick.getRawAxis(1),
           () -> leftJoystick.getRawAxis(0),
           () -> rightJoystick.getRawAxis(4)));
        
        //Ajax Controls 
          //  m_robotDrive.setDefaultCommand(
           //   new SetSwerveDrive(
           //     m_robotDrive,
           //     () -> leftJoystick.getRawAxis(5),
            //    () -> rightJoystick.getRawAxis(4),
            //    () -> rightJoystick.getRawAxis(0)));

    // Ajax's controller outputs --> might need to change and look at :/
      //  m_robotDrive.setDefaultCommand(
      //    new SetSwerveDrive(
      //      m_robotDrive,
      //      () -> leftJoystick.getRawAxis(0);
      //      () -> rightJoystick.getRawAxis(4);
      //      () -> rightJoystick.getRawAxis(5);
      //    )
      //  )

   // driver.leftTrigger.whileHeld(new JogTurnModule(
      //  m_robotDrive,
     //   () -> -m_coDriverController.getRawAxis(1),
     //   () -> m_coDriverController.getRawAxis(0),
     //   () -> m_coDriverController.getRawAxis(2),
     //   () -> m_coDriverController.getRawAxis(3)));

    // individual modules
    //driver.leftBumper.whileHeld(new JogDriveModule(
     //   m_robotDrive,
      //  () -> -m_coDriverController.getRawAxis(1),
     //   () -> m_coDriverController.getRawAxis(0),
     //   () -> m_coDriverController.getRawAxis(2),
      //  () -> m_coDriverController.getRawAxis(3),
      //  true));

    // all modules
    //driver.rightBumper.whileHeld(new JogDriveModule(
      //  m_robotDrive,
      //  () -> -m_coDriverController.getRawAxis(1),
      //  () -> m_coDriverController.getRawAxis(0),
      //  () -> m_coDriverController.getRawAxis(2),
      //  () -> m_coDriverController.getRawAxis(3),
      //  false));

      // Drivers Buttons (Cap Buttons)
      JoystickButton d_Button_X = new JoystickButton(secondLeftJoystick,3);
      JoystickButton d_Button_A = new JoystickButton(secondLeftJoystick, 1);
      JoystickButton d_Button_Y = new JoystickButton(secondLeftJoystick, 4);
      JoystickButton d_Button_B = new JoystickButton(secondLeftJoystick, 2);
      JoystickButton d_rightBumper = new JoystickButton(secondLeftJoystick, 5);
      JoystickButton d_leftBumper = new JoystickButton(secondLeftJoystick, 6);
      JoystickButton d_tinyLines = new JoystickButton(secondLeftJoystick, 7);

        //JoystickButton button_7 = new JoystickButton(leftJoystick, 7);  
        
      // Gunners Buttons (lowerCase buttons)
      JoystickButton g_Button_B = new JoystickButton(leftJoystick, 2); 
      JoystickButton g_Button_X = new JoystickButton(leftJoystick, 3);
      JoystickButton g_Button_A = new JoystickButton(leftJoystick, 1);  
      JoystickButton g_Button_Y = new JoystickButton(leftJoystick, 4);   
      JoystickButton g_leftBumper = new JoystickButton(leftJoystick, 5);
      JoystickButton g_rightBumper = new JoystickButton(leftJoystick, 6);
      //JoystickButton Y_button = new JoystickButton(leftJoystick, 4);
      
      JoystickButton g_ttt = new JoystickButton(leftJoystick, 7);
      JoystickButton g_tinyLines = new JoystickButton(leftJoystick, 8);

      // Gunner Commands
      g_Button_A.onTrue(new IntakeArmCubeCommand(intakeArm));
      g_Button_A.onFalse(new IntakeArmStopCommand(intakeArm));

      g_Button_B.onTrue(new IntakeArmConeCommand(intakeArm));
      g_Button_B.onFalse(new IntakeArmStopCommand(intakeArm));

      g_leftBumper.onTrue(new ArmExtendCommand(arm));
      g_leftBumper.onFalse(new ArmHoldCommand(arm));

      g_ttt.onTrue(new IntakeArmConeExtractCommand(intakeArm));
      g_ttt.onFalse(new IntakeArmStopCommand(intakeArm));

      g_tinyLines.onTrue(new IntakeArmCubeExtractCommand(intakeArm));
      g_tinyLines.onFalse(new IntakeArmStopCommand(intakeArm));

      g_rightBumper.onTrue(new ArmColaspeCommand(arm));
      g_rightBumper.onFalse(new ArmHoldCommand(arm)); 

      //Drivers Commands 
      d_rightBumper.onTrue(new ToggleFieldOriented(m_robotDrive));

      //group (dirction --> Convy, out)
      d_Button_Y.onTrue(new ConveyorGoCommand(conveyor));
      d_Button_Y.onFalse(new ConveyorStopCommand(conveyor));

      //group (direction --> Floor, out /Convey, out) (Hitting Floor Goal)
      d_Button_B.onTrue(new FloorIntakeFartCommand(floorIntake));
      d_Button_B.onFalse(new FloorIntakeStopCommand(floorIntake));

      d_Button_B.onTrue(new ConveyorReverseCommand(conveyor));
      d_Button_B.onFalse(new ConveyorStopCommand(conveyor));

     // group (direction --> Floor & Comp, Out) (Collect)
      d_Button_A.onTrue(new CompressorCommandExtend(compressor));
      d_Button_A.onFalse(new CompressorCommandStop(compressor));
      d_Button_A.onTrue(new FloorIntakeCollectCommand(floorIntake));
      d_Button_A.onFalse(new FloorIntakeStopCommand(floorIntake));

      //d_Button_A.onTrue(new FloorIntakeCollectCommand(floorIntake));
      //d_Button_A.onFalse(new FloorIntakeStopCommand(floorIntake));

      // group (direction --> Floor, In / Comp, In / Convey, In)
      d_Button_X.onTrue(new FloorIntakeCollectCommand(floorIntake));
      d_Button_X.onFalse(new FloorIntakeStopCommand(floorIntake));
      d_Button_X.onTrue(new CompressorCommandRetract(compressor));
      d_Button_X.onFalse(new CompressorCommandStop(compressor));
      d_Button_X.onTrue(new ConveyorGoCommand(conveyor));
      d_Button_X.onFalse(new ConveyorReverseCommand(conveyor));



    // position turn modules individually
    // driver.X_button.whenPressed(new PositionTurnModule(m_robotDrive,
    // ModulePosition.FRONT_LEFT));
    // driver.A_button.whenPressed(new PositionTurnModule(m_robotDrive,
    // ModulePosition.FRONT_RIGHT));
    // driver.B_button.whenPressed(new PositionTurnModule(m_robotDrive,
    // ModulePosition.BACK_LEFT));
    // driver.Y_button.whenPressed(new PositionTurnModule(m_robotDrive,
    // ModulePosition.BACK_RIGHT));

  }

  private void initializeAutoChooser() {
    m_autoChooser.setDefaultOption("Do Nothing", new WaitCommand(0));
    // m_autoChooser.addOption("Drive Forward", new DriveForward(m_robotDrive));
    // m_autoChooser.addOption("5 Ball Auto", new FiveBallAuto(m_robotDrive));

    SmartDashboard.putData("Auto Selector", m_autoChooser);

  }

  public void simulationPeriodic() {
    m_fieldSim.periodic();
    periodic();
  }

  public void periodic() {
    m_fieldSim.periodic();
  }

  public double getThrottle() {
    return -leftJoystick.getThrottle();
  }

  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoChooser.getSelected();
  }

}
