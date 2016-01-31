package org.usfirst.frc.team4131.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;
	/**
	 * Motor controllers for the treads
	 */
	public static final int leftMotorController = 1,  rightMotorController = 0;
	/**
	 * Encoder Channels for the treads
	 */
	public static final int leftEncoderA  = 1,  leftEncoderB = 0,  rightEncoderA = 3,  rightEncoderB = 2;
	
	/**
	 * Motor controllers for the collection system
	 */
	public static final int beltMotor = 2, rollingPinMotor = 3;
	
	/**
	 * Motor controller for the arms
	 */
	public static final int armsMotor = 4;
	/**
	 * Encoder channels for the arms
	 */
	public static final int armsEncoderA = 4, armsEncoderB = 5;
	/**
	 * Angles for the arm to move to for particular states
	 */
	public static final int stowArms = 0, collectBall = 200, underPortcullis = 240;
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	
}
