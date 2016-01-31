package org.usfirst.frc.team4131.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	/**
	 * Joystick ports for main tank drive.
	 */
	public static final int LEFT_STICK = 0, RIGHT_STICK = 1;
	/**
	 * Drive system motor ports
	 */
	public static final int DRIVE_LEFT1 = 2, DRIVE_LEFT2 = 3, DRIVE_RIGHT1 = 4, DRIVE_RIGHT2 = 5;
	/**
	 * Drive system encoder ports
	 */
	public static final int ENCODER_LEFT1 = 0, ENCODER_LEFT2 = 1, ENCODER_RIGHT1 = 2, ENCODER_RIGHT2 = 3;
}
