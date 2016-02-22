package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class UpdateXY extends Command {

    public UpdateXY() {
    	double angleOfMovement = Robot.CURRENT_ANGLE;
		double xMoved = -Math.sin(Math.toRadians(angleOfMovement)) * Robot.drive.getDistance();
		double yMoved = -Math.cos(Math.toRadians(angleOfMovement)) * Robot.drive.getDistance();
    	Robot.CURRENT_X += xMoved;
    	Robot.CURRENT_Y += yMoved;
    	Robot.drive.resetEncoders();
    }
    protected void initialize() {
    	return;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	return;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	return;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	return;
    }
}
