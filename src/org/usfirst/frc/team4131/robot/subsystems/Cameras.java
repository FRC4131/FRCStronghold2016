//package org.usfirst.frc.team4131.robot.subsystems;
//
//import org.usfirst.frc.team4131.robot.RobotMap;
//
//import com.ni.vision.NIVision;
//import com.ni.vision.NIVision.Image;
//
//import edu.wpi.first.wpilibj.CameraServer;
//
///**
// *
// */
//public class Cameras {
//	private Image frame;
//	private boolean sessionSet = false;
//	private int sessionFront;
//	private int sessionBack, currentSession;
//	private CameraServer server;
//	public Cameras() {
//		server = CameraServer.getInstance();
//		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
//		sessionFront = NIVision.IMAQdxOpenCamera(RobotMap.FRONT_CAMERA,
//				NIVision.IMAQdxCameraControlMode.CameraControlModeController);
//		NIVision.IMAQdxConfigureGrab(sessionFront);
//		currentSession = sessionFront;
//		sessionSet = true;
//	}
//	public void toggle(){
//		if(currentSession == sessionFront){
//			sessionBack = NIVision.IMAQdxOpenCamera(RobotMap.BACK_CAMERA,
//					NIVision.IMAQdxCameraControlMode.CameraControlModeController);
//			NIVision.IMAQdxConfigureGrab(sessionBack);
//			currentSession = sessionBack;
//		}else{
//			sessionFront = NIVision.IMAQdxOpenCamera(RobotMap.FRONT_CAMERA,
//					NIVision.IMAQdxCameraControlMode.CameraControlModeController);
//			NIVision.IMAQdxConfigureGrab(sessionFront);
//			currentSession = sessionFront;
//		}
//	}
//	public String currentCamera(){
//		if(sessionFront == currentSession){
//			return RobotMap.FRONT_CAMERA;
//		}else{
//			return RobotMap.BACK_CAMERA;
//		}
//	}
//	public void execute() {
//		if (sessionSet){	
//			NIVision.IMAQdxGrab(currentSession, frame, 1);
//			server.setImage(frame);
//			server.setQuality(70);		
//		}
//	}
//	
//	public void initDefaultCommand(){
//	}
//}
package org.usfirst.frc.team4131.robot.subsystems;

import org.usfirst.frc.team4131.robot.RobotMap;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.IMAQdxCameraControlMode;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;

/**
 *
 */
public class Cameras {
	private Image frame;
	private String cam = "cam";
	private int cam1 = 0;
	private int cam2 = 0;
	private boolean sessionSet = false;
	private int sessionFront;
	private int sessionBack, currentSession;
	private CameraServer server;
	public Cameras() {
		server = CameraServer.getInstance();
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		sessionFront = NIVision.IMAQdxOpenCamera(RobotMap.FRONT_CAMERA,
				NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		NIVision.IMAQdxConfigureGrab(sessionFront);
		currentSession = sessionFront;
		sessionSet = true;
		
	}
	public void helper(){
	}
	public void toggle(){
		if(currentSession == sessionBack){
			NIVision.IMAQdxStopAcquisition(sessionBack);
			NIVision.IMAQdxCloseCamera(sessionBack);
			sessionFront = NIVision.IMAQdxOpenCamera(RobotMap.FRONT_CAMERA, IMAQdxCameraControlMode.CameraControlModeController);
			NIVision.IMAQdxConfigureGrab(sessionFront);
			NIVision.IMAQdxStartAcquisition(sessionFront);
			currentSession = sessionFront;	
		}else if(currentSession == sessionFront){
			NIVision.IMAQdxStopAcquisition(sessionFront);
			NIVision.IMAQdxCloseCamera(sessionFront);
			sessionBack = NIVision.IMAQdxOpenCamera(RobotMap.BACK_CAMERA, IMAQdxCameraControlMode.CameraControlModeController);
			NIVision.IMAQdxConfigureGrab(sessionBack);
			NIVision.IMAQdxStartAcquisition(sessionBack);
			currentSession = sessionBack;
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
		if (sessionSet){	
			NIVision.IMAQdxGrab(currentSession, frame, 1);
			server.setImage(frame);
			server.setQuality(70);		
		}
	}
	
	public void initDefaultCommand(){
	}
}

