package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class VisionAssistAim extends Command {
	
	private static final double FRAME_WIDTH = 320;
	private static final double DEAD_ZONE = 10;
	private static final double FRAME_CENTER = FRAME_WIDTH / 2;
	private static final double FRAME_PERIOD = 1.0/12.0;
	private static final double FOV = 90;
	
	private double error;
	
	private Timer timer;

    public VisionAssistAim() {
    	requires(Robot.drive);
    	timer = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.reset();
    	timer.start();
    	updateError();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (timer.hasPeriodPassed(FRAME_PERIOD))
    	{
    		updateError();
    		
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return error <= DEAD_ZONE;
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
    
    protected void updateError()
    {
    	double blobX = SmartDashboard.getNumber("Target X");
    	error = FRAME_CENTER - blobX;
    }
}
