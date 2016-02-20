package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class StowArms extends Command {
	public StowArms(){
		requires(Robot.arms);
		requires(Robot.collector);
	}
	@Override
	protected void initialize() {
		SmartDashboard.putString("Stow Status", "Executing");
	}

	@Override
	protected void execute() {
		Robot.arms.setSpeed(1);
		Robot.collector.spin(0);
		SmartDashboard.putString("Stow Status", "Executing");
	}

	@Override
	protected boolean isFinished() {
		if(Robot.arms.isStowed()) SmartDashboard.putString("Stow Status", "Stowed");
		return Robot.arms.isStowed();
	}

	@Override
	protected void end() {
		Robot.arms.setSpeed(0);
		Robot.arms.resetEncoder();
		SmartDashboard.putString("Stow Status", "Exiting");
	}

	@Override
	protected void interrupted() {
		Robot.arms.setSpeed(0);
		if(Robot.arms.isStowed()) Robot.arms.resetEncoder();
		SmartDashboard.putString("Stow Status", "Interrupted");

	}
}
