package org.usfirst.frc.team4131.robot;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
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
	
	public static int robotType(String robot){
		if(robot.equals(ELECTRICAL_BOT)){
			return 0;
		}else if(robot.equals(PRACTICE_BOT)){
			return 1;
		}else if(robot.equals(COMP_BOT)){
			return 2;
		}else{
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

	public static final int HANDLER_MOTOR = ROBOT_TYPE == PRAC_BOT_NUM ? 7 : 5;//7 on Gretta

	public static final int SHOOTER_MOTOR = ROBOT_TYPE == PRAC_BOT_NUM ? 5 : 4;//5 on Gretta ok

	public static final int SHOOTER_ENCODER_A = ROBOT_TYPE == PRAC_BOT_NUM ? 2 : 4;//2 on Gretta

	public static final int SHOOTER_ENCODER_B = ROBOT_TYPE == PRAC_BOT_NUM ? 3 : 5;//3 on Gretta

	public static final int DRIVE_LEFT_MOTOR1 = ROBOT_TYPE == PRAC_BOT_NUM ? 1 : 0;//1 on Gretta

	public static final int DRIVE_LEFT_MOTOR2 = ROBOT_TYPE == PRAC_BOT_NUM ? 2 : 1;//2 on Gretta

	public static final int DRIVE_RIGHT_MOTOR1 = ROBOT_TYPE == PRAC_BOT_NUM ? 3 : 2;//3 on Gretta

	public static final int DRIVE_RIGHT_MOTOR2 = ROBOT_TYPE == PRAC_BOT_NUM ? 4 : 3;//4 on Gretta

	public static final int DRIVE_LEFT_ENCODERA = ROBOT_TYPE == PRAC_BOT_NUM ? 4 : 2;//4 on Gretta

	public static final int DRIVE_LEFT_ENCODERB = ROBOT_TYPE == PRAC_BOT_NUM ? 5 : 3;//5 on Gretta

	public static final int DRIVE_RIGHT_ENCODERA = ROBOT_TYPE == PRAC_BOT_NUM ? 7 : 0;//7 on Gretta

	public static final int DRIVE_RIGHT_ENCODERB = ROBOT_TYPE == PRAC_BOT_NUM ? 6 : 1;//6 on Gretta
	
	public static final double DRIVE_RATIO = ROBOT_TYPE == PRAC_BOT_NUM ? ((125D + 3D/16D) / 1033D) : (43.0 + 17.0 / 32.0) / 1073.00;
	
	public static final int GYRO = 1;
	//Direct wired
//	public static final int LIGHT = 9;
	
	public static final int ARMS_MOTOR = ROBOT_TYPE == PRAC_BOT_NUM ? 8 : 6;//8 on Gretta
	
	public static final int ARMS_ENCODERA = ROBOT_TYPE == PRAC_BOT_NUM ? 8 : 8;//8 on Gretta

	public static final int ARMS_ENCODERB = ROBOT_TYPE == PRAC_BOT_NUM ? 9 : 9;//9 on Gretta

	public static final int ARMS_SWITCH = ROBOT_TYPE == PRAC_BOT_NUM ? 1 : 7;// 1 on Gretta 
	
	public static final int COLLECTOR_MOTOR = ROBOT_TYPE == PRAC_BOT_NUM ? 6 : 7;//rolling pin motor; 6 on Gretta
	
	public static final int HANDLER_SWITCH = ROBOT_TYPE == PRAC_BOT_NUM ? 0 : 6;//0 on Gretta
	/**
	 * Joystick mappings
	 */
	public static final int LOAD = 1;			//right joystick, the trigger one
	
	public static final int UNLOAD = 2;			//launchpad, the unload button
	
	public static final int PORTCULLIS = 1;		//launchpad, the portcullis button
	
	public static final int COLLECT_BOULDER = 3;//launchpad, the collect button
	
	public static final int DEPLOY_ARMS = 4;	//launchpad, the deploy arms button
	
	public static final int EMERGENCY_STOP = 6;	//launchpad, the cancel arms button
	
	public static final int STOW_ARMS = 5;		//launchpad, the stow arms button

	public static final int TOGGLE_LIGHT = 11;
	
	public static final int INVERSE = 5;
	
	public static final int FLASHLIGHT_CONTROLLER = 0;
	
	public static final int RANGE_FLAP_BUTTON = 10;
	
	public static final int TOGGLE_LAUNCHER = 1;//Left stick, toggle the launcher

}
