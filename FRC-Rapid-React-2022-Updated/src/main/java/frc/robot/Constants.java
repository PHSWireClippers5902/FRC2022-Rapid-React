package frc.robot;

public final class Constants{
  public static final class WheelConstants{
      public static final int frontLeftMotorPort = 4;
      public static final int backLeftMotorPort = 6;
      public static final int frontRightMotorPort = 7;
      public static final int backRightMotorPort = 3;
  }
  public static final class AimConstants{
      public static final int aimMotorPort = 10;
      public static final double P = 0.1; 
      public static final double I = 1e-4;
      public static final double D = 1; 
      public static final double Iz = 0; 
      public static final double FF = 0; 
      public static final double MaxOutput = 1; 
      public static final double MinOutput = -1;
      public static final double MotorUpPosition = .1;
      public static final double MotorDownPosition = .05;
    
  }
  public static final class ControllerConstants {
      public static final int A = 1;
      public static final int B = 2;
      public static final int X = 3;
      public static final int Y = 4;
      public static final int ControllerPort = 0;
  }
  public static final class FlyWheelConstants{
      public static final int motorOnePort = 8;
      public static final int motorTwoPort = 9;
  }
  public static final class LinearActuatorConstants{
      public static final int ServoChannel = 1;    
  }
}