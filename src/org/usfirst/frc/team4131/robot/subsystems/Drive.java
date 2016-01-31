package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;
import org.usfirst.frc.team4131.robot.commands.DefaultDriveCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {
	private CANTalon left1, left2, right1, right2;
	private Encoder leftEnc, rightEnc;

	public Drive() {
		left1 = new CANTalon(RobotMap.DRIVE_LEFT1);
		left2 = new CANTalon(RobotMap.DRIVE_LEFT2);
		right1 = new CANTalon(RobotMap.DRIVE_RIGHT1);
		right2 = new CANTalon(RobotMap.DRIVE_RIGHT2);
		leftEnc = new Encoder(RobotMap.ENCODER_LEFT1, RobotMap.ENCODER_LEFT2);
		rightEnc = new Encoder(RobotMap.ENCODER_RIGHT1, RobotMap.ENCODER_RIGHT2);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DefaultDriveCommand());
	}

	public void drive(double left, double right) {
		left1.set(left);
		left2.set(left);
		right1.set(right);
		right2.set(right);
	}

	public int getLeftEncoder() {
		return leftEnc.get();
	}

	public int getRightEncoder() {
		return rightEnc.get();
	}
}
