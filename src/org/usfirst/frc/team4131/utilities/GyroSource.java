package org.usfirst.frc.team4131.utilities;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class GyroSource implements PIDSource {
	private double targetAngle = 0;

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {

	}

	@Override
	public PIDSourceType getPIDSourceType() {
		// TODO Auto-generated method stub
		return PIDSourceType.kDisplacement;
	}

	@Override
	public double pidGet() {
		return (targetAngle - Robot.sensors.getContinuousAngle());
	}

	public void setTargetAngle(double angle) {
		targetAngle = angle;
	}

}
