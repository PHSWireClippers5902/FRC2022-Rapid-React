package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Command;

public class ServoSystem extends SubsystemBase{

    public ServoSystem(){
        
    }

    public void change(double angle){
        
        RobotContainer.ballServo.setAngle(angle); //sets the angle of the servo based on a double
        System.out.println("Angle: " + RobotContainer.ballServo.getAngle());
    }
    
}
