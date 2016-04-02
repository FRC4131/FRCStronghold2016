package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AimingFlashlight extends Subsystem {
	private Relay light;
	private boolean isOn = false;

	public AimingFlashlight() {
		light = new Relay(RobotMap.FLASHLIGHT_CONTROLLER);
	}

	public void initDefaultCommand() {
	}

	public void toggle() {
		if (isOn) {
			isOn = false;
			light.set(Value.kOff);
		} else {
			isOn = true;
			light.set(Value.kForward);
		}
	}
	public boolean get(){
		return !light.get().equals(Value.kOff);
	}
}
