
package org.usfirst.frc.team4131.robot;

<<<<<<< HEAD
import org.usfirst.frc.team4131.robot.commands.AutonLowBarLowGoal;
import org.usfirst.frc.team4131.robot.commands.AutonLowBarShoot;
import org.usfirst.frc.team4131.robot.commands.AutonThruPortcullis;
import org.usfirst.frc.team4131.robot.commands.DriveStraight;
import org.usfirst.frc.team4131.robot.commands.Turn;
=======
import org.usfirst.frc.team4131.robot.commands.GridAutoDrive;
>>>>>>> ae33c2374cffd8d44fa4563a80a939346fb72bb9
import org.usfirst.frc.team4131.robot.subsystems.Arms;
import org.usfirst.frc.team4131.robot.subsystems.Collector;
import org.usfirst.frc.team4131.robot.subsystems.Handler;
import org.usfirst.frc.team4131.robot.subsystems.LightRing;
import org.usfirst.frc.team4131.robot.subsystems.Shooter;
import org.usfirst.frc.team4131.robot.subsystems.TankDrive;
import org.usfirst.frc.team4131.utilities.Point;

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
	public static double CURRENT_X;
	public static double CURRENT_Y;
	public static double CURRENT_ANGLE;

	public static OI oi;
	public static TankDrive drive;
	public static Handler handler;
	public static Shooter shooter;
	public static Collector collector;
	public static Arms arms;
	public static LightRing lightRing;

    Command autonomousCommand, gridDrive;

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
		
		gridDrive = new GridAutoDrive(new Point(0, 100));
		
		oi = new OI();
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){
<<<<<<< HEAD
=======
    	gridDrive.cancel();
>>>>>>> ae33c2374cffd8d44fa4563a80a939346fb72bb9
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
    	CURRENT_X = 0;//TODO whatever our starting position is based on
    	CURRENT_Y = 0;//TODO whatever our starting position is based on
//    	autonomousCommand = new DriveBackAndForth();
//        if (autonomousCommand != null) autonomousCommand.start();
    	gridDrive.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        CURRENT_ANGLE = drive.getAngle();
        SmartDashboard.putNumber("Distance Travled", drive.getDistance());
        SmartDashboard.putNumber("Angle: ", CURRENT_ANGLE);
        SmartDashboard.putNumber("Current x: ", CURRENT_X);
        SmartDashboard.putNumber("Current y:", CURRENT_Y);
    }
    public void updateDeltaMovement(double x, double y){
    	CURRENT_X += x;
    	CURRENT_Y += y;
    }
    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    	
    	gridDrive.cancel();
        if (autonomousCommand != null) autonomousCommand.cancel();
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
