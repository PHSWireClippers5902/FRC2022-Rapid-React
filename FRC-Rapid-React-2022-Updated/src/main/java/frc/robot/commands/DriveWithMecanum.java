package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.FlyWheel;
import frc.robot.subsystems.MecanumSystem;

public class DriveWithMecanum extends CommandBase {

  private final MecanumSystem m_mecanum;

  private double y,x,z;

  public DriveWithMecanum(double yin, double xin, double zin, MecanumSystem subSystem){
    m_mecanum = subSystem;
    addRequirements(m_mecanum);
    y = yin;
    x = xin;
    z = zin;
  }

  @Override
  public void execute() {
    m_mecanum.drive(y,x,z);
  }

  @Override
  public void end(boolean interrupted) {
  }
}
