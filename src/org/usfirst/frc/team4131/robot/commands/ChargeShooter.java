package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.utilities.PIDController;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ChargeShooter extends Command {
	private static final double TARGET_SPEED = 5200.0;
	private static final double PULSE_RATIO = 0.333;

	private PIDController controller;

	private Timer timer;

	public ChargeShooter() {
		controller = new PIDController(0.008, 0.005, 0.001, 0, 1);
		timer = new Timer();
		requires(Robot.shooter);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		controller.start(TARGET_SPEED);
		timer.reset();
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double readSpeed = Robot.shooter.getRate();
		double command;
		double error;

		error = TARGET_SPEED * PULSE_RATIO - readSpeed;
		SmartDashboard.putNumber("Shooter Error", error);
		command = controller.update(TARGET_SPEED * PULSE_RATIO - readSpeed);
		Robot.shooter.setSpeed(command);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.shooter.setSpeed(0.0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.shooter.setSpeed(0.0);
	}
}
