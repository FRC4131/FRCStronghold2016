package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Sensors extends Subsystem {
	private AnalogGyro gyro = null;

	// TODO IMU field
	public Sensors() {
		// TODO Instantiate IMU and add appropriate variables
		//From Naoki's excel analysis of gyro data
		//Needs to be done for each distinct gyro
		gyro = new AnalogGyro(RobotMap.GYRO, 2015507, 0.036616);
	}
	public void setGyroSensitivity(double voltsPerDegreePerSecond){
		gyro.setSensitivity(voltsPerDegreePerSecond);
	}
	public double getGyroOffset(){
		return gyro.getOffset();
	}
	public int getGyroCenter(){
		return gyro.getCenter();
	}
	public void calibrateGyro(){
		gyro.calibrate();
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

	public void initDefaultCommand() {
	}
}
