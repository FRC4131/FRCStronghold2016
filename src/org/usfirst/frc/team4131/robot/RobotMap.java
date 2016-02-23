package org.usfirst.frc.team4131.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	/**
	 * Ports for motor controllers, encoders, etc
	 */
	public static final int LEFT_JOYSTICK = 0;
	
	public static final int RIGHT_JOYSTICK = 1;
	
	public static final int LAUNCHPAD = 2;

	public static final int HANDLER_MOTOR = 7;

	public static final int SHOOTER_MOTOR = 5;

	public static final int SHOOTER_ENCODER_A = 2;

	public static final int SHOOTER_ENCODER_B = 3;

	public static final int DRIVE_LEFT_MOTOR1 = 1;

	public static final int DRIVE_LEFT_MOTOR2 = 2;

	public static final int DRIVE_RIGHT_MOTOR1 = 4;

	public static final int DRIVE_RIGHT_MOTOR2 = 3;

	public static final int DRIVE_LEFT_ENCODERA = 4;

	public static final int DRIVE_LEFT_ENCODERB = 5;

	public static final int DRIVE_RIGHT_ENCODERA = 7;

	public static final int DRIVE_RIGHT_ENCODERB = 6;
	
	public static final int GYRO = 1;
	
	public static final int LIGHT = 9;
	
	public static final int ARMS_MOTOR = 8;
	
	public static final int ARMS_ENCODERA = 9;

	public static final int ARMS_ENCODERB = 8;

	public static final int ARMS_SWITCH = 1;	//switch that tells 
	
	public static final int COLLECTOR_MOTOR = 6;//rolling pin motor
	
	public static final int HANDLER_SWITCH = 0;
	/**
	 * Joystick mappings
	 */
	public static final int LOAD = 1;			//right joystick, the trigger one
	
	public static final int UNLOAD = 1;			//launchpad, the unload button
	
	public static final int PORTCULLIS = 2;		//launchpad, the portcullis button
	
	public static final int COLLECT_BOULDER = 3;		//launchpad, the collect button
	
	public static final int DEPLOY_ARMS = 4;	//launchpad, the deploy arms button
	
	public static final int EMERGENCY_STOP = 6;	//launchpad, the cancel arms button
	
	public static final int STOW_ARMS = 5;	//launchpad, the stow arms button

	public static final int TOGGLE_LIGHT = 1;
	
	public static final int INVERSE = 2;
}
