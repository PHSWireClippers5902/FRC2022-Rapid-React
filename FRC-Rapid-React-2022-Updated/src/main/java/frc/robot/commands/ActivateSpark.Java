package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Spark;

public class ActivateSpark extends CommandBase {

  private final SparkSub m_spark;
  private double speed;

  public ActivateFlyWheel(double speed, FlyWheel subSystem){
    m_spark = subSystem;
    addRequirements(m_spark);
    this.speed = speed;
  }

  @Override
  public void execute() {
    m_spark.speed(speed);
  })

  @Override
  public void end(boolean interrupted) {
    m_spark.gofaster(0);
  }


