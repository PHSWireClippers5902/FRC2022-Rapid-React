package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.RobotContainer;

/**
 * Add your docs here.
 */
public class LightSystem extends SubsystemBase {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  // public final SpeedController color = RobotMap.lights;
  // Color when not launching things

  private double y = -1;

  public void moreLights() {
    y += .001;
    RobotContainer.lightsR.set(y);
    RobotContainer.lightsL.set(y);
    //System.out.println(y);
  }

  public void getAllianceColor() {
    DriverStation.Alliance color;
    color = DriverStation.getAlliance();
    if (color == DriverStation.Alliance.valueOf("Blue")) {
      RobotContainer.lightsR.set(.85);
      RobotContainer.lightsL.set(.85);
    } else if (color == DriverStation.Alliance.valueOf("Red")) {
      red();
    } else {
      scannerGray();
    }
  }

  public void party() {
    RobotContainer.lightsR.set(-69.69);
    RobotContainer.lightsL.set(-69.69);
  }

  public void chaseBlue() {
    RobotContainer.lightsR.set(-.29);
    RobotContainer.lightsL.set(-.29);
  }

  public void chaseRed() {
    RobotContainer.lightsR.set(-.32);
    RobotContainer.lightsL.set(-.32);
  }

  public void BPMOcean() {
    RobotContainer.lightsR.set(-.65);
    RobotContainer.lightsL.set(-.65);
  }

  public void BPMLava() {
    RobotContainer.lightsR.set(-.63);
    RobotContainer.lightsL.set(-.63);
  }

  public void revenge() {
    RobotContainer.lightsR.set(-.05);
    RobotContainer.lightsL.set(-.05);
  }

  public void white() {
    RobotContainer.lightsR.set(.93);
    RobotContainer.lightsL.set(.93);
  }

  public void blueShots() {
    RobotContainer.lightsR.set(-.83);
    RobotContainer.lightsL.set(-.83);
  }

  public void blue() {
    RobotContainer.lightsR.set(.85);
    RobotContainer.lightsL.set(.85);
  }

  public void red() {
    RobotContainer.lightsR.set(.61);
    RobotContainer.lightsL.set(.61);
  }

  public void beatBlue() {
    RobotContainer.lightsR.set(-.23);
    RobotContainer.lightsL.set(-.23);
  }

  public void oceanBlue() {
    RobotContainer.lightsR.set(-.41);
    RobotContainer.lightsL.set(-.41);
  }

  public void redShots() {
    RobotContainer.lightsR.set(-.85);
    RobotContainer.lightsL.set(-.85);
  }

  public void scannerRed() {
    RobotContainer.lightsR.set(-.35);
    RobotContainer.lightsL.set(-.35);
  }

  public void beatRed() {
    RobotContainer.lightsR.set(-.25);
    RobotContainer.lightsL.set(-.25);
  }

  public void beatWhite() {
    RobotContainer.lightsR.set(-.21);
    RobotContainer.lightsL.set(-.21);
  }

  public void scannerGray() {
    RobotContainer.lightsR.set(-.33);
    RobotContainer.lightsL.set(-.33);
  }

  public void gray() {
    RobotContainer.lightsR.set(.95);
    RobotContainer.lightsL.set(.95);
  }

  public void strobeYellow() {
    RobotContainer.lightsR.set(-.07);
    RobotContainer.lightsL.set(-.07);

  }

  public void lavaError() {
    RobotContainer.lightsR.set(.49);
    RobotContainer.lightsL.set(.49);

  }

  public void rainbowGlitter() {
    RobotContainer.lightsR.set(-.89);
    RobotContainer.lightsL.set(-.89);
  }

  public void confetti() {
    RobotContainer.lightsR.set(-.87);
    RobotContainer.lightsL.set(-.87);
  }

  public void off() {
    RobotContainer.lightsR.set(0);
    RobotContainer.lightsL.set(0);
  }

  public void smartdash(double color) {
    RobotContainer.lightsR.set(color);
    RobotContainer.lightsL.set(color);
  }

  /*
   * public String getLightColor() { String Color = "Null"; switch
   * ((int)(color.get()*100)) { case 0: Color = "Off"; break; case 49: Color =
   * "Error"; break; case -7: Color = "Strobe"; break; case 95: Color = "Gray";
   * break; case -33: Color = "Scanner Gray"; break; case -41: Color =
   * "Calming Ocean"; break; case -85: Color = "Red Bullets"; break; case -35:
   * Color = "Scanner Red"; break; case -21: Color = "Beat White"; break; case
   * -25: Color = "Beat Red"; break; case -23: Color = "Beat Blue"; break; case
   * -77: Color = "Party Time"; break; case -5: Color = "How I really feel";
   * break; case 93: Color = "Revenge"; break; case -83: Color = "Blue Shots";
   * break; case 85: Color = "Blue"; break; case 61: Color = "Red"; break;} return
   * Color; }
   */

}
