package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;    

public class AimSystem extends SubsystemBase{

    private CANSparkMax m_motor;
    private SparkMaxPIDController m_pidController;
    private RelativeEncoder m_encoder;
    //Put these in constants file
    public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput;
    

    public AimSystem(){
        m_motor = new CANSparkMax(8, MotorType.kBrushless);
        m_motor.restoreFactoryDefaults();
        //set position to 0 somewhere?
        m_pidController = m_motor.getPIDController();
        m_encoder = m_motor.getEncoder();
        kP = 0.1; 
        kI = 1e-4;
        kD = 1; 
        kIz = 0; 
        kFF = 0; 
        kMaxOutput = 1; 
        kMinOutput = -1;
        
        m_pidController.setP(kP);
        m_pidController.setI(kI);
        m_pidController.setD(kD);
        m_pidController.setIZone(kIz);
        m_pidController.setFF(kFF);
        m_pidController.setOutputRange(kMinOutput, kMaxOutput);
    }

    public void aimTo(double position){
        m_pidController.setReference(position, CANSparkMax.ControlType.kPosition);
    }

    public double getPosition(){
        return m_encoder.getPosition();
    }
}
