package org.usfirst.frc.team4131.robot.commands;

import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.utilities.PIDController;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class UTurn extends Command {
	private double target;
//	private static final double DEADBAND = 10;
	private PIDController controller;
	public UTurn() {
		requires(Robot.drive);
		controller = new PIDController(0.6, 0.2, 0, -1000, 1000);
	}
	@Override
	public void initialize(){
		target = Robot.sensors.getContinuousAngle() + 180;
		controller.start(target - Robot.sensors.getContinuousAngle());
	}
	@Override
	public void execute(){
		double speed = controller.update(Robot.sensors.getContinuousAngle() - target);
		SmartDashboard.putNumber("Turn Command", speed);
		Robot.drive.move(speed, -speed);//Positive error (right turn) means left goes forward, right goes back
	}
	@Override
	public boolean isFinished(){
		return 
//				Math.abs(Sensors.constrainAngle(target - Robot.sensors.getAngle())) <= DEADBAND || 
				!Robot.oi.getSallyPort();
	}
	@Override
	public void end(){
		Robot.drive.move(0, 0);
	}
	@Override
	public void interrupted(){
		Robot.drive.move(0, 0);
	}
}
