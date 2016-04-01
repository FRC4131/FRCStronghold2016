package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.utilities.PIDController;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;

public class VisionSeek extends Command {
	private static final double DEADBAND = 0.25, SPEED = 0.5;
	private PIDController controller;

	public VisionSeek() {
		requires(Robot.drive);
		controller = new PIDController(0.1, 0.015, 0.04, -SPEED, SPEED);
	}

	@Override
	protected void initialize() {
		controller.start(error());
	}

	@Override
	protected void execute() {
		double command = controller.update(error());
		SmartDashboard.putNumber("VisionSeek Command", command);
		Robot.drive.move(command, -command);
	}

	@Override
	protected boolean isFinished() {
		boolean finished = Math.abs(error()) <= DEADBAND;
		if(finished) SmartDashboard.putNumber("VisionSeek Finishing Error", error());
		return finished;
	}

	@Override
	protected void end() {
		Robot.drive.move(0, 0);
	}

	@Override
	protected void interrupted() {
		Robot.drive.move(0, 0);
	}

	private double error() {
		try {
			return SmartDashboard.getNumber("Az_Steer");
		} catch (TableKeyNotDefinedException ex) {
			DriverStation.reportError(ex.getClass().getCanonicalName() + ": " + ex.getMessage() + "\n", true);
			cancel();
			return 0;
		}
	}
}
