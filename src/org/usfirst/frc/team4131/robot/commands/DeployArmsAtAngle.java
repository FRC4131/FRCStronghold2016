package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.utilities.PIDController;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DeployArmsAtAngle extends Command {
	
	private PIDController controller;
	private double angle;
	
	private static final int DEAD_ZONE = 1;
	

    public DeployArmsAtAngle(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.arms);
    	this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	controller = new PIDController(0.01, 0, 0, 0, 1.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double angleError = angle - Robot.arms.getAngle();
    	Robot.arms.setSpeed(controller.update(angleError));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(angle - Robot.arms.getAngle()) <= DEAD_ZONE;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.arms.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.arms.setSpeed(0);
    }
}
