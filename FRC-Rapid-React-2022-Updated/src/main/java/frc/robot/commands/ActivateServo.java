package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.FlyWheel;
import frc.robot.subsystems.LinearActuator;
import frc.robot.subsystems.ServoSystem;
import frc.robot.RobotContainer;

public class ActivateServo extends CommandBase {
    public final ServoSystem m_servo;
    public double amount;

    public ActivateServo(double amount, ServoSystem subSystem){
        m_servo = subSystem;
        addRequirements(m_servo);
        this.amount = amount;

    }

    @Override
    public void initialize() {
        m_servo.change(amount);
        //System.out.println("gogogooooogogo" + amount);
    }
    @Override
    public boolean isFinished(){
        return true;
    }

    
  }
