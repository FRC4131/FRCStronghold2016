package org.usfirst.frc.team4131.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

<<<<<<< HEAD
import bin.com.kauailabs.navx.frc.AHRS;
=======
>>>>>>> 57962777a1e7a1a46811648cf2ecf1e3871b640e
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Sensors extends Subsystem {
	private AHRS imu;

	public Sensors() {
<<<<<<< HEAD
		// TODO Instantiate IMU and add appropriate variables
		gyro = new CustomGyro(RobotMap.GYRO);//TODO find out if we still need this
		ahrs = new AHRS(SPI.Port.kMXP);
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
//		gyro.calibrate();
	}

	public void initGyro() {
		gyro.initGyro();
	}

	public double getAngle() {
		// if(gyro == null){
		// return 0;
		// //TODO IMU code
		// }else{
//		return (gyro.getAngle() % 360) + (gyro.getAngle() < 0 ? 360 : 0);
		return ahrs.getRoll();
		// }
=======
		imu = new AHRS(SPI.Port.kMXP);
	}

	public double getAngle() {
		return (imu.getYaw() % 360) + (imu.getYaw() < 0 ? 360 : 0);
>>>>>>> 57962777a1e7a1a46811648cf2ecf1e3871b640e
	}

	public double getContinuousAngle() {
		return imu.getYaw();
	}

	public void resetGyro() {
		imu.zeroYaw();
	}

	protected void initDefaultCommand() {
	}
}
