package org.usfirst.frc.team4131.utilities;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class ShooterSource implements PIDSource{
	private PIDSourceType type = PIDSourceType.kRate;
	private final double target;
	public ShooterSource(double target) {
		this.target = target;
	}

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		type = pidSource;
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		return type;
	}

	@Override
	public double pidGet() {
		return target - Robot.shooter.getRate();
	}

}
