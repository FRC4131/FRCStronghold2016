package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.utilities.ShooterControlOutput;
import org.usfirst.frc.team4131.utilities.ShooterSource;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ChargeShooter extends Command {
	private static ChargeShooter instance;
	public static ChargeShooter instance(){
		return instance == null ? instance = new ChargeShooter() : instance;
	}
//	private static final double PULSE_RATIO = 0.333;
	
	private ShooterSource shooterSource = new ShooterSource();
	private ShooterControlOutput output = new ShooterControlOutput();

	PIDController controller;

	private ChargeShooter() {
		requires(Robot.shooter);
		controller = new PIDController(0, 0, 0, 0, shooterSource, output, 0.01);
//		/*for calculating kp and kf: pg 76 - 78 of vex srx software manual*/
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		controller.enable();
		controller.setOutputRange(0, 1);
	}
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartDashboard.putNumber("Shooter Error", controller.getError());
		SmartDashboard.putNumber("R-Launcher P", controller.getP());
		SmartDashboard.putNumber("R-Launcher I", controller.getI());
		SmartDashboard.putNumber("R-Launcher D", controller.getD());
		SmartDashboard.putNumber("R-Launcher F", controller.getF());
		SmartDashboard.putNumber("R-Launcher Error", controller.getError());
		SmartDashboard.putNumber("R-Launcher Setpoint", controller.getSetpoint());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		controller.disable();
		Robot.shooter.setSpeed(0.0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		controller.disable();
		Robot.shooter.setSpeed(0.0);
	}
}
