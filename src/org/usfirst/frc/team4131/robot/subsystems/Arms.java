package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arms extends Subsystem {
	
	private CANTalon arms;
	private Encoder encoder;
	
	public Arms(){
		arms = new CANTalon(RobotMap.armsMotor);
		encoder = new Encoder(RobotMap.armsEncoderA, RobotMap.armsEncoderB);
	}
	public void move(double speed){
		arms.set(speed);
	}
	public void resetEncoder(){
		encoder.reset();
	}
	/**
	 * Returns the number of pulses found in the encoder.
	 * @return
	 */
	public double getAngle(){
		//TODO See the number of pulses per rev for the encoder here
		return encoder.get();
	}
	public void initDefaultCommand() {
		
	}
}

