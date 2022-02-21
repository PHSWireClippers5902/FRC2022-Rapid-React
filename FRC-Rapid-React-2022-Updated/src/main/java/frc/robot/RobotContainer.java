package frc.robot;

//Spark Imports
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Ultrasonic;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.subsystems.*;
import frc.robot.commands.*;

import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import static frc.robot.Constants.ControllerConstants;
import static frc.robot.Constants.AimConstants;


import edu.wpi.first.wpilibj.AnalogInput;

public class RobotContainer {

    //initializing subsystems
    private final MecanumSystem m_mecanumSystem = new MecanumSystem();
    private final FlyWheel m_flyWheelSystem = new FlyWheel();
    private final LinearActuator m_linearActuator = new LinearActuator();
    private final UltrasonicSystem m_uUltrasonicSystem = new UltrasonicSystem();
    private final AimSystem m_aimSystem = new AimSystem();

    // Xbox
    XboxController xbox = new XboxController(ControllerConstants.ControllerPort);

  public RobotContainer(){
    m_flyWheelSystem.setDefaultCommand(new ActivateFlyWheel(-.1, m_flyWheelSystem));
    m_mecanumSystem.setDefaultCommand(new RunCommand(m_mecanumSystem::driveWithMecanum, m_mecanumSystem));
    configureButtonBindings();
  }
  
  private void configureButtonBindings(){ 
    //Linear Actuator
    new JoystickButton(xbox, ControllerConstants.Y)
    .whileHeld(new ActivateLinearActuator(1.0, m_linearActuator))
    .whenReleased(new ActivateLinearActuator(-1.0, m_linearActuator))
    .whenHeld(new ActivateFlyWheel(.25, m_flyWheelSystem));

    //Ultrasonic
    new JoystickButton(xbox, ControllerConstants.A)
    .whenPressed(new CheckDistance(m_uUltrasonicSystem));

    //Aim
    new JoystickButton(xbox, ControllerConstants.B)
    .toggleWhenPressed(new StartEndCommand(
      () -> {m_aimSystem.aimTo(AimConstants.MotorUpPosition);},
      () -> {m_aimSystem.aimTo(AimConstants.MotorDownPosition);},
      m_aimSystem));
  }

  public XboxController getXbox() {
    return xbox;
  }
}