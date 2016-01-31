package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;
import org.usfirst.frc.team4131.robot.commands.Move;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TankDrive extends Subsystem {

	private CANTalon leftMotor, rightMotor;
	private Encoder leftTrack, rightTrack;
	private final double inputRadius = 1;
	private final double outputRadius = 2;
	private final double treadOutputRadius = 3;
	private final double ratio = inputRadius * outputRadius / inputRadius * treadOutputRadius / outputRadius; //finds the encoder calibration for distance calculations
	// Initialize your subsystem here
	public TankDrive() {
		super();
		leftMotor = new CANTalon(RobotMap.leftMotorController);
		rightMotor = new CANTalon(RobotMap.rightMotorController);
		leftTrack = new Encoder(RobotMap.leftEncoderA, RobotMap.leftEncoderB, false);//would spin clockwise or +
		rightTrack = new Encoder(RobotMap.rightEncoderA, RobotMap.rightEncoderB, true);//would spin counter-clockwise or -; boolean reverses direction

		leftTrack.setDistancePerPulse(ratio);
		rightTrack.setDistancePerPulse(ratio);
	}
	public void initDefaultCommand() {
		setDefaultCommand(new Move());
	}
	public void resetEncoders(){
		leftTrack.reset();
		rightTrack.reset();
	}
	/**
	 * Sets motor controllers to set speed
	 * @param speed1
	 * @param speed2
	 */
	public void move(double speed1, double speed2){
		leftMotor.set(speed1);
		rightMotor.set(speed2);
	}
	/**
	 * Returns the average distance calculated from both encoders.
	 * @return (double) Average of two encoders
	 */
	public double getDistance(){
		return (leftTrack.getDistance() + rightTrack.getDistance() / 2.0);
	}
}
