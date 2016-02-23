package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.utilities.PIDController;

import edu.wpi.first.wpilibj.command.Command;

public class DeployArms extends Command {
	private static final double DEADBAND = 15;
	private double angle;
	private PIDController controller;
	public DeployArms(double angle){
		requires(Robot.arms);
		this.angle = angle;
    	controller = new PIDController(0.1, 0, 0, -1.0, 1.0);
	}
	@Override
	protected void initialize() {
		controller.start(angle - Robot.arms.getAngle());
	}

	@Override
	protected void execute() {
		Robot.arms.setSpeed(-controller.update(angle - Robot.arms.getAngle()));
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(Robot.arms.getAngle() - angle) < DEADBAND;
	}

	@Override
	protected void end() {
		Robot.arms.setSpeed(0);
	}

	@Override
	protected void interrupted() {
		Robot.arms.setSpeed(0);
	}

}
