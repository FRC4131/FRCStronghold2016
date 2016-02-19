package org.usfirst.frc.team4131.robot;

import org.usfirst.frc.team4131.robot.commands.CollectBoulder;
import org.usfirst.frc.team4131.robot.commands.LoadBoulder;
import org.usfirst.frc.team4131.robot.commands.UnloadBoulder;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Joystick leftStick;
	private Joystick rightStick;
	private Joystick launchpad;
	
	private Button collectBoulder;
	private Button loadBoulder;
	private Button unloadBoulder;
	private Button stowArms;
	private Button deployArms;
	
	public OI(){
		leftStick = new Joystick(RobotMap.LEFT_JOYSTICK);
		rightStick = new Joystick(RobotMap.RIGHT_JOYSTICK);
		launchpad = new Joystick(RobotMap.LAUNCHPAD);
		
		loadBoulder = new JoystickButton(rightStick, RobotMap.LOAD);
		loadBoulder.whenPressed(new LoadBoulder());
		
		unloadBoulder = new JoystickButton(launchpad, RobotMap.UNLOAD);
		unloadBoulder.whenPressed(new UnloadBoulder());
		
		collectBoulder = new JoystickButton(launchpad, RobotMap.COLLECT_BOULDER);
		collectBoulder.whenPressed(new CollectBoulder());
		
		stowArms= new JoystickButton(launchpad, RobotMap.STOW_ARMS);
//		stowArms.whenPressed(new StowArms());
		
		deployArms = new JoystickButton(launchpad, RobotMap.DEPLOY_ARMS);
//		deployArms.whenPressed(new DeployArms());
	}
	public double getLeftSpeed() {
		return leftStick.getRawAxis(0);
	}
	public double getRightSpeed() {
		return rightStick.getRawAxis(0);
	}
}

