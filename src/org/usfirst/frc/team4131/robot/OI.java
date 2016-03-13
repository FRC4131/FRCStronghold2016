package org.usfirst.frc.team4131.robot;

import org.usfirst.frc.team4131.robot.commands.AutonThruPortcullis;
import org.usfirst.frc.team4131.robot.commands.BlastForward;
import org.usfirst.frc.team4131.robot.commands.CollectBoulder;
import org.usfirst.frc.team4131.robot.commands.DeployArms;
import org.usfirst.frc.team4131.robot.commands.EmergencyStop;
import org.usfirst.frc.team4131.robot.commands.LittleMove;
import org.usfirst.frc.team4131.robot.commands.LoadBoulder;
import org.usfirst.frc.team4131.robot.commands.StowArms;
import org.usfirst.frc.team4131.robot.commands.ToggleDirection;
import org.usfirst.frc.team4131.robot.commands.ToggleRangeFlap;
import org.usfirst.frc.team4131.robot.commands.UnloadBoulder;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

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
	private Button inverseDrive;
	//	private Button toggleLight;
	public Button blastForward;

	private Button rangeFlap;

	public POVTrigger POV;

	public OI() {
		leftStick = new Joystick(RobotMap.LEFT_JOYSTICK);
		rightStick = new Joystick(RobotMap.RIGHT_JOYSTICK);

		POV = new POVTrigger(rightStick);
		POV.whenActive(new LittleMove(POV.getLittleSpeed()));

		blastForward = new JoystickButton(leftStick, RobotMap.BLAST_FORWARD);
		blastForward.whenPressed(new BlastForward());

		launchpad = new Joystick(RobotMap.LAUNCHPAD);

		loadBoulder = new JoystickButton(rightStick, RobotMap.LOAD);
		loadBoulder.whenPressed(new LoadBoulder());

		unloadBoulder = new JoystickButton(launchpad, RobotMap.UNLOAD);
		unloadBoulder.whileHeld(new UnloadBoulder());

		collectBoulder = new JoystickButton(launchpad, RobotMap.COLLECT_BOULDER);
		collectBoulder.whenPressed(new CollectBoulder());
		//DeployArms removed so we can collect without deploying (e.g. in a corner)

		emergencyStop = new JoystickButton(launchpad, RobotMap.EMERGENCY_STOP);
		emergencyStop.whenPressed(new EmergencyStop(emergencyState = !emergencyState));

		portcullis = new JoystickButton(launchpad, RobotMap.PORTCULLIS);
		portcullis.whenPressed(new AutonThruPortcullis());

		stowArms = new JoystickButton(launchpad, RobotMap.STOW_ARMS);
		stowArms.whenPressed(new StowArms());

		deployArms = new JoystickButton(launchpad, RobotMap.DEPLOY_ARMS);
		deployArms.whenPressed(new DeployArms(-800)); //Ma-gic ma-gic ooh-ooh! Ma-gic ma-gic ooh-ooh! Ma-gic ma-gic ma-gic ma-gic ... ooh-ooh!

		inverseDrive = new JoystickButton(rightStick, RobotMap.INVERSE);
		inverseDrive.whenPressed(new ToggleDirection());

		rangeFlap = new JoystickButton(leftStick, RobotMap.RANGE_FLAP_BUTTON);
		rangeFlap.whenPressed(new ToggleRangeFlap());
	}

	public double getLeftSpeed() {
		return Math.pow(leftStick.getRawAxis(1), 3) * (ToggleDirection.isForward() ? -1 : 1);
	}

	public double getRightSpeed() {
		return Math.pow(rightStick.getRawAxis(1), 3) * (ToggleDirection.isForward() ? -1 : 1);
	}

	public boolean getSpitOut() {
		return unloadBoulder.get();
	}

	public class POVTrigger extends Trigger {
		private final Joystick joystick;

		public POVTrigger(Joystick joystick) {
			this.joystick = joystick;
		}

		public boolean get() {
			return joystick.getPOV() != -1;
		}

		public int getLittleSpeed() {
			switch (joystick.getPOV()) {
			case (0):
				return 0;
			case (2):
				return 2;
			case (4):
				return 4;
			case (6):
				return 6;
			default:
				return -1;
			}
		}
	}
}
