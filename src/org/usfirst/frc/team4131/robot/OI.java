package org.usfirst.frc.team4131.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick leftStick;
	private Joystick rightStick;
	
	public OI() {
		leftStick = new Joystick(RobotMap.LEFT_STICK);
		rightStick = new Joystick(RobotMap.RIGHT_STICK);
	}

	public double getLeftSpeed() {
		return leftStick.getY();
	}

	public double getRightSpeed() {
		return rightStick.getY();
	}
}
