package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.utilities.ShooterControlOutput;
import org.usfirst.frc.team4131.utilities.ShooterSource;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**weZS#-[
 *
 */
public class ChargeShooter extends Command {
	public static double TARGET_SPEED = 4500.0;
	private static final double PULSE_RATIO = 0.333;
	
	private ShooterSource shooterSource = new ShooterSource(TARGET_SPEED * PULSE_RATIO);
	private ShooterControlOutput output = new ShooterControlOutput();

	private PIDController controller;

	public ChargeShooter() {
		controller = new PIDController(0.008, 0.005, 0.001, 0.65, shooterSource, output);
		/*for calculating kp and kf: pg 76 - 78 of vex srx software manual*/
		requires(Robot.shooter);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		controller.enable();
		controller.setOutputRange(0.6, 0.95);
	}
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		shooterSource.setTarget(SmartDashboard.getNumber("TARGET RPM") * PULSE_RATIO);
		SmartDashboard.putNumber("Shooter Error", controller.getError());
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
	public void setTargetRPM(double targetRPM){
		TARGET_SPEED = targetRPM;
	}
}
