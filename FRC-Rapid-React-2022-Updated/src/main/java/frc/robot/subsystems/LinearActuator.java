package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.Servo;

public class LinearActuator extends SubsystemBase{

    public static Servo actuatorTest = new Servo(1);

    public LinearActuator(){
        actuatorTest.setBounds(2.0, 1.8, 1.5, 1.2, 1.0);
    }

    public void initDefaultCommand(){

    }

    public void change(double amount){
        actuatorTest.setSpeed(amount);
    }
    
}
