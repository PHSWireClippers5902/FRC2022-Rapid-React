package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotContainer;

public class FlyWheel extends Subsystem{
    public void initDefaultCommand(){

    }

    public void gofaster(double speed){
        RobotContainer.testMotor.set(speed);
    }
}
