package org.usfirst.frc.team4131.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
    	public class AutonLowBarShoot extends CommandGroup {
    		private static final double speed = 0.5, distance = 63, shotAngle = 48, shotDistance = 29;
    		public AutonLowBarShoot() {
//    			addParallel(new SDLog("Auton Status", "Driving 1"));
    			addSequential(new DriveStraight(distance, 0, speed));
//    			addSequential(new SDLog("Auton Status", "Turning"));
    			addSequential(new Turn(shotAngle));
//    			addSequential(new ResetEncoders());
//    			addSequential(new SDLog("Auton Status", "Driving 2"));
    			addSequential(new DriveStraight(shotDistance, shotAngle, speed));
//    			addSequential(new SDLog("Auton Status", "Shooting"));
    			addSequential(new LoadBoulder());
//    			addSequential(new SDLog("Auton Status", "Complete"));
    		}
    }
