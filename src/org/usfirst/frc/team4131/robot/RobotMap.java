package org.usfirst.frc.team4131.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	/**
	 * Motor controllers for the tank treads (CAN via CANTalon)
	 */
	public static final int LEFT_DRIVE1 = 1, LEFT_DRIVE2 = 2, RIGHT_DRIVE1 = 3, RIGHT_DRIVE2 = 4;

	/**
	 * Encoder Channels for the treads (DIO)
	 */
	public static final int LEFT_TREAD_ENCODER_A = 4, LEFT_TREAD_ENCODER_B = 5, RIGHT_TREAD_ENCODER_A = 7, RIGHT_TREAD_ENCODER_B = 6;

}
