package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogAccelerometer;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *
 */
public class Sensors extends Subsystem {
    private Gyro gyro = null;
    //TODO IMU field
	public Sensors(){
		//TODO Instantiate IMU and add appropriate variables
	}
	public Sensors oldGyro(){
		gyro = new AnalogGyro(RobotMap.GYRO);
		return this;
	}
	public double getAngle(){
		if(gyro == null){
			return 0;
			//TODO IMU code
		}else{
			return (gyro.getAngle() % 360) + (gyro.getAngle() < 0 ? 360 : 0);
		}
	}

	public void resetGyro() {
		if(gyro == null){
			//TODO IMU code
		}else{
			gyro.reset();
		}
	}
    public void initDefaultCommand() {
    	//none I can think of at the moment
    }
}

