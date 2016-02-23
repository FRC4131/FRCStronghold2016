
package org.usfirst.frc.team4131.robot;

import org.usfirst.frc.team4131.robot.commands.AutonLowBarLowGoal;
import org.usfirst.frc.team4131.robot.commands.AutonLowBarShoot;
import org.usfirst.frc.team4131.robot.commands.AutonThruPortcullis;
import org.usfirst.frc.team4131.robot.commands.DriveStraight;
import org.usfirst.frc.team4131.robot.commands.Turn;
import org.usfirst.frc.team4131.robot.subsystems.Arms;
import org.usfirst.frc.team4131.robot.subsystems.Collector;
import org.usfirst.frc.team4131.robot.subsystems.Handler;
import org.usfirst.frc.team4131.robot.subsystems.LightRing;
import org.usfirst.frc.team4131.robot.subsystems.Shooter;
import org.usfirst.frc.team4131.robot.subsystems.TankDrive;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
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

	public static OI oi;
	public static TankDrive drive;
	public static Handler handler;
	public static Shooter shooter;
	public static Collector collector;
	public static Arms arms;
	public static LightRing lightRing;

	private SendableChooser chooser;
	private Command autonomous;

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
		lightRing = new LightRing();
		
		chooser = new SendableChooser();
		chooser.addDefault("AutonDriveStraight", new DriveStraight(70, 0, 0.5));
		chooser.addObject("AutonLowBarShoot", new AutonLowBarShoot());
		chooser.addObject("AutonThruPortcullis", new AutonThruPortcullis());
		chooser.addObject("AutonLowBarLowGoal", new AutonLowBarLowGoal());
		chooser.addObject("Turn", new Turn(48));
		SmartDashboard.putData("Autonomous", chooser);
		
		oi = new OI();
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
    	drive.resetEncoders();
		drive.resetGyro();
		
		autonomous = (Command) chooser.getSelected();
		if (autonomous != null) autonomous.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Angle", Robot.drive.getAngle());
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomous != null) autonomous.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Arms Angle", Robot.arms.getAngle());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    public static double constrain(double value, double min, double max)
    {
    	return Math.min(Math.max(value, min), max);
    }
}
