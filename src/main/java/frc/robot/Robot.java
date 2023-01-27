// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DataLogManager;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

// import subsystems here
import frc.robot.subsystems.MAXSwerveModule;
import frc.robot.subsystems.*;



public class Robot extends TimedRobot {
  // private Command m_autonomousCommand;

  // private RobotContainer m_robotContainer;
  
 
  @Override
  public void robotInit() {
    // if (RobotBase.isReal())
    
    //   DataLogManager.start();

    
    // m_robotContainer = new RobotContainer();


  }

  
  @Override
  public void robotPeriodic() {
    
    CommandScheduler.getInstance().run();

    // m_robotContainer.m_fieldSim.periodic();

    // m_robotContainer.periodic();

    // m_robotContainer.m_robotDrive.throttleValue = m_robotContainer.getThrottle();
   
  }

 
  @Override
  public void disabledInit() {
    String[] g = {"a","b","c"}; 
    SmartDashboard.putStringArray("g", g);
  }

  @Override
  public void disabledPeriodic() {
  }

  
  @Override
  public void autonomousInit() {
    
    // if (m_autonomousCommand != null) {
    //   m_autonomousCommand.schedule();
    // }
  }

  
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    
    // if (m_autonomousCommand != null) {
    //   m_autonomousCommand.cancel();
    // }

    
  }

  
  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
   
    CommandScheduler.getInstance().cancelAll();
  }

 
  @Override
  public void testPeriodic() {
  }

  @Override
  public void simulationPeriodic() {
    // m_robotContainer.m_fieldSim.periodic();
    // m_robotContainer.simulationPeriodic();
  }

}
