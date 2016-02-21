package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.utilities.PIDController;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurnToAtRate extends Command {
	private double heading, rate;
	private PIDController controller;
	public TurnToAtRate(double heading, double rate){
		requires(Robot.drive);
		this.heading = heading; this.rate = rate;
		controller = new PIDController(1.2, 0, 0.4, -rate, rate);
	}
	@Override
	protected void initialize() {
		controller.start(getError());
	}

	@Override
	protected void execute() {
		double speed = controller.update(getError());
		SmartDashboard.putNumber("Angle Error", getError());
		SmartDashboard.putNumber("Angle", Robot.drive.getAngle());
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
