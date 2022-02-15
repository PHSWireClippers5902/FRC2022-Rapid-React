package frc.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
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

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj.AnalogInput;

public class RobotContainer {

    //initializing subsystems
    public static MecanumSystem mecanumSystem = new MecanumSystem();
    private final LightSystem m_lightSystem = new LightSystem();
    public final FlyWheel m_flyWheelSystem = new FlyWheel();
    public final UltrasonicSystem m_ultrasonicSystem = new UltrasonicSystem();

    //creating motor controllers
    public static WPI_TalonSRX frontRightWheel = new WPI_TalonSRX(8);
    public static WPI_TalonSRX frontLeftWheel = new WPI_TalonSRX(3);
    public static WPI_TalonSRX backRightWheel = new WPI_TalonSRX(4);
    public static WPI_TalonSRX backLeftWheel = new WPI_TalonSRX(1);

    public static WPI_TalonSRX testMotor = new WPI_TalonSRX(5);

    public static SpeedController lightsR;
    public static SpeedController lightsL;

    //Sensors
    public static AnalogInput ultrasonic = new AnalogInput(0);


    // Xbo
  XboxController xbox = new XboxController(0);

  public RobotContainer(){
    configureButtonBindings();
  }
  
  private void configureButtonBindings(){
    new JoystickButton(xbox, 3)
    .whenPressed(new ActivateFlyWheel(.5, m_flyWheelSystem));
    new JoystickButton(xbox, 4)
    .whileHeld(new CheckDistance(m_ultrasonicSystem), true);
  }

  public XboxController getXbox() {
    return xbox;
  }


    public static void init() {
        frontLeftWheel.configOpenloopRamp(0.5);
        frontRightWheel.configOpenloopRamp(0.5);
        backLeftWheel.configOpenloopRamp(0.5);
        backRightWheel.configOpenloopRamp(0.5);

        // Lights
        lightsR = new Spark(0);
        lightsL = new Spark(3);
    }
}