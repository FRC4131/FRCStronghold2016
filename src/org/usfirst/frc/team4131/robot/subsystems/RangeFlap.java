package org.usfirst.frc.team4131.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RangeFlap extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	private boolean isUp;
	private Relay relay;

	public RangeFlap() {
		isUp = false;
		relay = new Relay(0);
	}

	public void initDefaultCommand() {
	}

	public void toggle() {
		if (isUp) {
			isUp = false;
			relay.set(Relay.Value.kReverse);
		} else {
			isUp = true;
			relay.set(Relay.Value.kForward);
		}
	}
	public Relay.Value get(){
		return relay.get();
	}
}
