package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CancelArms extends Command {

    public CancelArms() {
    	requires(Robot.collector);
    	requires(Robot.handler);
    	requires(Robot.arms);
    	return;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	return;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	return;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	return;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	return;
    }
}
