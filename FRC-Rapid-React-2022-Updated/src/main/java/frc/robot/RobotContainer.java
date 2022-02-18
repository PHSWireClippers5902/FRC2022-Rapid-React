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
// import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj.AnalogInput;

public class RobotContainer {

    //initializing subsystems
    private final MecanumSystem m_mecanumSystem = new MecanumSystem();
    private final FlyWheel m_flyWheelSystem = new FlyWheel();
    private final LinearActuator m_linearActuator = new LinearActuator();
    private final UltrasonicSystem m_uUltrasonicSystem = new UltrasonicSystem();
    private final AimSystem m_aimSystem = new AimSystem();

    // Xbox
  XboxController xbox = new XboxController(0);

  public RobotContainer(){
    m_flyWheelSystem.setDefaultCommand(new ActivateFlyWheel(-.1, m_flyWheelSystem));
    m_mecanumSystem.setDefaultCommand(new RunCommand(m_mecanumSystem::driveWithMecanum, m_mecanumSystem));
    configureButtonBindings();
  }
  
  private void configureButtonBindings(){ 
    //Put button number -> button in constants files?
    //Linear Actuator
    new JoystickButton(xbox, 4)//Y button
    .whileHeld(new ActivateLinearActuator(1.0, m_linearActuator)); //Activates a linear actuator
    new JoystickButton(xbox, 4).whenReleased(new ActivateLinearActuator(-1.0, m_linearActuator));
    
    //FlyWheel
    new JoystickButton(xbox, 4)
    .whenHeld(new ActivateFlyWheel(.25, m_flyWheelSystem));

    //Ultrasonic
    new JoystickButton(xbox, 1).whenPressed(new CheckDistance(m_uUltrasonicSystem));

    //Aim
    new JoystickButton(xbox, 2).toggleWhenPressed(new StartEndCommand(
      onInit, onEnd, requirements))
    
  }

  public XboxController getXbox() {
    return xbox;
  }
}