package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UnloadBoulder extends Command {

	private static final double UNLOAD_SPEED = 1.0;

	public UnloadBoulder() {
		requires(Robot.handler);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.handler.spin(UNLOAD_SPEED);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return !Robot.oi.getSpitOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.handler.spin(0.0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.handler.spin(0.0);
	}
}
