package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PositionCommand extends Command {
	private double distanceInit;
	public double distanceTravled = 0;
	public PositionCommand(){
    	distanceInit = Robot.drive.getDistance();
	}
    protected void initialize() {
    	distanceInit = Robot.drive.getDistance();
    }
    protected void execute() {
    	distanceTravled = distanceInit - Robot.drive.getDistance();
    }
    protected void end() {
    	updatePosition();
    }
    protected void interrupted() {
    	updatePosition();
    }
	protected boolean isFinished() {
		return false;
	}
	private void updatePosition(){
    	distanceTravled = distanceInit - Robot.drive.getDistance();
    	double angleOfMovement = Robot.CURRENT_ANGLE;
		double xMoved = -Math.sin(Math.toRadians(angleOfMovement)) * distanceTravled;
		double yMoved = -Math.cos(Math.toRadians(angleOfMovement)) * distanceTravled;
    	Robot.CURRENT_X += xMoved;
    	Robot.CURRENT_Y += yMoved;
	}
}