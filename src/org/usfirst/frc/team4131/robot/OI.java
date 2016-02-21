package org.usfirst.frc.team4131.robot;

import org.usfirst.frc.team4131.robot.commands.CollectBoulder;
import org.usfirst.frc.team4131.robot.commands.DeployArms;
import org.usfirst.frc.team4131.robot.commands.EmergencyStop;
import org.usfirst.frc.team4131.robot.commands.LoadBoulder;
import org.usfirst.frc.team4131.robot.commands.StowArms;
import org.usfirst.frc.team4131.robot.commands.ThruPortcullis;
import org.usfirst.frc.team4131.robot.commands.ToggleLight;
import org.usfirst.frc.team4131.robot.commands.UnloadBoulder;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private boolean emergencyState = false;
	private Joystick leftStick;
	private Joystick rightStick;
	private Joystick launchpad;
	
	private Button collectBoulder;
	private Button loadBoulder;
	private Button unloadBoulder;
	private Button stowArms;
	private Button emergencyStop;
	private Button deployArms;
	private Button portcullis;
	private Button toggleLight;
	
	private Command collectCommand = new CollectBoulder();
	
	public OI(){
		leftStick = new Joystick(RobotMap.LEFT_JOYSTICK);
		rightStick = new Joystick(RobotMap.RIGHT_JOYSTICK);
		launchpad = new Joystick(RobotMap.LAUNCHPAD);
		
		loadBoulder = new JoystickButton(rightStick, RobotMap.LOAD);
		loadBoulder.whenPressed(new LoadBoulder());
		
		unloadBoulder = new JoystickButton(launchpad, RobotMap.UNLOAD);
		unloadBoulder.whileHeld(new UnloadBoulder());
		
		collectBoulder = new JoystickButton(launchpad, RobotMap.COLLECT_BOULDER);
		collectBoulder.whenPressed(collectCommand);
		collectBoulder.whenPressed(new DeployArms(750));
		
		emergencyStop = new JoystickButton(launchpad, RobotMap.EMERGENCY_STOP);
		emergencyStop.whenPressed(new EmergencyStop(emergencyState = !emergencyState));
		
		portcullis = new JoystickButton(launchpad, RobotMap.PORTCULLIS);
		portcullis.whenPressed(new ThruPortcullis());
		
		stowArms = new JoystickButton(launchpad, RobotMap.STOW_ARMS);
		stowArms.whenPressed(new StowArms());
		
		deployArms = new JoystickButton(launchpad, RobotMap.DEPLOY_ARMS);
		deployArms.whenPressed(new DeployArms(850)); //Magic number!
		
		toggleLight = new JoystickButton(leftStick, RobotMap.TOGGLE_LIGHT);
		toggleLight.whenPressed(new ToggleLight());
	}
	public double getLeftSpeed() {
		return -leftStick.getRawAxis(1);
	}
	public double getRightSpeed() {
		return -rightStick.getRawAxis(1);
	}
	public boolean getSpitOut(){
		return unloadBoulder.get();
	}
}

