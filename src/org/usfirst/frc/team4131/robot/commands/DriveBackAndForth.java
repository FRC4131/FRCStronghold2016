package org.usfirst.frc.team4131.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveBackAndForth extends CommandGroup {
	public DriveBackAndForth() {
		for (int i = 0; i < 2; i++) {
			addSequential(new DriveStraight(5 * 12, 0, 0.5));
			addSequential(new DriveStraight(-5 * 12, 0, 0.5));
		}
	}
}
