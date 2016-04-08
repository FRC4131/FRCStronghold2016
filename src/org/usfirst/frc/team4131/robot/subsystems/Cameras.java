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
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;

/**
 *
 */
public class Cameras {
	private Image frame;
	private String cam = "cam";
	private int test = 0;
	private boolean sessionSet = false;
	private int sessionFront;
	private int sessionBack, currentSession;
	private CameraServer server;
	public Cameras() {
		boolean pass = false;
		for( ; test <= 6 && !pass; ++test){
			try{
				helper();
				pass = true;
			}catch(Exception e){
			}
		}
	}
	public void helper(){
		server = CameraServer.getInstance();
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		sessionFront = NIVision.IMAQdxOpenCamera((cam + test),
				NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		NIVision.IMAQdxConfigureGrab(sessionFront);
		currentSession = sessionFront;
		sessionSet = true;
	}
	public void toggle(){
		if(currentSession == sessionFront){
			sessionBack = NIVision.IMAQdxOpenCamera((cam + (test + 1)),
					NIVision.IMAQdxCameraControlMode.CameraControlModeController);
			NIVision.IMAQdxConfigureGrab(sessionBack);
			currentSession = sessionBack;
		}else{
			sessionFront = NIVision.IMAQdxOpenCamera((cam + test),
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
		if (sessionSet){	
			NIVision.IMAQdxGrab(currentSession, frame, 1);
			server.setImage(frame);
			server.setQuality(70);		
		}
	}
	
	public void initDefaultCommand(){
	}
}

