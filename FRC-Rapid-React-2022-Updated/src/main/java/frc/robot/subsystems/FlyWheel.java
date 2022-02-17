package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.commands.ActivateFlyWheel;

public class FlyWheel extends SubsystemBase{
  
    public void speed(double speed){
        RobotContainer.spark.set(speed);
        RobotContainer.spark2.set(speed * -1);
       
    }
}
