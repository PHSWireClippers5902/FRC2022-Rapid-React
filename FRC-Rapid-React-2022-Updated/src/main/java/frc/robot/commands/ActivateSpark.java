package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SparkTest;

public class ActivateSpark extends CommandBase {

  private final SparkTest m_SparkTest;
  private double speed;

  public ActivateSpark(double speed, SparkTest subSystem){
    m_SparkTest = subSystem;
    addRequirements(m_SparkTest);
    this.speed = speed;
  }

  @Override
  public void execute() {
    m_SparkTest.sparkSpeed(speed);
  }

  @Override
  public void end(boolean interrupted) {
    m_SparkTest.sparkSpeed(0);
  }
}