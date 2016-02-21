package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LightRing extends Subsystem {
	
	private Relay relay;
	private boolean isOn;
	
	public LightRing()
	{
		relay = new Relay(0, Relay.Direction.kBoth);
		SmartDashboard.putBoolean("Light Command", isOn);
	}
	
    public void initDefaultCommand() {
    }
    
    public void toggle()
    {
    	if (isOn)
    	{
    		relay.set(Relay.Value.kOff);
    		isOn = false;
    	}
    	else
    	{
    		relay.set(Relay.Value.kReverse);
    		isOn = true;
    	}
    	
    	SmartDashboard.putBoolean("Light Command", isOn);
    }
}

