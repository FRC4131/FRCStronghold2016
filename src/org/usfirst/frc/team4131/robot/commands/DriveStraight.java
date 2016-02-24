package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.utilities.PIDController;
import org.usfirst.frc.team4131.utilities.Point;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraight extends PositionCommand {
	
	private PIDController angleController;
	
	private double distance;
	private double angle;
	private double maxSpeed;
	
	private static final double DEAD_ZONE = 3.0;

	/**
	 * Distance, heading, speed params
	 * @param distance
	 * @param heading
	 * @param speed
	 */
	public DriveStraight(double distance, double heading, double speed) {
		super();
    	requires(Robot.drive);
    	
    	maxSpeed = speed;
    	this.distance = distance;
    	angle = heading;
    	
    	if (distance < 0)
    		maxSpeed *= -1;
    	
    	angleController = new PIDController(1, 0, 0, -(Math.abs(maxSpeed)) / 2, Math.abs(maxSpeed) / 2);
    }
	public DriveStraight(Point coord, double speed) {
		double x = coord.x - Robot.CURRENT_X;
		double y = coord.y - Robot.CURRENT_Y;
		double movementEncured = Math.pow(x * x + y * y, 0.5);
		
		distance = movementEncured;
		
		double heading = Robot.CURRENT_ANGLE;
		
    	requires(Robot.drive);
    	
    	maxSpeed = speed;
    	
    	angle = heading;
    	
    	if (distance < 0)
    		maxSpeed *= -1;
    	
    	angleController = new PIDController(1, 0, 0, -(Math.abs(maxSpeed)) / 2, Math.abs(maxSpeed) / 2);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	double angleError = angle - Robot.drive.getAngle();
    	
    	angleController.start(angleError);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double angleError = angle - Robot.drive.getAngle();
    	
    	double angleCommand = angleController.update(angleError);
    	
//    	if((maxSpeed < 0) != (angleCommand < 0)) angleCommand = -angleCommand;
		angleCommand = 0;
    	Robot.drive.move(maxSpeed + angleCommand, maxSpeed - angleCommand);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(distance - Robot.drive.getDistance()) <= DEAD_ZONE;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drive.move(0, 0);
    	super.end();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drive.move(0, 0);
    	super.interrupted();
    }
}
