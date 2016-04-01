package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem {
	private Image frame;
	private int sessionFront;

	public Camera() {
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		sessionFront = NIVision.IMAQdxOpenCamera(RobotMap.CAMERA,
				NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		NIVision.IMAQdxConfigureGrab(sessionFront);
	}

	public void execute() {
		NIVision.IMAQdxGrab(sessionFront, frame, 1);
		CameraServer.getInstance().setImage(frame);
	}

	public void initDefaultCommand() {
	}
}
