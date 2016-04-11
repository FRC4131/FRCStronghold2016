package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.utilities.ChrisPIDController;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Turn extends Command {
	private ChrisPIDController controller;
	private double angle;
	private final double DEADBAND = 2.5;

	public Turn(double angle) {
		requires(Robot.drive);
		this.angle = angle;
		controller = new ChrisPIDController(0.6, 0.2, 0, -0.4, 0.4);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		controller.start(angle - Robot.sensors.getAngle());
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (!(Math.abs(Robot.sensors.getAngle() - angle) <= DEADBAND)) {
			double speed = controller.update(angle - Robot.sensors.getAngle());
			if (speed < 0) {
				speed = -speed;
			}
			Robot.drive.move(speed, -speed);//Positive error (right turn) means left goes forward, right goes back
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Math.abs(Robot.sensors.getAngle() - angle) <= DEADBAND;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drive.move(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.drive.move(0, 0);
	}
}
