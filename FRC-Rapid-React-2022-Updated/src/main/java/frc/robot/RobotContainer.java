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


    //creating motor controllers
    public static WPI_TalonSRX frontRightWheel = new WPI_TalonSRX(7);
    public static WPI_TalonSRX frontLeftWheel = new WPI_TalonSRX(4);
    public static WPI_TalonSRX backRightWheel = new WPI_TalonSRX(3);
    public static WPI_TalonSRX backLeftWheel = new WPI_TalonSRX(6);

    public static WPI_TalonSRX testMotor = new WPI_TalonSRX(5);
    public static CANSparkMax spark = new CANSparkMax(9, MotorType.kBrushless);
    public static CANSparkMax spark2 = new CANSparkMax(8, MotorType.kBrushless);

    //Sensors
    public static AnalogInput ultrasonic = new AnalogInput(0);


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
    
  }

  public XboxController getXbox() {
    return xbox;
  }


    public static void init() {
        frontLeftWheel.configOpenloopRamp(0.5);
        frontRightWheel.configOpenloopRamp(0.5);
        backLeftWheel.configOpenloopRamp(0.5);
        backRightWheel.configOpenloopRamp(0.5);

    }
}