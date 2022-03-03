package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Command;

public class ServoSystem extends SubsystemBase{

    public static Servo ballServo = new Servo(2);
    public static Servo hookServo = new Servo(0);//change ID

    public ServoSystem(){
        
    }

    public void changeBallServo(double angle){
        
        ballServo.setAngle(angle); //sets the angle of the servo based on a double
    }

    public void changeHookServo(double angle){
        hookServo.setAngle(angle);
        //System.out.println("AHHHHHHHHHHHHHHHHH");
    }
    
}
