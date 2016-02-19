package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.utilities.PIDController;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraight extends Command {
	private double distance, angle, maxSpeed;
	private PIDController speedController, angleController;

	public DriveStraight(double angle, double speed, double distance) {
		maxSpeed = speed;
		this.angle = angle;
		this.distance = distance;
	}

    // Called just before this Command runs the first time
    protected void initialize() {
    	speedController = new PIDController(0.01, 0, 0, distance, -maxSpeed, maxSpeed);
    	angleController = new PIDController(0.01, 0, 0, angle, -maxSpeed / 2, maxSpeed / 2);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Constrain input to make the robot always start at the same rate
    	// the pidcontroller multiplies error by Kp, so a large distance would make the
    	// robot start faster
    	double speed = speedController.update()
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return Math.abs(Robot.drive.getDistance() - distance) <= 0.5;
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
