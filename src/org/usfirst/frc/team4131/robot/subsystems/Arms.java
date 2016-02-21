package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arms extends Subsystem {

	private SpeedController motor;
	private Encoder encoder;
	private DigitalInput stowed;

	public Arms() {
		motor = new CANTalon(RobotMap.ARMS_MOTOR);
		encoder = new Encoder(RobotMap.ARMS_ENCODERA, RobotMap.ARMS_ENCODERB);
		stowed = new DigitalInput(RobotMap.ARMS_SWITCH);
	}

	public boolean isStowed() {
		return stowed.get();
	}

	public void setSpeed(double speed) {
		motor.set(speed);
	}

	public int getAngle() {
		return encoder.get();
	}

	public void initDefaultCommand() {
	}

	public void resetEncoder() {
		encoder.reset();
	}
}
