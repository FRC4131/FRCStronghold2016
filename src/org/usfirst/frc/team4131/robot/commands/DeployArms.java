package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DeployArms extends Command {
	private static final double DEADBAND = 20;
	private static final double SPEED = 1;
	private double angle;

	//angles decrease (negative increments)
	public DeployArms(double angle) {
		requires(Robot.arms);
		this.angle = angle;
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.arms.setSpeed(SPEED);
	}

	@Override
	protected boolean isFinished() {//due to the locked location we KNOW that it will achieve this or greater distance. the deadband may stop it sooner which is greater
		return Robot.arms.getAngle() <= Math.copySign(Math.abs(angle) + Math.abs(DEADBAND), angle) 
				|| Math.abs(Robot.arms.getAngle() - angle) <= DEADBAND;
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
