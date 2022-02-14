package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotContainer;

public class SparkTest extends SubsystemBase{
    public void initDefaultCommand(){

    }

    public void sparkSpeed(double speed){
        RobotContainer.sparkTestMotor.set(speed);
    }
}
