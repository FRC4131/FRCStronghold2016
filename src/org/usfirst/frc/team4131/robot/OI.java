package org.usfirst.frc.team4131.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Joystick leftStick = new Joystick(RobotMap.LEFT_JOYSTICK);
	private Joystick rightStick = new Joystick(RobotMap.RIGHT_JOYSTICK);

	public double getLeftSpeed() {
		return leftStick.getRawAxis(0);
	}
	public double getRightSpeed() {
		return rightStick.getRawAxis(0);
	}
}

