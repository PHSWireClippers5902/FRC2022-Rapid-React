package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.commands.ActivateFlyWheel;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import static frc.robot.Constants.FlyWheelConstants;

public class FlyWheel extends SubsystemBase{

    public static WPI_TalonSRX spark = new WPI_TalonSRX(FlyWheelConstants.motorOnePort);
    public static WPI_TalonSRX spark2 = new WPI_TalonSRX(FlyWheelConstants.motorTwoPort);
  
    public void speed(double speed){
        spark.set(speed * 1);
        spark2.set(speed * -1);
       
    }
}
