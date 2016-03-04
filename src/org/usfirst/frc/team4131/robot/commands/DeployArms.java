package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DeployArms extends Command {
	private static final double DEADBAND = 15;
	private double angle;
	public DeployArms(double angle){
		requires(Robot.arms);
		this.angle = angle;
	}
	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.arms.setSpeed(-1);
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
