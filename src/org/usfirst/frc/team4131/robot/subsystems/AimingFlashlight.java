package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AimingFlashlight extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	private SpeedController light;
	private boolean isOn = false;

	private static final double LIGHT_POWER = 0.25;

	public AimingFlashlight() {
		light = new CANTalon(RobotMap.FLASHLIGHT_CONTROLLER);
	}

	public void initDefaultCommand() {
	}

	public void toggle() {
		if (isOn) {
			isOn = false;
			light.set(0);
		} else {
			isOn = true;
			light.set(LIGHT_POWER);
		}
	}
}
