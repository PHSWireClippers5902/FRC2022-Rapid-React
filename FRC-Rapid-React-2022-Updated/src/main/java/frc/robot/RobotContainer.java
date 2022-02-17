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
// import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj.AnalogInput;

public class RobotContainer {

    //initializing subsystems
    public static MecanumSystem mecanumSystem = new MecanumSystem();
    public final FlyWheel m_flyWheelSystem = new FlyWheel();
    public final LinearActuator m_linearActuator = new LinearActuator();
    public final UltrasonicSystem m_uUltrasonicSystem = new UltrasonicSystem();

    // Xbox
  XboxController xbox = new XboxController(0);

  public RobotContainer(){
    m_flyWheelSystem.setDefaultCommand(new ActivateFlyWheel(-.1, m_flyWheelSystem));
    configureButtonBindings();
  }
  
  private void configureButtonBindings(){ 
    
    //Linear Actuator
    new JoystickButton(xbox, 4)//Y button
    .whileHeld(new ActivateLinearActuator(1.0, m_linearActuator)); //Activates a linear actuator
    new JoystickButton(xbox, 4).whenReleased(new ActivateLinearActuator(-1.0, m_linearActuator));
    
    //FlyWheel
    new JoystickButton(xbox, 3)
    .whenHeld(new ActivateFlyWheel(.25, m_flyWheelSystem));

    //Ultrasonic
    new JoystickButton(xbox, 1).whenPressed(new CheckDistance(m_uUltrasonicSystem));
    
  }

  public XboxController getXbox() {
    return xbox;
  }


    public static void init() {
        MecanumSystem.frontLeftWheel.configOpenloopRamp(0.5);
        MecanumSystem.frontRightWheel.configOpenloopRamp(0.5);
        MecanumSystem.backLeftWheel.configOpenloopRamp(0.5);
        MecanumSystem.backRightWheel.configOpenloopRamp(0.5);

    }
}