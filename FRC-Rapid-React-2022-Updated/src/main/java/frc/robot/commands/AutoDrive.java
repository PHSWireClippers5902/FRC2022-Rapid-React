package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.FlyWheel;
import frc.robot.subsystems.LinearActuator;
import frc.robot.subsystems.MecanumSystem;
import frc.robot.RobotContainer;

public class AutoDrive extends CommandBase {
    private MecanumSystem mecanumSystem;
    public AutoDrive(MecanumSystem subsSystem){
        mecanumSystem = subsSystem;
        addRequirements(mecanumSystem);
    }

    @Override
    public void execute() {
        mecanumSystem.drive(-0.2, 0, 0);
    }
    @Override
    public void end(boolean interupted){
        mecanumSystem.drive(0, 0, 0);
    }
  }
