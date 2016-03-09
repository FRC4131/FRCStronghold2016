package org.usfirst.frc.team4131.utilities;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SparkfunGyro {
	
	private static final int MAG_ADDR = 0x1E;
	
	private I2C mag;
	
	public SparkfunGyro()
	{
		mag = new I2C(I2C.Port.kOnboard, MAG_ADDR);
		
		SmartDashboard.putBoolean("Mag Responding: ", mag.addressOnly());
	}
}
