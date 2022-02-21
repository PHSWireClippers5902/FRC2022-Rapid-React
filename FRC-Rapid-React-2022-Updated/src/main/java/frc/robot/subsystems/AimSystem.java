package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import static frc.robot.Constants.AimConstants;


public class AimSystem extends SubsystemBase{

    private CANSparkMax m_motor;
    private SparkMaxPIDController m_pidController;
    private RelativeEncoder m_encoder;
    

    public AimSystem(){
        m_motor = new CANSparkMax(AimConstants.aimMotorPort, MotorType.kBrushless);
        m_motor.restoreFactoryDefaults();
        //set position to 0 somewhere?
        m_pidController = m_motor.getPIDController();
        m_encoder = m_motor.getEncoder();
        
        m_pidController.setP(AimConstants.P);
        m_pidController.setI(AimConstants.I);
        m_pidController.setD(AimConstants.D);
        m_pidController.setIZone(AimConstants.Iz);
        m_pidController.setFF(AimConstants.FF);
        m_pidController.setOutputRange(AimConstants.MinOutput, AimConstants.MaxOutput);
    }

    public void aimTo(double position){
        m_pidController.setReference(position, CANSparkMax.ControlType.kPosition);
    }

    public void resetPosition(){
        m_encoder.setPosition(0);
    }

    public double getPosition(){
        return m_encoder.getPosition();
    }
}
