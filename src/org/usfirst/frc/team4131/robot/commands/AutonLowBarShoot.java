package org.usfirst.frc.team4131.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonLowBarShoot extends CommandGroup {
	//	private static final double speed = 0.5, distance = 190, shotAngle = 60, shotDistance = 67;//Practice bot
	private static final double speed = 0.65, distance = 500, shotAngle = 46, shotDistance = 0;//Practice bot far shot
	//	private static final double speed = 0.5, distance = 190, shotAngle = 60, shotDistance = 103;//Competition bot
	//	private static final double speed = 0.5, distance = 190, shotAngle = 60, shotDistance = 94;

	public AutonLowBarShoot() {
		//addParallel(new SDLog("Auton Status", "Driving 1"));
		addSequential(new DriveStraight(distance, 0, speed));
		//addSequential(new SDLog("Auton Status", "Turning"));
		addSequential(new Turn(shotAngle));
		//addSequential(new ResetEncoders());
		//addSequential(new SDLog("Auton Status", "Driving 2"));
		addSequential(new DriveStraight(shotDistance, speed));
		//addSequential(new SDLog("Auton Status", "Shooting"));
		
//		addSequential(new LoadBoulder());//lego league style fire
		addSequential(new VisionFire());//vision assisted fire* will go to straight fire if no camera is found
		
		//addSequential(new SDLog("Auton Status", "Complete"));
	}
}
