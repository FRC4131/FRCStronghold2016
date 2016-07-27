package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class UpdateLauncherPID extends Command {
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		PIDController controller = ChargeShooter.instance().controller;
		controller.setPID(Robot.getDashboardValue("Launcher P", 0) / 1000,// /1000 for precision
				Robot.getDashboardValue("Launcher I", 0) / 1000,
				Robot.getDashboardValue("Launcher D", 0) / 1000,
				Robot.getDashboardValue("Launcher F", 0) / 1000);
		controller.setSetpoint(SmartDashboard.getNumber("TARGET RPM"));
		SmartDashboard.putNumber("snoot", SmartDashboard.getNumber("snoot", 0) + 1);
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
