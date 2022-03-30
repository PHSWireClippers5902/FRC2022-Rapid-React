package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.FlyWheel;
import frc.robot.subsystems.MecanumSystem;
import edu.wpi.first.wpilibj.XboxController;

public class DriveWithMecanum extends CommandBase {

  private final MecanumSystem m_mecanum;
  private XboxController xb;
  private double forward;
  private double sideways;
  private double turn;

  public DriveWithMecanum(XboxController xbox, MecanumSystem subSystem){
    xb = xbox;
    m_mecanum = subSystem;
    addRequirements(m_mecanum);
  }

  @Override
  public void execute() {
    forward = xb.getRightTriggerAxis() - xb.getLeftTriggerAxis();
    sideways = xb.getRightX();
    turn = (forward < 0) ? -xb.getLeftX() : xb.getLeftX();
    m_mecanum.drive(forward, sideways, turn);
  }

  @Override
  public void end(boolean interrupted) {
  }
}
