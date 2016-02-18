package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UnloadBoulder extends Command {
	
	private static final double UNLOAD_TIME = 2.0;
	private static final double UNLOAD_SPEED = 0.7;
	
	private Timer timer;

    public UnloadBoulder() {
    	timer = new Timer();
    	requires(Robot.handler);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();
    	timer.start();
    	
    	Robot.handler.spin(UNLOAD_TIME);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.hasPeriodPassed(UNLOAD_TIME);
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
