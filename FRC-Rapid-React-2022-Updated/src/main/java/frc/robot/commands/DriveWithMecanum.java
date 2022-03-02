package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.FlyWheel;
import frc.robot.subsystems.MecanumSystem;
import edu.wpi.first.wpilibj.XboxController;

public class DriveWithMecanum extends CommandBase {

  private final MecanumSystem m_mecanum;
  private XboxController xb;

  public DriveWithMecanum(XboxController xbox, MecanumSystem subSystem){
    xb = xbox;
    m_mecanum = subSystem;
    addRequirements(m_mecanum);
  }

  @Override
  public void execute() {
    m_mecanum.drive(-xb.getLeftY(), -xb.getRightX(), xb.getRightTriggerAxis() - xb.getLeftTriggerAxis());
  }

  @Override
  public void end(boolean interrupted) {
  }
}
