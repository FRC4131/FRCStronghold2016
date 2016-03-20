package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.utilities.PIDController;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class VisionAssistAim extends Command {
	
	private double targetAngle = 0;
	private PIDController controller;

    public VisionAssistAim() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    	controller = new PIDController(1, 0.1, 0.2, -0.7, 0.7);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	controller.start(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (isTracking())
    	{
    		targetAngle = convertToAbsoluteAngle(getRelativeAngleFromCamera());
    		SmartDashboard.putNumber("Target Error", getError());
    	}
    	
    	double turnRate = controller.update(-getError());
    	Robot.drive.move(-turnRate, turnRate);
    	
    	SmartDashboard.putNumber("Vision Turn Rate", turnRate);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    protected double getRelativeAngleFromCamera()
    {
    	double targetX = SmartDashboard.getNumber("TargetX");
    	return (targetX - 160.0) * 25.0/160.0;
    }
    
    protected double convertToAbsoluteAngle(double relativeAngle)
    {
    	return Robot.sensors.getContinuousAngle() + relativeAngle;
    }
    
    protected boolean isTracking()
    {
    	return SmartDashboard.getNumber("Tracking") == 1;
    }
    
    protected double getError()
    {
    	return targetAngle - Robot.sensors.getContinuousAngle();
    }
}
