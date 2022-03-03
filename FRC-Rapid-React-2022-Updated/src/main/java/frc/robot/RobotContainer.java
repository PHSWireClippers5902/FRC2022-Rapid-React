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
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import static frc.robot.Constants.ControllerConstants;
import static frc.robot.Constants.AimConstants;
import static frc.robot.Constants.ClimbConstants;
import edu.wpi.first.wpilibj.AnalogInput;

public class RobotContainer {

    //initializing subsystems(
    private final MecanumSystem m_mecanumSystem = new MecanumSystem();
    private final FlyWheel m_flyWheelSystem = new FlyWheel();
    private final LinearActuator m_linearActuator = new LinearActuator();
    private final UltrasonicSystem m_UltrasonicSystem = new UltrasonicSystem();
    private final AimSystem m_aimSystem = new AimSystem();
    private final ClimbSystem m_climbSystem = new ClimbSystem();
    private final ServoSystem m_servo = new ServoSystem();
  
    // Xbox
    XboxController xbox = new XboxController(ControllerConstants.ControllerPort);

  public RobotContainer(){
    //Default Commands
    m_flyWheelSystem.setDefaultCommand(new ActivateFlyWheel(-.1, m_flyWheelSystem));
    configureButtonBindings();
    m_mecanumSystem.setDefaultCommand(new DriveWithMecanum(xbox, m_mecanumSystem));
    m_UltrasonicSystem.setDefaultCommand(new CheckDistance(m_UltrasonicSystem));
  }
  


  private void configureButtonBindings(){ 
    new JoystickButton(xbox, 3)//X button
    .whenPressed(new ActivateHookServo(35, m_servo));
    
    new JoystickButton(xbox, ControllerConstants.A)//A button
    .whileHeld(new ActivateBallServo(90, m_servo)); //sets angle to 90 this value will be reset to zero after called.
    .whenReleased(new ActivateBallServo(0, m_servo));

    new JoystickButton(xbox, ControllerConstants.Y)
    .whileHeld(new ActivateLinearActuator(1.0, m_linearActuator))
    .whenReleased(new ActivateLinearActuator(-1.0, m_linearActuator))
    .whenHeld(new ActivateFlyWheel(.25, m_flyWheelSystem));

    //Ultrasonic
    new JoystickButton(xbox, ControllerConstants.A)
    .whenPressed(new CheckDistance(m_UltrasonicSystem));

    //Aim
    new JoystickButton(xbox, ControllerConstants.B)
    .toggleWhenPressed(new StartEndCommand(
      () -> {m_aimSystem.aimTo(AimConstants.MotorUpPosition);},
      () -> {m_aimSystem.aimTo(AimConstants.MotorDownPosition);},
      m_aimSystem));
    
    //Climb arm
    new JoystickButton(xbox, ControllerConstants.LeftButton)
    .toggleWhenPressed(new StartEndCommand(
      () -> {m_climbSystem.moveTo(ClimbConstants.MotorUpPosition);},
      () -> {m_climbSystem.moveTo(ClimbConstants.MotorDownPosition);},
      m_climbSystem));
    
  }

    

  // when pressed go = !go

  public XboxController getXbox() {
    return xbox;
  }

}