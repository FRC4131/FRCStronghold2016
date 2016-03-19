package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.utilities.PIDController;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Every tenth of a second updates camera error resets angle controller for new
 * angle Every update, updates angle controller
 */
public class VisionAssistAim extends Command {

	public PIDController angleController;
	private static final int FRAME_X = 340;

	private double cameraError;
	private Timer cameraTimer;

	private double targetAngle;

	private static final double DEAD_ZONE = 1.1;
	private static final double TIME_OUT_PERIOD = 5.0;

	public VisionAssistAim() {
		requires(Robot.drive);
		angleController = new PIDController(0.8, 0.2, 0.6, -0.8, 0.8);

		cameraTimer = new Timer();
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		updateCameraError();
		targetAngle = Robot.sensors.getAngle() + convertToRelativeAngle();

		angleController.start(targetAngle - Robot.sensors.getAngle());
		cameraTimer.reset();
		cameraTimer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (cameraTimer.hasPeriodPassed(0.1)) {
			updateCameraError();
			targetAngle = Robot.sensors.getAngle() + convertToRelativeAngle();
			angleController.start(targetAngle - Robot.sensors.getAngle());
		}

		double turnRate = angleController.update(Robot.sensors.getAngle() - targetAngle);
		Robot.drive.move(-turnRate, turnRate);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Math.abs(targetAngle - Robot.sensors.getAngle()) <= DEAD_ZONE || cameraTimer.hasPeriodPassed(TIME_OUT_PERIOD);
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.drive.move(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.drive.move(0, 0);
	}

	protected void updateCameraError() {
		if (SmartDashboard.getNumber("Tracking") == 1)
			cameraError = FRAME_X / 2 - SmartDashboard.getNumber("TargetX");
	}

	protected double convertToRelativeAngle() {
		return transform(0, FRAME_X, -25, 25, cameraError);
	}

	public static double transform(double iMin, double iMax, double oMin, double oMax, double i) {
		double m = (oMax - oMin) / (iMax - iMin);
		double b = oMin - m * iMin;
		return m * i + b;
	}
}
