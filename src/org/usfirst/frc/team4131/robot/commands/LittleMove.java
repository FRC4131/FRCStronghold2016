package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LittleMove extends Command {

	public LittleMove() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.drive);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Robot.oi.getLittleSpeed() == 0){
			Robot.drive.move(0.3, 0.3);
		}
		if (Robot.oi.getLittleSpeed() == 2){
			Robot.drive.move(0.3, -0.3);
		}
		if (Robot.oi.getLittleSpeed() == 4){
			Robot.drive.move(-0.3, -0.3);
		}
		if (Robot.oi.getLittleSpeed() == 6){
			Robot.drive.move(-0.3, 0.3);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
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