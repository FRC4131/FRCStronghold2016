package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Handler extends Subsystem {
	
	private SpeedController motor;
	private Timer timer;
	
	public Handler()
	{
		motor = new CANTalon(RobotMap.HANDLER_MOTOR);
		timer = new Timer();
	}
	
	public void spin(double speed)
	{
		motor.set(speed);
	}

    public void initDefaultCommand() {
    }
}

