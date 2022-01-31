// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class ActivateFlyWheel extends CommandBase {

  private double speed;

  public ActivateFlyWheel(double speed){
    this.speed = speed;
  }

  @Override
  public void initialize() {
    RobotContainer.flyWheelSystem.gofaster(speed);
  }

  @Override
  public void end(boolean interrupted) {
    RobotContainer.flyWheelSystem.gofaster(0);
  }
}
