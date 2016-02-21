package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.utilities.PIDController;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveStraight extends Command {
	
	private PIDController speedController;
	private PIDController angleController;
	
	private double distance;
	private double angle;
	private double maxSpeed;
	
	private static final double DEAD_ZONE = 1.0;

    public DriveStraight(double distance, double heading, double speed) {
    	requires(Robot.drive);
    	
    	maxSpeed = speed;
    	this.distance = distance;
    	angle = heading;
    	
    	if (distance < 0)
    		maxSpeed *= -1;
    	
    	speedController = new PIDController(1, 0.1, 0, -(Math.abs(maxSpeed)), Math.abs(maxSpeed));
    	angleController = new PIDController(1, 0, 0, -(Math.abs(maxSpeed)) / 2, Math.abs(maxSpeed) / 2);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	double distanceError = Robot.constrain(distance, -1.0, 1.0);
    	double angleError = angle - Robot.drive.getAngle();
    	
    	speedController.start(distanceError);
    	angleController.start(angleError);
    	
    	Robot.drive.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double distanceError = Robot.constrain(Robot.drive.getDistance() - distance, -10, 10);
    	double angleError = angle - Robot.drive.getAngle();
    	
    	double speed = -speedController.update(distanceError);
    	double angleCommand = angleController.update(angleError);
    	
//    	if((maxSpeed < 0) != (angleCommand < 0)) angleCommand = -angleCommand;
		
    	Robot.drive.move(speed + angleCommand, speed - angleCommand);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(distance - Robot.drive.getDistance()) <= DEAD_ZONE;
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
