package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollectBoulder extends Command {
	
	private static final double COLLECTOR_SPEED = -1.0;
	private static final double HANDLER_SPEED = 1.0;

    public CollectBoulder() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.collector);
    	requires(Robot.handler);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.collector.spin(COLLECTOR_SPEED);
    	Robot.handler.spin(HANDLER_SPEED);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.handler.isCaptured();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.handler.spin(0);
    	Robot.collector.spin(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.handler.spin(0);
    	Robot.collector.spin(0);
    }
}