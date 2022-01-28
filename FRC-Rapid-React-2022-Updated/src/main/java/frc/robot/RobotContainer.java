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

public class RobotContainer {

    //initializing subsystems
    public static MecanumSystem mecanumSystem = new MecanumSystem();
    public static LightSystem lightSystem = new LightSystem();
    public static FlyWheel flyWheelSystem = new FlyWheel();

    //creating motor controllers
    public static WPI_TalonSRX frontRightWheel = new WPI_TalonSRX(1);
    public static WPI_TalonSRX frontLeftWheel = new WPI_TalonSRX(2);
    public static WPI_TalonSRX backRightWheel = new WPI_TalonSRX(3);
    public static WPI_TalonSRX backLeftWheel = new WPI_TalonSRX(4);

    public static WPI_TalonSRX testMotor = new WPI_TalonSRX(8);

    public static SpeedController lightsR;
    public static SpeedController lightsL;


    // Xbox
  XboxController xbox = new XboxController(0);
  private JoystickButton xboxLeftTrigger;
  private JoystickButton xboxRightTrigger;
  private JoystickButton xboxButtonY = new JoystickButton(xbox, 4);
  private JoystickButton xboxButtonX = new JoystickButton(xbox, 3).whenPressed(new ActivateFlyWheel(.5));
  private JoystickButton xboxButtonA = new JoystickButton(xbox, 1);
  private JoystickButton xboxButtonB = new JoystickButton(xbox, 2);

  // Logitech Buttons
  public Joystick logitech = new Joystick(1);;
  private JoystickButton logitechButtonY;
  private JoystickButton logitechButtonB;
  private JoystickButton logitechButtonA;
  private JoystickButton logitechButtonX;
  private JoystickButton logitechLeftBumper;
  private JoystickButton logitechRightBumper;
  private JoystickButton logitechLeftStickPush;
  private JoystickButton logitechRightStickPush;
  private JoystickButton logitechDPadLeft;
  private JoystickButton logitechDPadRight;


  

  public XboxController getXbox() {
    return xbox;
  }

  public Joystick getLogitech() {
    return logitech;
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