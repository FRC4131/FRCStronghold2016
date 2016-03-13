package org.usfirst.frc.team4131.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Makes a pause X seconds long. Useful in CommandGroups.
 */
public class Wait extends Command {
	public Timer timer;
	public final double time;

	public Wait(double time) {
		this.time = time;
		timer = new Timer();
	}

	protected void initialize() {
		timer.reset();
		timer.start();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return timer.hasPeriodPassed(time);
	}

	protected void end() {
		timer.stop();
	}

	protected void interrupted() {
		timer.stop();
	}
}
