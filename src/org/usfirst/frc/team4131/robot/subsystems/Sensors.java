package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *
 */
public class Sensors extends Subsystem {
	private Gyro gyro = null;
	
	public Sensors() {
		gyro = new AnalogGyro(RobotMap.GYRO);
	}

	public void calibrate() {
		gyro.calibrate();
	}

	public double getAngle() {
		// return (gyro.getAngle() % 360) + (gyro.getAngle() < 0 ? 360 : 0);
		return constrainAngle(gyro.getAngle());
	}

	public double getContinuousAngle() {
		return gyro.getAngle();
	}

	public void resetGyro() {
		gyro.reset();
	}

	public void initDefaultCommand() {
	}

	public static double constrainAngle(double angle) {
		return (angle % 360) + (angle < 0 ? 360 : 0);
	}
}
