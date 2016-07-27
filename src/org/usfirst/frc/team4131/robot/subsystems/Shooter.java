package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;
import org.usfirst.frc.team4131.robot.commands.ChargeShooter;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
	private static final double PULSE_RATIO = 0.333;
	private CANTalon motor;
	private Encoder encoder;

	public Shooter() {
		motor = new CANTalon(RobotMap.SHOOTER_MOTOR);
		encoder = new Encoder(RobotMap.SHOOTER_ENCODER_A, RobotMap.SHOOTER_ENCODER_B);
	}

	public double getRate() {
		return encoder.getRate() / PULSE_RATIO;
	}

	public void initDefaultCommand() {
		setDefaultCommand(ChargeShooter.instance());
	}
	
	public CANTalon getMotor(){
		return motor;
	}
	public void setSpeed(double speed) {
//		if(!(motor.get() >= 0.5 && getRate() <= 100)){	
//			motor.set(speed);
//		}
//		motor.set(speed);
	}

	public double getCommand() {
		return motor.get();
	}
}
