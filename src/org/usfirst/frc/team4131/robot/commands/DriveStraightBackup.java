package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.utilities.PIDController;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightBackup extends Command {
	private PIDController controller;
	private double speed, distance;
    public DriveStraightBackup(double angle, double speed, double distance) {
    	requires(Robot.drive);
    	this.speed = speed;
    	this.distance = distance;
    	controller = new PIDController(0.1, 0, 0, angle, -speed / 2, speed / 2);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	controller.reset();
    	Robot.drive.resetEncoders();
    	if((distance < 0) != (speed < 0)){
    		speed *= -1;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double output = controller.update(Robot.drive.getAngle());
    	Robot.drive.move(speed - output, speed + output);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Math.abs(Robot.drive.getDistance() - distance) <= 2;
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
