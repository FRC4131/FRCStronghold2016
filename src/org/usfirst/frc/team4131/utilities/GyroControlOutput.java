package org.usfirst.frc.team4131.utilities;

import org.usfirst.frc.team4131.robot.Robot;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GyroControlOutput implements PIDOutput{

	@Override
	public void pidWrite(double output) {
		SmartDashboard.putNumber("Command", output);
		Robot.drive.move(-output, output);
	}

}
