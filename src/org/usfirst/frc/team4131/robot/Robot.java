
package org.usfirst.frc.team4131.robot;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.usfirst.frc.team4131.robot.commands.AutonLowBarShoot;
import org.usfirst.frc.team4131.robot.commands.DriveStraight;
import org.usfirst.frc.team4131.robot.subsystems.Arms;
import org.usfirst.frc.team4131.robot.subsystems.Collector;
import org.usfirst.frc.team4131.robot.subsystems.Handler;
import org.usfirst.frc.team4131.robot.subsystems.RangeFlap;
import org.usfirst.frc.team4131.robot.subsystems.Shooter;
import org.usfirst.frc.team4131.robot.subsystems.TankDrive;

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
	public static double CURRENT_X;
	public static double CURRENT_Y;
	public static double CURRENT_ANGLE;

	public static TankDrive drive;
	public static Handler handler;
	public static Shooter shooter;
	public static Collector collector;
	public static Arms arms;
	public static OI oi;
//	public static LightRing lightRing;
//	public static AimingFlashlight aimingFlashlight;
	public static RangeFlap rangeFlap;

	private SendableChooser chooser;
	private Command autonomous;
	
	private static final String TEST_BOT = "TestBot";
	private static String whoami;
	private static final String CONFIG_FILENAME = "WHOAMI.TXT";
	

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		drive = new TankDrive();
		handler = new Handler();
		shooter = new Shooter();
		collector = new Collector();
		arms = new Arms();
//		aimingFlashlight = new AimingFlashlight();
		rangeFlap = new RangeFlap();
		
		oi = new OI();
		chooser = new SendableChooser();
		chooser.addDefault("AutonLowBarShoot", new AutonLowBarShoot());
		chooser.addObject("DriveStraight", new DriveStraight(150, 0, 0.9));
		chooser.addObject("Nothing", new CommandGroup());
//		chooser.addObject("Grid", new GridAutoDrive(new Point(0, 24), new Point(-24, 24), new Point(-24, 0), new Point(0,0)));
//		chooser.addObject("AutonLowBarShoot", new AutonLowBarShoot());
//		chooser.addObject("PortcullisStraight", new AutonThruPortcullis());
//		chooser.addObject("Turn", new Turn(30));
//		chooser.addObject("VisionAssistAim", new VisionAssistAim());
		SmartDashboard.putData("Autonomous", chooser);

//		try {
//			FileWriter file = new FileWriter(CONFIG_FILENAME);
//			file.append(TEST_BOT);
//			file.close();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
		byte[] buffer = null;
		Path configPath = FileSystems.getDefault().getPath(CONFIG_FILENAME);
		try {
			buffer = Files.readAllBytes(configPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		whoami = new String(buffer);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	public void disabledInit() {
//		gridDrive.cancel();
		SmartDashboard.putBoolean("File is placed", isTestBot());
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
//		dashboard();
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
//		drive.resetEncoders();
//		CURRENT_ANGLE = drive.getAngle();
//		CURRENT_X = 0;// TODO whatever our starting position is based on
//		CURRENT_Y = 0;// TODO whatever our starting position is based on
//		// autonomousCommand = new DriveBackAndForth();
//		// if (autonomousCommand != null) autonomousCommand.start();
		autonomous = (Command) chooser.getSelected();
		if (autonomous != null) autonomous.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
//		CURRENT_ANGLE = drive.getAngle();
//		dashboard();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomous != null)
			autonomous.cancel();// End autonomous when teleop starts
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
//		dashboard();
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
	
	private void dashboard(){
		SmartDashboard.putNumber("Handler Speed", handler.getSpeed());
        SmartDashboard.putNumber("Arms Angle", arms.getAngle());
        SmartDashboard.putNumber("Snooter Speed", shooter.getRate());
        SmartDashboard.putBoolean("Ball Captured", handler.isCaptured());
        SmartDashboard.putNumber("Drive Distance", drive.getDistance());
        SmartDashboard.putBoolean("Arms Stowed", arms.isStowed());
        SmartDashboard.putNumber("Gyro Angle", drive.getAngle());
        SmartDashboard.putNumber("Arm Speed", arms.getSpeed());
//        SmartDashboard.putBoolean("Headlight On", lightRing.isOn());
        SmartDashboard.putString("Flap State", rangeFlap.get().name());
		SmartDashboard.putNumber("Robot Angle", CURRENT_ANGLE);
		SmartDashboard.putNumber("Robot X", CURRENT_X);
		SmartDashboard.putNumber("Robot Y", CURRENT_Y);
		SmartDashboard.putNumber("Collector Speed", collector.get());
	}
	
	public static boolean isTestBot()
	{
		return whoami.equals(TEST_BOT);
	}
}
