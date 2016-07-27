package org.usfirst.frc.team4131.utilities;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class ShooterSource implements PIDSource {
	private PIDSourceType type = PIDSourceType.kRate;

	public ShooterSource() {
	}

	@Override
	public void setPIDSourceType(PIDSourceType type) {
		this.type = type;
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		return type;
	}

	@Override
	public double pidGet() {
		return Robot.shooter.getRate();
	}
}
