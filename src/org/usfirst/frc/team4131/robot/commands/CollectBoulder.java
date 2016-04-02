package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CollectBoulder extends Command {
	//	private static final double COLLECTOR_SPEED = 1.0;
	private static final double COLLECTOR_SPEED = -1.0;
	//	private static final double HANDLER_SPEED = 0.7;
	private static final double HANDLER_SPEED = -0.7;

	public CollectBoulder() {
		requires(Robot.collector);
		requires(Robot.handler);
		SmartDashboard.putString("Collect State", "Constructor");
	}

	protected void initialize() {
		SmartDashboard.putString("Collect State", "Init");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.collector.spin(COLLECTOR_SPEED);
		Robot.handler.spin(HANDLER_SPEED);
		SmartDashboard.putString("Collect State", "Execute");
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.handler.isCaptured();
	}

	// Called once after isFinished returns tru
	protected void end() {
		Robot.handler.spin(0);
		Robot.collector.spin(0);
		new StowArms().start();
		SmartDashboard.putString("Collect State", "End");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.handler.spin(0);
		Robot.collector.spin(0);
		SmartDashboard.putString("Collect State", "Interrupt");
	}
}
