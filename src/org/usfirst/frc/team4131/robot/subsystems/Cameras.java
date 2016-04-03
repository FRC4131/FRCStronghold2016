package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;

/**
 *
 */
public class Cameras {
	private Image frame;
	private int sessionFront, sessionBack, currentSession;
	public Cameras() {
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		sessionFront = NIVision.IMAQdxOpenCamera(RobotMap.FRONT_CAMERA,
				NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		NIVision.IMAQdxConfigureGrab(sessionFront);
		currentSession = sessionFront;
	}
	public void toggle(){
		if(currentSession == sessionFront){
			sessionBack = NIVision.IMAQdxOpenCamera(RobotMap.BACK_CAMERA,
					NIVision.IMAQdxCameraControlMode.CameraControlModeController);
			NIVision.IMAQdxConfigureGrab(sessionBack);
			currentSession = sessionBack;
		}else{
			sessionFront = NIVision.IMAQdxOpenCamera(RobotMap.FRONT_CAMERA,
					NIVision.IMAQdxCameraControlMode.CameraControlModeController);
			NIVision.IMAQdxConfigureGrab(sessionFront);
			currentSession = sessionFront;
		}
	}
	public String currentCamera(){
		if(sessionFront == currentSession){
			return RobotMap.FRONT_CAMERA;
		}else{
			return RobotMap.BACK_CAMERA;
		}
	}
	public void execute() {
		NIVision.IMAQdxGrab(currentSession, frame, 1);
		CameraServer.getInstance().setImage(frame);
	}
	
	public void initDefaultCommand(){
	}
}
