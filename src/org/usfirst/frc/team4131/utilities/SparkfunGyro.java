package org.usfirst.frc.team4131.utilities;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SparkfunGyro {
	
	//Addresses
	private static final int MAG_ADDR = 0x1E;
	private static final int AG_ADDR = 0x6B;
	
	//AG Registers
	private static final int ACT_THS =			0x04;
	private static final int ACT_DUR =			0x05;
	private static final int INT_GEN_CFG_XL =	0x06;
	private static final int INT_GEN_THS_X_XL =	0x07;
	private static final int INT_GEN_THS_Y_XL =	0x08;
	private static final int INT_GEN_THS_Z_XL =	0x09;
	private static final int INT_GEN_DUR_XL =	0x0A;
	private static final int REFERENCE_G =		0x0B;
	private static final int INT1_CTRL =		0x0C;
	private static final int INT2_CTRL =		0x0D;
	private static final int WHO_AM_I_XG =		0x0F;
	private static final int CTRL_REG1_G =		0x10;
	private static final int CTRL_REG2_G =		0x11;
	private static final int CTRL_REG3_G =		0x12;
	private static final int ORIENT_CFG_G =		0x13;
	private static final int INT_GEN_SRC_G =	0x14;
	private static final int OUT_TEMP_L =		0x15;
	private static final int OUT_TEMP_H =		0x16;
	private static final int STATUS_REG_0 =		0x17;
	private static final int OUT_X_L_G =		0x18;
	private static final int OUT_X_H_G =		0x19;
	private static final int OUT_Y_L_G =		0x1A;
	private static final int OUT_Y_H_G =		0x1B;
	private static final int OUT_Z_L_G =		0x1C;
	private static final int OUT_Z_H_G =		0x1D;
	private static final int CTRL_REG4 =		0x1E;
	private static final int CTRL_REG5_XL =		0x1F;
	private static final int CTRL_REG6_XL =		0x20;
	private static final int CTRL_REG7_XL =		0x21;
	private static final int CTRL_REG8 =		0x22;
	private static final int CTRL_REG9 =		0x23;
	private static final int CTRL_REG10 =		0x24;
	private static final int INT_GEN_SRC_XL =	0x26;
	private static final int STATUS_REG_1 =		0x27;
	private static final int OUT_X_L_XL =		0x28;
	private static final int OUT_X_H_XL =		0x29;
	private static final int OUT_Y_L_XL =		0x2A;
	private static final int OUT_Y_H_XL =		0x2B;
	private static final int OUT_Z_L_XL =		0x2C;
	private static final int OUT_Z_H_XL =		0x2D;
	private static final int FIFO_CTRL =		0x2E;
	private static final int FIFO_SRC =			0x2F;
	private static final int INT_GEN_CFG_G =	0x30;
	private static final int INT_GEN_THS_XH_G =	0x31;
	private static final int INT_GEN_THS_XL_G =	0x32;
	private static final int INT_GEN_THS_YH_G =	0x33;
	private static final int INT_GEN_THS_YL_G =	0x34;
	private static final int INT_GEN_THS_ZH_G = 0x35;
	private static final int INT_GEN_THS_ZL_G =	0x36;
	private static final int INT_GEN_DUR_G =	0x37;
	
	//Magneto Registers
	private static final int OFFSET_X_REG_L_M =	0x05;
	private static final int OFFSET_X_REG_H_M =	0x06;
	private static final int OFFSET_Y_REG_L_M =	0x07;
	private static final int OFFSET_Y_REG_H_M =	0x08;
	private static final int OFFSET_Z_REG_L_M =	0x09;
	private static final int OFFSET_Z_REG_H_M =	0x0A;
	private static final int WHO_AM_I_M =		0x0F;
	private static final int CTRL_REG1_M =		0x20;
	private static final int CTRL_REG2_M =		0x21;
	private static final int CTRL_REG3_M =		0x22;
	private static final int CTRL_REG4_M =		0x23;
	private static final int CTRL_REG5_M =		0x24;
	private static final int STATUS_REG_M =		0x27;
	private static final int OUT_X_L_M =		0x28;
	private static final int OUT_X_H_M =		0x29;
	private static final int OUT_Y_L_M =		0x2A;
	private static final int OUT_Y_H_M =		0x2B;
	private static final int OUT_Z_L_M =		0x2C;
	private static final int OUT_Z_H_M =		0x2D;
	private static final int INT_CFG_M =		0x30;
	private static final int INT_SRC_M =		0x30;
	private static final int INT_THS_L_M =		0x32;
	private static final int INT_THS_H_M =		0x33;
	
	private static final int WHO_AM_I_AG_RSP =	0x68;
	private static final int WHO_AM_I_M_RSP =	0x3D;
	
	private I2C mag;
	
	public SparkfunGyro()
	{
	}
	
	private initGyro()
	{
		
	}
}
