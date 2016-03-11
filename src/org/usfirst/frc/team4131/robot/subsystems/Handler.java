package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Handler extends Subsystem {

	private SpeedController motor;
	private DigitalInput captured;

	public Handler() {
		motor = new CANTalon(RobotMap.HANDLER_MOTOR);
		captured = new DigitalInput(RobotMap.HANDLER_SWITCH);
	}

	public void spin(double speed) {
		motor.set(speed);
	}

	public boolean isCaptured() {
		return captured.get();
	}

	protected void initDefaultCommand() {
	}

	public double getSpeed() {
		return motor.get();
	}
}
