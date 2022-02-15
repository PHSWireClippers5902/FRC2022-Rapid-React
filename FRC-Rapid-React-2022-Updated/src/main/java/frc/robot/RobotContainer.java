package frc.robot;

//import edu.wpi.first.wpilibj.SpeedController;
//import edu.wpi.first.wpilibj.SpeedControllerGroup;
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
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class RobotContainer {

    //initializing subsystems
    public static MecanumSystem mecanumSystem = new MecanumSystem();
    //private final LightSystem m_lightSystem = new LightSystem();
    public final FlyWheel m_flyWheelSystem = new FlyWheel();
    public final LinearActuator m_linearActuator = new LinearActuator();

    //creating motor controllers
    public static WPI_TalonSRX frontRightWheel = new WPI_TalonSRX(7);
    public static WPI_TalonSRX frontLeftWheel = new WPI_TalonSRX(4);
    public static WPI_TalonSRX backRightWheel = new WPI_TalonSRX(3);
    public static WPI_TalonSRX backLeftWheel = new WPI_TalonSRX(6);

    public static WPI_TalonSRX testMotor = new WPI_TalonSRX(5);

    public static Spark sparkTestMotor = new Spark(8);

    public static Servo actuatorTest = new Servo(0); //Temp ID change to servo id on roboRio

    //public static SpeedController lightsR;
    //public static SpeedController lightsL;


    // Xbox
  XboxController xbox = new XboxController(0);

  public RobotContainer(){
    configureButtonBindings();
  }
  
  private void configureButtonBindings(){ 
    new JoystickButton(xbox, 4)//Y button
    //.whenPressed(new ActivateFlyWheel(.5, m_flyWheelSystem));
    .whileHeld(new ActivateLinearActuator(1.0, m_linearActuator)); //Activates a linear actuator
    new JoystickButton(xbox, 4).whenReleased(new ActivateLinearActuator(-1.0, m_linearActuator));
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
        //lightsR = new Spark(0);
        //lightsL = new Spark(3);
    }
}