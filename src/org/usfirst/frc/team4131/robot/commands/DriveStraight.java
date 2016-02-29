package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.utilities.PIDController;
import org.usfirst.frc.team4131.utilities.Point;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveStraight extends PositionCommand {
	
	private PIDController angleController;
	private double distance;
	private double heading;
	private double maxSpeed;
	private boolean headingSet = false;
	private Point p = null;
	
	private static final double DEAD_ZONE = 2.0;

	/**
	 * Distance, heading, speed params
	 * @param distance
	 * @param heading
	 * @param speed
	 */
	public DriveStraight(double distance, double heading, double speed) {
		super();
    	requires(Robot.drive);
    	
    	this.maxSpeed = speed;
    	this.distance = distance;
    	this.heading = heading;
    	
    	headingSet = true;
    	
    	if (distance < 0)
    		maxSpeed *= -1;
    	
    	angleController = new PIDController(1, 0, 0, -(Math.abs(maxSpeed)) / 2, Math.abs(maxSpeed) / 2);
    }
	public DriveStraight(Point coord, double speed) {
		p = coord;
		this.maxSpeed = speed;
		
    	requires(Robot.drive);
    	
    	maxSpeed = speed;
    	
    	if (distance < 0)
    		maxSpeed *= -1;
    	
    	angleController = new PIDController(1, 0, 0, -(Math.abs(maxSpeed)) / 2, Math.abs(maxSpeed) / 2);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	double angleError = heading - Robot.drive.getAngle();
    	
    	angleController.start(angleError);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	if(!this.headingSet){//this is only here because init is called before the command starts
    		if(p != null){
    			double x = p.x - Robot.CURRENT_X;
				double y = p.y - Robot.CURRENT_Y;
				double movementEncured = Math.pow(x * x + y * y, 0.5);
				
				distance = movementEncured;
				
	    		this.heading = Robot.drive.getAngle();
	    		this.headingSet = true;
	    		
	    		super.initialize();
    		}
    	}
    	double angleCommand = angleController.update(getError());
    	
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
    	Robot.drive.resetEncoders();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drive.move(0, 0);
    	super.interrupted();
    }
	private double getError(){
		double error =(Robot.drive.getAngle() - heading % 360);
		if (error < 0 )  error  = error + 360;
		if (error > 180) error  = error - 360;
		return (-error);
	}
}
