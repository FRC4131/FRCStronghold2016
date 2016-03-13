package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class EmergencyStop extends Command {
	private boolean EMERGENCY_STATE;

	public EmergencyStop(boolean state) {
		EMERGENCY_STATE = state;
		requires(Robot.arms);
		requires(Robot.collector);
		requires(Robot.drive);
		requires(Robot.handler);
		requires(Robot.shooter);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.arms.setSpeed(0);
		Robot.collector.spin(0);
		Robot.drive.move(0, 0);
		Robot.handler.spin(0);
		Robot.shooter.setSpeed(0);

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.arms.setSpeed(0);
		Robot.collector.spin(0);
		Robot.drive.move(0, 0);
		Robot.handler.spin(0);
		Robot.shooter.setSpeed(0);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return !EMERGENCY_STATE;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
