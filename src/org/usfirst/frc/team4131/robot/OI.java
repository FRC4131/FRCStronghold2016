package org.usfirst.frc.team4131.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	private Joystick leftStick;
	private Joystick rightStick;

	/**
	 * Constructs for port numbers of both left and right joysticks
	 * 
	 * @param port1
	 * @param port2
	 */
	public OI(int port1, int port2) {
		leftStick = new Joystick(port1);
		rightStick = new Joystick(port2);
	}

	// Button button = new JoystickButton(stick, buttonNumber);
	/**
	 * Returns the Y value read on the RIGHT joystick.
	 * 
	 * @return (double) right Y-axis
	 */
	public double getRightY() {
		return rightStick.getY();
	}

	/**
	 * Returns the Y value read on the LEFT joystick.
	 * 
	 * @return (double) left Y-axis
	 */
	public double getLeftY() {
		return leftStick.getY();
	}

	public double getConstantSpeed() {
		return leftStick.getRawAxis(2);
	}
}
