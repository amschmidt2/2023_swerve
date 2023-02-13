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
import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.PathPlannerTrajectory;
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
import frc.robot.subsystems.Compressor; 
//import frc.robot.commands.CompressorCommandExtend;
//import frc.robot.commands.CompressorCommandRetract;
import frc.robot.commands.IntakeArmConeCommand;
import frc.robot.commands.IntakeArmCubeCommand;
import frc.robot.commands.IntakeArmStopCommand;

import frc.robot.subsystems.Arm;
import frc.robot.commands.ArmColaspeCommand;
import frc.robot.commands.ArmExtendCommand;
import frc.robot.commands.ArmHoldCommand;

import frc.robot.commands.CompressorCommandExtend;
import frc.robot.commands.CompressorCommandRetract;
//import frc.robot.commands.IntakeArmCommand;
import frc.robot.subsystems.IntakeArm;
import frc.robot.subsystems.Conveyor; 

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

  // The driver's controller

  static Joystick leftJoystick = new Joystick(OIConstants.kDriverControllerPort);
  static Joystick rightJoystick = new Joystick(OIConstants.kDriverControllerPort);

  private XboxController m_coDriverController = new XboxController(OIConstants.kCoDriverControllerPort);

  final GamepadButtons driver = new GamepadButtons(m_coDriverController, true);
  //final GamepadButtons gunner = new GamepadButtons(m_coDriverController, true); 
  
  Compressor compressor = new Compressor();
  Arm arm = new Arm();
  Conveyor conveyor = new Conveyor();
  IntakeArm intakeArm = new IntakeArm();

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


        JoystickButton button_8 = new JoystickButton(leftJoystick,8);
        //JoystickButton button_7 = new JoystickButton(leftJoystick, 7);  
        JoystickButton X_button = new JoystickButton(leftJoystick, 4);
        JoystickButton A_button = new JoystickButton(leftJoystick, 2);     
        JoystickButton leftBumper = new JoystickButton(leftJoystick, 5);
        JoystickButton rightBumper = new JoystickButton(leftJoystick, 6);
        //JoystickButton Y_button = new JoystickButton(leftJoystick, 4);
        JoystickButton B_button = new JoystickButton(leftJoystick, 1);

      X_button.onTrue(new CompressorCommandExtend(compressor));
      X_button.onFalse(new CompressorCommandRetract(compressor));
      A_button.onTrue(new IntakeArmCubeCommand(intakeArm));
      A_button.onFalse(new IntakeArmStopCommand(intakeArm));
      B_button.onTrue(new IntakeArmConeCommand(intakeArm));
      B_button.onFalse(new IntakeArmStopCommand(intakeArm));
      leftBumper.onTrue(new ArmExtendCommand(arm));
      leftBumper.onFalse(new ArmHoldCommand(arm));
      rightBumper.onTrue(new ArmColaspeCommand(arm));
      rightBumper.onFalse(new ArmHoldCommand(arm)); 
        button_8.onTrue(new ToggleFieldOriented(m_robotDrive));
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
