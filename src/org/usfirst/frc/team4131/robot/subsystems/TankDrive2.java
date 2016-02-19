package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;
import org.usfirst.frc.team4131.robot.commands.Move;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *
 */
public class TankDrive2 extends Subsystem {

	private boolean halfSpeed = false;
	private CANTalon leftMotor1, leftMotor2, rightMotor1, rightMotor2;
	private Encoder leftTrack, rightTrack;
	private Gyro gyro;
	private final double ratio = ((8.5/211.6)/121.746)*186.5;//pulsePerInch
	public TankDrive2() {
		super();
		leftMotor1 = new CANTalon(RobotMap.DRIVE_LEFT1);
		leftMotor2 = new CANTalon(RobotMap.DRIVE_LEFT2);
		rightMotor1 = new CANTalon(RobotMap.DRIVE_RIGHT1);
		rightMotor2 = new CANTalon(RobotMap.DRIVE_RIGHT2);
		leftTrack = new Encoder(RobotMap.ENCODER_LEFT1, RobotMap.ENCODER_LEFT2, false);// would spin clockwise or +
		rightTrack = new Encoder(RobotMap.ENCODER_RIGHT1, RobotMap.ENCODER_RIGHT2, true);// would spin counter-clockwise or -; boolean reverses direction
		leftTrack.setDistancePerPulse(ratio);
		rightTrack.setDistancePerPulse(ratio);
		
		gyro = new AnalogGyro(RobotMap.GYRO);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new Move());
	}
	
	public void resetGyro(){
		gyro.reset();
	}
	public void resetEncoders() {
		leftTrack.reset();
		rightTrack.reset();
	}

	/**
	 * Cuts the speed in half
	 * 
	 * @param halfSpeed
	 */
	public void setHalfSpeed(boolean halfSpeed) {
		this.halfSpeed = halfSpeed;
	}

	/**
	 * Sets motor controllers to set speed
	 * 
	 * @param speed1
	 * @param speed2
	 */
	public void move(double speed1, double speed2) {
		if (halfSpeed) {// cuts the speed in half
			speed1 /= 2.0;
			speed2 /= 2.0;
		}
		leftMotor1.set(speed1);
		leftMotor2.set(speed1);
		rightMotor1.set(-speed2);
		rightMotor2.set(-speed2);
	}
	
	public double getAngle(){
		return gyro.getAngle();
	}
	
	/**
	 * Returns the average distance calculated from both encoders.
	 * 
	 * @return (double) Average of two encoders
	 */
	public double getDistance() {
		return (leftTrack.getDistance() + rightTrack.getDistance() / 2.0);
	}
}
