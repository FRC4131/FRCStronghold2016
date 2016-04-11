package org.usfirst.frc.team4131.utilities;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.PIDOutput;

public class ShooterControlOutput implements PIDOutput{

	public ShooterControlOutput(){
		
	}
	@Override
	public void pidWrite(double output) {
		Robot.shooter.getMotor().pidWrite(output);
	}

}
