package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;
import org.usfirst.frc.team4131.utilities.CustomGyro;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Sensors extends Subsystem {
	private CustomGyro gyro = null;

	// TODO IMU field
	public Sensors() {
		// TODO Instantiate IMU and add appropriate variables
		gyro = new CustomGyro(RobotMap.GYRO);
		
		gyro.initGyro();
	}
	public void setGyroSensitivity(double voltsPerDegreePerSecond){
		gyro.setSensitivity(voltsPerDegreePerSecond);
	}
	public void setGyro(double center, double offset){
		double val = center * 10;
		val %= 10;
		if(val >= 5){
			++center;
		}
		gyro = new CustomGyro(RobotMap.GYRO, (int)center, offset);
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
	public void initGyro(){
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
	public CustomGyro getGyro(){
		return gyro;
	}
	public void initDefaultCommand() {
	}
}
