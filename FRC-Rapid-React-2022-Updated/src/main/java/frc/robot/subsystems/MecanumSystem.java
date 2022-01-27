/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;

import frc.robot.Robot;

public class MecanumSystem extends SubsystemBase {

    private double threshold = 0.1;

    public void driveWithMecanum(){

        double rightTriggerValue = Robot.oi.getXbox().getRightTriggerAxis();
        double leftTriggerValue = Robot.oi.getXbox().getLeftTriggerAxis();
        double leftStickXValue = Robot.oi.getXbox().getLeftX();
        //double leftStickYValue = Robot.oi.getXbox().getLeftY();
        double RightStickXValue = Robot.oi.getXbox().getRightX();

        double forward = rightTriggerValue * 0.5;
        double backward = leftTriggerValue * 0.5;
        double x = leftStickXValue;
        double sideSpeed = 0.5;

        if (Math.abs(rightTriggerValue) > threshold || Math.abs(leftStickXValue) > threshold || Math.abs(RightStickXValue) > threshold || Math.abs(leftTriggerValue) > threshold){
            if (Math.abs(rightTriggerValue) > threshold){
                RobotMap.frontRightWheel.set(-(forward-x));
                RobotMap.frontLeftWheel.set(forward+x);
                RobotMap.backRightWheel.set(-(forward-x));
                RobotMap.backLeftWheel.set(forward+x);
            }
            else if (RightStickXValue > threshold){
                RobotMap.frontRightWheel.set(sideSpeed);
                RobotMap.frontLeftWheel.set(sideSpeed);
                RobotMap.backRightWheel.set(-sideSpeed);
                RobotMap.backLeftWheel.set(-sideSpeed); 
            }else if (RightStickXValue < -threshold){
                RobotMap.frontRightWheel.set(-sideSpeed);
                RobotMap.frontLeftWheel.set(-sideSpeed);
                RobotMap.backRightWheel.set(sideSpeed);
                RobotMap.backLeftWheel.set(sideSpeed);
            }else if (Math.abs(leftTriggerValue) > threshold){
                RobotMap.frontRightWheel.set((backward+x));
                RobotMap.frontLeftWheel.set(-(backward-x));
                RobotMap.backRightWheel.set((backward+x));
                RobotMap.backLeftWheel.set(-(backward-x));
            }
            else if (Math.abs(leftStickXValue) > threshold){
                RobotMap.frontRightWheel.set(-(forward-x));
                RobotMap.frontLeftWheel.set(forward+x);
                RobotMap.backRightWheel.set(-(forward-x));
                RobotMap.backLeftWheel.set(forward+x);
            }
        }else{
            RobotMap.frontRightWheel.set(0);
            RobotMap.frontLeftWheel.set(0);
            RobotMap.backRightWheel.set(0);
            RobotMap.backLeftWheel.set(0);
        }

        

        System.out.println("StickX " + leftStickXValue + "StickY " + rightTriggerValue);
    }


   





}

