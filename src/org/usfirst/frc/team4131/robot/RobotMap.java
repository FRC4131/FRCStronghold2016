package org.usfirst.frc.team4131.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	/**
	 * ID for USBCamera
	 */
	public static final String CAMERA = "cam1";
	
    public static final int WIDTH = 640, HEIGHT = 480;
    
    public static final int FPS = 10;
    
    public static final int COMPRESSION = 0;
	/**
	 * Configuration for the RoboRio(s)
	 */
	public static final String ELECTRICAL_BOT = "ElectricalBot"; //0
	public static final int ELECT_BOT_NUM = 0;

	public static final String PRACTICE_BOT = "PracticeBot";//1
	public static final int PRAC_BOT_NUM = 1;

	public static final String COMP_BOT = "CompetitionBot"; //2
	public static final int COMP_BOT_NUM = 2;

	public static final String CONFIG_FILENAME = "WHOAMI.TXT";

	public static int robotType(String robot) {
		if (robot.equals(ELECTRICAL_BOT)) {
			return 0;
		} else if (robot.equals(PRACTICE_BOT)) {
			return 1;
		} else if (robot.equals(COMP_BOT)) {
			return 2;
		} else {
			return -1;
		}
	}

	public static int ROBOT_TYPE = -1;

	/**
	 * Ports for motor controllers, encoders, etc
	 */
	public static final int LEFT_JOYSTICK = 0;

	public static final int RIGHT_JOYSTICK = 1;

	public static final int LAUNCHPAD = 2;

	public static final int HANDLER_MOTOR = 7;

	public static final int SHOOTER_MOTOR = 8;

	public static final int SHOOTER_ENCODER_A = 4;//2 on Gretta

	public static final int SHOOTER_ENCODER_B = 5;//3 on Gretta

	public static final int DRIVE_LEFT_MOTOR1 = 1;

	public static final int DRIVE_LEFT_MOTOR2 = 2;

	public static final int DRIVE_RIGHT_MOTOR1 = 3;

	public static final int DRIVE_RIGHT_MOTOR2 = 4;

	public static final int DRIVE_LEFT_ENCODERA = 0;

	public static final int DRIVE_LEFT_ENCODERB = 1;

	public static final int DRIVE_RIGHT_ENCODERA = 2;

	public static final int DRIVE_RIGHT_ENCODERB = 3;

//	public static final double DRIVE_RATIO = ROBOT_TYPE == PRAC_BOT_NUM ? ((125D + 3D / 16D) / 1033D) : (43.0 + 17.0 / 32.0) / 1073.00;
	public static final double DRIVE_RATIO = ((125D + 3D / 16D) / 1033D);

	public static final int GYRO = 1;
	//Direct wired
	//	public static final int LIGHT = 9;

	public static final int ARMS_MOTOR = 6;

	public static final int ARMS_ENCODERA = 8;

	public static final int ARMS_ENCODERB = 9;

	public static final int ARMS_SWITCH = 7;

	public static final int COLLECTOR_MOTOR = 5;

	public static final int HANDLER_SWITCH = 6;
	/**
	 * Joystick mappings
	 */
	public static final int LOAD = 1; //right joystick, the trigger one

	public static final int UNLOAD = 2; //launchpad, the unload button

	public static final int PORTCULLIS = 1; //launchpad, the portcullis button

	public static final int COLLECT_BOULDER = 3;//launchpad, the collect button

	public static final int DEPLOY_ARMS = 4; //launchpad, the deploy arms button

	public static final int EMERGENCY_STOP = 6; //launchpad, the cancel arms button

	public static final int STOW_ARMS = 5; //launchpad, the stow arms button

	public static final int TOGGLE_LIGHT = 11;

	public static final int INVERSE = 5;

	public static final int FLASHLIGHT_CONTROLLER = 0;

	public static final int RANGE_FLAP_BUTTON = 10;

	public static final int TOGGLE_LAUNCHER = 1;//Left stick, toggle the launcher

	public static final int BLAST_FORWARD = 1;
}
