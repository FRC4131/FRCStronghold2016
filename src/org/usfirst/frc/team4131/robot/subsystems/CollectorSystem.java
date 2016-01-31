package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CollectorSystem extends Subsystem {
	
	private CANTalon belt, roller;
	
	public CollectorSystem(){
		super();
		belt = new CANTalon(RobotMap.beltMotor);
		roller = new CANTalon(RobotMap.rollingPinMotor);
	}
	public void spin(double speed){
		belt.set(speed);
		roller.set(speed);
	}
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
	}
}

