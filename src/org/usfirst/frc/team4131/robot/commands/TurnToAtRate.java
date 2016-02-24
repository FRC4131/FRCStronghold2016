package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.utilities.PIDController;
import org.usfirst.frc.team4131.utilities.Point;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurnToAtRate extends Command {
	private double heading, rate;
	private PIDController controller;
	public TurnToAtRate(double heading, double rate){
		requires(Robot.drive);
		this.heading = heading; this.rate = rate;
		controller = new PIDController(0.65, 0, 0.4, -rate, rate);
	}
	public TurnToAtRate(Point coord, double rate){
		double x, y, angle;
		x = coord.x - Robot.CURRENT_X;
		y = coord.y - Robot.CURRENT_Y;
		angle = Math.toDegrees(Math.atan2(x, y));
		angle = angle - Robot.CURRENT_ANGLE;//correct Magnitude
		this.heading = angle;
		controller = new PIDController(0.65, 0, 0.4, -rate, rate);
	}
	@Override
	protected void initialize() {
		controller.start(getError());
	}

	@Override
	protected void execute() {
		double speed = controller.update(getError());
		SmartDashboard.putNumber("Angle Error", getError());
		Robot.drive.move(speed, -speed);
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(getError()) < 2;
	}

	@Override
	protected void end() {
		Robot.drive.move(0, 0);
	}
	@Override
	protected void interrupted() {
		Robot.drive.move(0, 0);
	}
	private double getError(){
		return heading - Robot.drive.getAngle();
	}
}
