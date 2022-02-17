package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.commands.ActivateFlyWheel;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class FlyWheel extends SubsystemBase{

    public static CANSparkMax spark = new CANSparkMax(9, MotorType.kBrushless);
    public static CANSparkMax spark2 = new CANSparkMax(8, MotorType.kBrushless);
  
    public void speed(double speed){
        spark.set(speed);
        spark2.set(speed * -1);
       
    }
}
