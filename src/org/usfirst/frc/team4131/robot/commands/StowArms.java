package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StowArms extends Command {
	private static final double FULL_REVERSE = 1;

	public StowArms() {
		requires(Robot.arms);
		requires(Robot.collector);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		Robot.arms.setSpeed(FULL_REVERSE);
		Robot.collector.spin(0);
	}

	@Override
	protected boolean isFinished() {
		return Robot.arms.isStowed();
	}

	@Override
	protected void end() {
		Robot.arms.setSpeed(0);
		Robot.arms.resetEncoder();
	}

	@Override
	protected void interrupted() {
		Robot.arms.setSpeed(0);
		if (Robot.arms.isStowed())
			Robot.arms.resetEncoder();

	}
}
