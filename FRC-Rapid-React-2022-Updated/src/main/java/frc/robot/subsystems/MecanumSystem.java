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
import frc.robot.RobotContainer;

import frc.robot.Robot;

public class MecanumSystem extends SubsystemBase {

    private double threshold = 0.1;

    public static WPI_TalonSRX frontRightWheel = new WPI_TalonSRX(7);
    public static WPI_TalonSRX frontLeftWheel = new WPI_TalonSRX(4);
    public static WPI_TalonSRX backRightWheel = new WPI_TalonSRX(3);
    public static WPI_TalonSRX backLeftWheel = new WPI_TalonSRX(6);

    public void driveWithMecanum(){

        double rightTriggerValue = Robot.m_robotContainer.getXbox().getRightTriggerAxis();
        double leftTriggerValue = Robot.m_robotContainer.getXbox().getLeftTriggerAxis();
        double leftStickXValue = Robot.m_robotContainer.getXbox().getLeftX();
        //double leftStickYValue = Robot.oi.getXbox().getLeftY();
        double RightStickXValue = Robot.m_robotContainer.getXbox().getRightX();

        double forward = rightTriggerValue * 0.5;
        double backward = leftTriggerValue * 0.5;
        double x = leftStickXValue;
        double sideSpeed = 0.5;

        if (Math.abs(rightTriggerValue) > threshold || Math.abs(leftStickXValue) > threshold || Math.abs(RightStickXValue) > threshold || Math.abs(leftTriggerValue) > threshold){
            if (Math.abs(rightTriggerValue) > threshold){
                frontRightWheel.set(-(forward-x));
                frontLeftWheel.set(forward+x);
                backRightWheel.set(-(forward-x));
                backLeftWheel.set(forward+x);
            }
            else if (RightStickXValue > threshold){
                frontRightWheel.set(sideSpeed);
                frontLeftWheel.set(sideSpeed);
                backRightWheel.set(-sideSpeed);
                backLeftWheel.set(-sideSpeed); 
            }else if (RightStickXValue < -threshold){
                frontRightWheel.set(-sideSpeed);
                frontLeftWheel.set(-sideSpeed);
                backRightWheel.set(sideSpeed);
                backLeftWheel.set(sideSpeed);
            }else if (Math.abs(leftTriggerValue) > threshold){
                frontRightWheel.set((backward+x));
                frontLeftWheel.set(-(backward-x));
                backRightWheel.set((backward+x));
                backLeftWheel.set(-(backward-x));
            }
            else if (Math.abs(leftStickXValue) > threshold){
                frontRightWheel.set(-(forward-x));
                frontLeftWheel.set(forward+x);
                backRightWheel.set(-(forward-x));
                backLeftWheel.set(forward+x);
            }
        }else{
            frontRightWheel.set(0);
            frontLeftWheel.set(0);
            backRightWheel.set(0);
            backLeftWheel.set(0);
        }

        

        //System.out.println("StickX " + leftStickXValue + "StickY " + rightTriggerValue);
    }


   





}

