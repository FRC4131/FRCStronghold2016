package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import org.usfirst.frc.team4131.utilities.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Sensors extends Subsystem {
	private AnalogGyro gyro = null;

	// TODO IMU field
	public Sensors() {
		// TODO Instantiate IMU and add appropriate variables
		gyro = new AnalogGyro(RobotMap.GYRO);
		
		gyro.initGyro();
	}
	public void setGyroSensitivity(double voltsPerDegreePerSecond){
		gyro.setSensitivity(voltsPerDegreePerSecond);
	}
	public void setGyroOffset(double offset){
		gyro.setOffset(offset);
	}
	public void setGyroCenter(double center){
		double val = center * 10;
		val %= 10;
		if(val >= 5){
			++center;
		}
		gyro.setCenter((int)center);
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
