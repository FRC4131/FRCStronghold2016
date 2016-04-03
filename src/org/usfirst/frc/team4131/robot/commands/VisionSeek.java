package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.utilities.GyroControlOutput;
import org.usfirst.frc.team4131.utilities.GyroSource;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;

public class VisionSeek extends Command {
	private PIDController controller;
	private static final double DEADBAND = 1.0, SPEED = 0.35;
	private static double targetAngle, azSteer;
	private GyroSource gyroSource = new GyroSource();
	private GyroControlOutput output = new GyroControlOutput();
	boolean finished = false;
	boolean zonedIn = false;
	private Timer timer = new Timer();

	public VisionSeek() {
		requires(Robot.drive);
		/**
		 * 
		 */
		controller = new PIDController(0.4, 0, 0.1, 0.2, gyroSource, output);
		controller.setOutputRange(-SPEED, SPEED);
	}

	@Override
	protected void initialize() {
		try{
			updateCameraError();
			controller.enable();
			timer.reset();
			timer.start();
		}catch(Exception e){
			finished = true;
		}
	}

	@Override
	protected void execute() {
		if (Math.abs(error()) <= 10 && !zonedIn) {
			controller.disable();
			controller.free();
			controller = new PIDController(0.0275, 0.002, 0.01, 0.2, gyroSource, output);
			controller.enable();
			zonedIn = true;
		}
		if (Math.abs(error()) <= DEADBAND) {
			updateCameraError();
			gyroSource.setTargetAngle(targetAngle);
			finished = Math.abs(azSteer) <= DEADBAND;
		}
		SmartDashboard.putNumber("Target Angle", targetAngle);
		SmartDashboard.putNumber("Gyro Error", gyroSource.pidGet());
	}

	@Override
	protected boolean isFinished() {
		return finished;
	}

	@Override
	protected void end() {
		controller.disable();
		Robot.drive.move(0, 0);
	}

	@Override
	protected void interrupted() {
		controller.disable();
		Robot.drive.move(0, 0);
	}

	private double error() {
		return targetAngle - Robot.sensors.getContinuousAngle();
	}

	private void updateCameraError() {
		if (SmartDashboard.getNumber("BLOB_COUNT") > 0) {
			try {
				azSteer = SmartDashboard.getNumber("Az_Steer");
				targetAngle = SmartDashboard.getNumber("Az_Steer") + Robot.sensors.getContinuousAngle();
				gyroSource.setTargetAngle(targetAngle);
			} catch (TableKeyNotDefinedException ex) {
				DriverStation.reportError(ex.getClass().getCanonicalName() + ": " + ex.getMessage() + "\n", true);
				cancel();
			}
		}
	}
}
