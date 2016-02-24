package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;
import org.usfirst.frc.team4131.robot.commands.ChargeShooter;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

	private SpeedController motor;
	private Encoder encoder;

	public Shooter() {
		motor = new CANTalon(RobotMap.SHOOTER_MOTOR);
		encoder = new Encoder(RobotMap.SHOOTER_ENCODER_A, RobotMap.SHOOTER_ENCODER_B);
	}

	public double getRate() {
		return encoder.getRate();
	}

	public void initDefaultCommand() {
		setDefaultCommand(new ChargeShooter());
		encoder.reset();
	}

	public void setSpeed(double speed) {
		 motor.set(speed);
	}

	public double getSpeed() {
		return motor.get();
	}
}
