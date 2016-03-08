package org.usfirst.frc.team4131.robot;

import org.usfirst.frc.team4131.robot.commands.AutonThruPortcullis;
import org.usfirst.frc.team4131.robot.commands.ChargeShooter;
import org.usfirst.frc.team4131.robot.commands.CollectBoulder;
import org.usfirst.frc.team4131.robot.commands.DeployArms;
import org.usfirst.frc.team4131.robot.commands.EmergencyStop;
import org.usfirst.frc.team4131.robot.commands.LoadBoulder;
import org.usfirst.frc.team4131.robot.commands.StowArms;
import org.usfirst.frc.team4131.robot.commands.ToggleDirection;
import org.usfirst.frc.team4131.robot.commands.ToggleRangeFlap;
import org.usfirst.frc.team4131.robot.commands.UnloadBoulder;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

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
	private Button controlArms;
	private Button portcullis;
	private Button inverseDrive;
//	private Button toggleLight;
	private Button toggleLauncher;
	
	private Button rangeFlap;
	
	public OI(){
		leftStick = new Joystick(RobotMap.LEFT_JOYSTICK);
		rightStick = new Joystick(RobotMap.RIGHT_JOYSTICK);
		launchpad = new Joystick(RobotMap.LAUNCHPAD);
		
		loadBoulder = new JoystickButton(rightStick, RobotMap.LOAD);
		loadBoulder.whenPressed(new LoadBoulder());
		
		unloadBoulder = new JoystickButton(launchpad, RobotMap.UNLOAD);
		unloadBoulder.whileHeld(new UnloadBoulder());
		
		collectBoulder = new JoystickButton(launchpad, RobotMap.COLLECT_BOULDER);
		collectBoulder.whenPressed(new CollectBoulder());
//		collectBoulder.whenPressed(new DeployArms(-830)); //Disabled so we can collect without deploying (e.g. in a corner)
		
		emergencyStop = new JoystickButton(launchpad, RobotMap.EMERGENCY_STOP);
		emergencyStop.whenPressed(new EmergencyStop(emergencyState = !emergencyState));
		
//		portcullis = new JoystickButton(launchpad, RobotMap.PORTCULLIS);
//		portcullis.whenPressed(new AutonThruPortcullis());
		
		stowArms = new JoystickButton(launchpad, RobotMap.STOW_ARMS);
		stowArms.whenPressed(new StowArms());
		
		deployArms = new JoystickButton(launchpad, RobotMap.DEPLOY_ARMS);
		deployArms.whenPressed(new DeployArms(-800)); //Ma-gic ma-gic ooh-ooh! Ma-gic ma-gic ooh-ooh! Ma-gic ma-gic ma-gic ma-gic ... ooh-ooh!
		
//		toggleLight = new JoystickButton(leftStick, RobotMap.TOGGLE_LIGHT);
//		toggleLight.whenPressed(new ToggleLight());
		
		inverseDrive = new JoystickButton(rightStick, RobotMap.INVERSE);
		inverseDrive.whenPressed(new ToggleDirection());
		
		rangeFlap = new JoystickButton(leftStick, RobotMap.RANGE_FLAP_BUTTON);
		rangeFlap.whenPressed(new ToggleRangeFlap());
		
		toggleLauncher = new JoystickButton(leftStick, RobotMap.TOGGLE_LAUNCHER);
//		toggleLauncher.toggleWhenPressed(new ChargeShooter());
	}
	public double getLeftSpeed() {
		return Math.pow(leftStick.getRawAxis(1), 3) * (ToggleDirection.isForward() ? -1 : 1);
	}
	public double getRightSpeed() {
//		if (ToggleDirection.isForward())
//			return rightStick.getRawAxis(1)*-1;
//		else
//			return leftStick.getRawAxis(1);
		return Math.pow(rightStick.getRawAxis(1), 3) * (ToggleDirection.isForward() ? -1 : 1);
	}
	public boolean getSpitOut(){
		return unloadBoulder.get();
	}
}

