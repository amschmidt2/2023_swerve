// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.Collections;
import java.util.HashMap;

import com.pathplanner.lib.PathConstraints;
import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.PathPlannerTrajectory;
import com.pathplanner.lib.PathPlannerTrajectory.PathPlannerState;
import com.pathplanner.lib.commands.FollowPathWithEvents;
import com.pathplanner.lib.PathPoint;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.DriveConstants.ModulePosition;
import frc.robot.Constants.AutoConstants;
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

import frc.robot.commands.armPositions.ArmConeFloorCommand;
import frc.robot.commands.armPositions.ArmConeMidCommand;
import frc.robot.commands.armPositions.ArmConeHighCommand;
import frc.robot.commands.armPositions.ArmCubeConveyCommand;
import frc.robot.commands.armPositions.ArmCubeFloorCommand;
import frc.robot.commands.armPositions.ArmCubeMidCommand;
import frc.robot.commands.armPositions.ArmCubeHighCommand;
import frc.robot.commands.armPositions.ArmHumanConeCommand;
import frc.robot.commands.armPositions.ArmHumanCubeCommand;
import frc.robot.commands.auto.BasicAuto;
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
  static Joystick secondLeftJoystick = new Joystick(OIConstants.kDriverControllerPort);
  static Joystick secondRightJoystick = new Joystick(OIConstants.kDriverControllerPort);

  // The drivers controller
  private XboxController m_DriverController = new XboxController(OIConstants.kCoDriverControllerPort);
  final GamepadButtons driver = new GamepadButtons(m_DriverController, true);
  static Joystick leftJoystick = new Joystick(OIConstants.kCoDriverControllerPort);
  static Joystick rightJoystick = new Joystick(OIConstants.kCoDriverControllerPort);

  
  Compressor compressor = new Compressor();
  Arm arm = new Arm();
  Conveyor conveyor = new Conveyor();
  IntakeArm intakeArm = new IntakeArm();
  FloorIntake floorIntake = new FloorIntake();
  SetSwerveDrive setSwerveDrive = new SetSwerveDrive(m_robotDrive, null, null, null);


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
     
    // Regular Swerve Drive Controls
      //  m_robotDrive.setDefaultCommand(
      //  new SetSwerveDrive(
      //      m_robotDrive,
      //      () -> leftJoystick.getRawAxis(1),
      //      () -> leftJoystick.getRawAxis(0),
      //      () -> rightJoystick.getRawAxis(4)));

    // Ajax's controller outputs --> might need to change and look at :/
        m_robotDrive.setDefaultCommand(
          new SetSwerveDrive(
            m_robotDrive,
            () -> -leftJoystick.getRawAxis(5),  // 0
            () -> -rightJoystick.getRawAxis(4), //4
            () -> -rightJoystick.getRawAxis(0)  //5
            )
          );
          
        

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

      /*
       * 
       * CONTROL CENTER 
       * DRIVERS AD GUNNER BUTTONS
       * 
       */

      // Drivers Buttons (Cap Buttons)
      JoystickButton d_Button_X = new JoystickButton(leftJoystick,4);
      JoystickButton d_Button_A = new JoystickButton(leftJoystick, 2);
      JoystickButton d_Button_Y = new JoystickButton(leftJoystick, 3);
      JoystickButton d_Button_B = new JoystickButton(leftJoystick, 1);
      JoystickButton d_rightBumper = new JoystickButton(leftJoystick, 5);
      JoystickButton d_leftBumper = new JoystickButton(leftJoystick, 6);
        //JoystickButton button_7 = new JoystickButton(leftJoystick, 7);  
        
      // ***********************************************************

      // Gunners Buttons (lowerCase buttons)
      JoystickButton g_OneButt = new JoystickButton(secondLeftJoystick, 1);
      JoystickButton g_TwoButt = new JoystickButton(secondLeftJoystick, 2);
      JoystickButton g_ThreeButt = new JoystickButton(secondLeftJoystick, 3);
      JoystickButton g_FourButt = new JoystickButton(secondLeftJoystick, 4);
      JoystickButton g_FiveButt = new JoystickButton(secondLeftJoystick, 5);
      JoystickButton g_SixButt = new JoystickButton(secondLeftJoystick, 6);
      JoystickButton g_SevenButt = new JoystickButton(secondLeftJoystick, 7);
      JoystickButton g_EightButt = new JoystickButton(secondLeftJoystick, 8);
      JoystickButton g_NineButt = new JoystickButton(secondLeftJoystick, 9);
      JoystickButton g_TenButt = new JoystickButton(secondLeftJoystick, 10);
      JoystickButton g_ElevButt = new JoystickButton(secondLeftJoystick, 11);
      JoystickButton g_TwelButt = new JoystickButton(secondLeftJoystick, 12);

      /*
       *
       *  DRIVER AND GUNNERS BUTTONS COMMANDS
       * 
       */

       
      // Gunner Commands
      // Cone Outputs
      g_OneButt.onTrue(new ArmConeHighCommand(arm));

      g_FiveButt.onTrue(new ArmConeMidCommand(arm));

      g_NineButt.onTrue(new ArmConeFloorCommand(arm)); 

      g_ThreeButt.onTrue(new ArmHumanConeCommand(arm));
      g_ThreeButt.onTrue(new IntakeArmConeCommand(intakeArm));
      g_ThreeButt.onFalse(new IntakeArmStopCommand(intakeArm));

      g_SevenButt.onTrue(new IntakeArmConeExtractCommand(intakeArm));
      g_SevenButt.onFalse(new IntakeArmStopCommand(intakeArm));

      // Cube Outputs
      g_TwoButt.onTrue(new ArmCubeHighCommand(arm));

      g_SixButt.onTrue(new ArmCubeMidCommand(arm));

      g_TenButt.onTrue(new ArmCubeFloorCommand(arm));

      g_FourButt.onTrue(new ArmHumanCubeCommand(arm));
      g_FourButt.onTrue(new IntakeArmCubeCommand(intakeArm));

      g_EightButt.onTrue(new IntakeArmCubeExtractCommand(intakeArm));
      g_EightButt.onFalse(new IntakeArmStopCommand(intakeArm));

      g_TwelButt.onTrue(new ArmCubeConveyCommand(arm));
      g_TwelButt.onTrue(new IntakeArmCubeCommand(intakeArm));
      g_TwelButt.onTrue(new ConveyorGoCommand(conveyor));
      g_TwelButt.onFalse(new ConveyorStopCommand(conveyor));
      g_TwelButt.onFalse(new IntakeArmStopCommand(intakeArm));

     
      // ******************************************************* 
      

      //Drivers Commands 
      d_Button_X.onTrue(new ToggleFieldOriented(m_robotDrive));

      d_leftBumper.onTrue(new CompressorCommandExtend(compressor));
      d_leftBumper.onFalse(new CompressorCommandRetract(compressor));
      d_leftBumper.onTrue(new FloorIntakeFartCommand(floorIntake));
      d_leftBumper.onFalse(new FloorIntakeStopCommand(floorIntake));

      // d_rightBumper.onTrue(new CompressorCommandRetract(compressor));
      // d_rightBumper.onTrue(new FloorIntakeCollectCommand(floorIntake));
      // d_rightBumper.onFalse(new FloorIntakeStopCommand(floorIntake));


      // ***********************************************************


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
    m_autoChooser.addOption("BasicAuto", new BasicAuto(m_robotDrive));

    SmartDashboard.putData("Basic Auto", m_autoChooser);
    ProfiledPIDController thetaController =
        new ProfiledPIDController(
            AutoConstants.kPThetaController,
            0,
            0,
            AutoConstants.kThetaControllerConstraints);
    thetaController.enableContinuousInput(-Math.PI, Math.PI);

    // PathPlannerTrajectory autoBlue01Path = PathPlanner.loadPath(
    //         "Blue0(1)",
    //         AutoConstants.kMaxSpeedMetersPerSecond,
    //         AutoConstants.kMaxAngularSpeedRadiansPerSecondSquared);

    // PathPlannerTrajectory autoBlue02Path = PathPlanner.loadPath(
    //         "Blue0(2)",
    //         AutoConstants.kMaxSpeedMetersPerSecond,
    //         AutoConstants.kMaxAccelerationMetersPerSecondSquared);

    // Command autoTest = new SequentialCommandGroup(new FollowPathWithEvents(setSwerveDrive, Collections.emptyList(), Collections.emptyMap()));

    PathPlannerTrajectory traj1 = PathPlanner.generatePath(
      new PathConstraints(4, 3), 
      new PathPoint(new Translation2d(1.0, 1.0), Rotation2d.fromDegrees(0)), // position, heading
      new PathPoint(new Translation2d(3.0, 3.0), Rotation2d.fromDegrees(45)) // position, heading
    );
    Command followCommand = m_robotDrive.followTrajectoryCommand(traj1, true);


    m_autoChooser.setDefaultOption("Do Nothing", new WaitCommand(0));
    m_autoChooser.addOption("Test", followCommand);
    // m_autoChooser.addOption("Drive Forward", new DriveForward(m_robotDrive));
    // m_autoChooser.addOption("5 Ball Auto", new FiveBallAuto(m_robotDrive));

    SmartDashboard.putData("Auto Selector", m_autoChooser);

  }
  
  // look at
  // private Command getPathFollowingCommand(PathPlannerTrajectory testPathTwo) {
  //   return null;
  // }

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