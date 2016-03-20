package org.usfirst.frc.team4131.robot;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.usfirst.frc.team4131.robot.commands.AutonLowBarLowGoal;
import org.usfirst.frc.team4131.robot.commands.AutonLowBarShoot;
import org.usfirst.frc.team4131.robot.commands.AutonThruPortcullis;
import org.usfirst.frc.team4131.robot.commands.DriveStraight;
import org.usfirst.frc.team4131.robot.commands.GridAutoDrive;
import org.usfirst.frc.team4131.robot.commands.VisionAssistAim;
import org.usfirst.frc.team4131.robot.subsystems.Arms;
import org.usfirst.frc.team4131.robot.subsystems.Collector;
import org.usfirst.frc.team4131.robot.subsystems.Handler;
import org.usfirst.frc.team4131.robot.subsystems.RangeFlap;
import org.usfirst.frc.team4131.robot.subsystems.Sensors;
import org.usfirst.frc.team4131.robot.subsystems.Shooter;
import org.usfirst.frc.team4131.robot.subsystems.TankDrive;
import org.usfirst.frc.team4131.utilities.Point;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	private final boolean ELECTRICAL_BOT;

	public static double CURRENT_X;
	public static double CURRENT_Y;
	public static double CURRENT_ANGLE;

	public static Sensors sensors;
	public static TankDrive drive;
	public static Handler handler;
	public static Shooter shooter;
	public static Collector collector;
	public static Arms arms;
	public static OI oi;
	// public static LightRing lightRing;
	// public static AimingFlashlight aimingFlashlight;
	public static RangeFlap rangeFlap;

	private SendableChooser chooser;
	private Command autonomous;

	public Robot() {
		super();
		String whoami = null;
		byte[] buffer = null;
		Path configPath = FileSystems.getDefault().getPath(RobotMap.CONFIG_FILENAME);
		try {
			buffer = Files.readAllBytes(configPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(buffer != null){
			whoami = new String(buffer);
			RobotMap.ROBOT_TYPE = RobotMap.robotType(whoami);
			RobotMap.ROBOT_TYPE = RobotMap.robotType(RobotMap.PRACTICE_BOT);
			ELECTRICAL_BOT = RobotMap.ROBOT_TYPE == RobotMap.ELECT_BOT_NUM;
		}else{
			ELECTRICAL_BOT = false;
		}
	}

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		if (ELECTRICAL_BOT) {
			// electricalBot Code
		} else {
			/**
			 * With current build, we only have old gyro. Call the default constructor once we have IMU done
			 */
			sensors = new Sensors();
			drive = new TankDrive();
			handler = new Handler();
			shooter = new Shooter();
			collector = new Collector();
			arms = new Arms();
			// aimingFlashlight = new AimingFlashlight();
			rangeFlap = new RangeFlap();

			oi = new OI();
			chooser = new SendableChooser();
			chooser.addDefault("AutonLowBarShoot", new AutonLowBarShoot());
			chooser.addObject("LowBarLowGoal", new AutonLowBarLowGoal());
			chooser.addObject("DriveStraight", new DriveStraight(150, 0, 0.9));
			chooser.addObject("Nothing", new CommandGroup());
			chooser.addObject("Grid", new GridAutoDrive(new Point(0, 24), new Point(-24, 24), new Point(-24, 0), new Point(0, 0)));
			chooser.addObject("PortcullisStraight", new AutonThruPortcullis());
			chooser.addObject("VisionAssistAim", new VisionAssistAim());
			SmartDashboard.putData("Autonomous", chooser);
		}
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	public void disabledInit() {
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		dashboard();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	public void autonomousInit() {
		drive.resetEncoders();
		CURRENT_ANGLE = sensors.getAngle();
		CURRENT_X = 0;// TODO whatever our starting position is based on
		CURRENT_Y = 0;// TODO whatever our starting position is based on
		autonomous = (Command) chooser.getSelected();
		if (autonomous != null)
			autonomous.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		CURRENT_ANGLE = sensors.getAngle();
		dashboard();
	}

	public void teleopInit() {
		if (autonomous != null)
			autonomous.cancel();// End autonomous when teleop starts
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		dashboard();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}

	public static double constrain(double value, double min, double max) {
		return Math.min(Math.max(value, min), max);
	}

	private void dashboard() {
		if (ELECTRICAL_BOT) {
			// electricalBot Code
		} else {
			SmartDashboard.putNumber("Handler Speed", handler.getSpeed());
			SmartDashboard.putNumber("Arms Angle", arms.getAngle());
			SmartDashboard.putNumber("Snooter Speed", shooter.getRate());
			SmartDashboard.putBoolean("Ball Captured", handler.isCaptured());
			SmartDashboard.putNumber("Drive Distance", drive.getDistance());
			SmartDashboard.putBoolean("Arms Stowed", arms.isStowed());
//			SmartDashboard.putNumber("Gyro Angle", sensors.getAngle());
			SmartDashboard.putNumber("Arm Speed", arms.getSpeed());
			// SmartDashboard.putBoolean("Headlight On", lightRing.isOn());
			SmartDashboard.putString("Flap State", rangeFlap.get().name());
			SmartDashboard.putNumber("Robot Angle", CURRENT_ANGLE);
			SmartDashboard.putNumber("Robot X", CURRENT_X);
			SmartDashboard.putNumber("Robot Y", CURRENT_Y);
			SmartDashboard.putNumber("Collector Speed", collector.get());
		}
	}
}
