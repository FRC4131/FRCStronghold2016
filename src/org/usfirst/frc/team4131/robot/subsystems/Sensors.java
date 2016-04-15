package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;
import org.usfirst.frc.team4131.utilities.CustomGyro;

import bin.com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Sensors extends Subsystem {
	private CustomGyro gyro = null;
	private AHRS ahrs;

	// TODO IMU field
	public Sensors() {
		// TODO Instantiate IMU and add appropriate variables
		gyro = new CustomGyro(RobotMap.GYRO);//TODO find out if we still need this
		ahrs = new AHRS(I2C.Port.kOnboard);
		gyro.initGyro();
	}

	public void setGyroSensitivity(double voltsPerDegreePerSecond) {
		gyro.setSensitivity(voltsPerDegreePerSecond);
	}

	public void setGyro(double center, double offset) {
		double val = center * 10;
		val %= 10;
		if (val >= 5) {
			++center;
		}
		gyro = new CustomGyro(RobotMap.GYRO, (int) center, offset);
	}

	public double getGyroOffset() {
		return gyro.getOffset();
	}
	
	public void setGyroOffset(double offset){
		gyro.setOffset(offset);
	}

	public int getGyroCenter() {
		return gyro.getCenter();
	}

	public void setGyroCenter(int center){
		gyro.setCenter(center);
	}
	public void calibrateGyro() {
		gyro.calibrate();
	}

	public void initGyro() {
		gyro.initGyro();
	}

	public double getAngle() {
		// if(gyro == null){
		// return 0;
		// //TODO IMU code
		// }else{
		return (gyro.getAngle() % 360) + (gyro.getAngle() < 0 ? 360 : 0);
		// }
	}

	public double getContinuousAngle() {
		return gyro.getAngle();
	}

	public void resetGyro() {
		// if (gyro == null) {
		// // TODO IMU code
		// } else {
		gyro.reset();
		// }
	}

	public CustomGyro getGyro() {
		return gyro;
	}

	public void initDefaultCommand() {
	}
}
