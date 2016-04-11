package org.usfirst.frc.team4131.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TraversePortcullis extends CommandGroup {
	public TraversePortcullis(boolean turn) {
		addSequential(new DeployArms(800));
		if(turn) addSequential(new Turn(180));
//		addSequential(new DriveStraight(-90, 0.5));
		addSequential(new DriveStraight(-50 * (2.0 + 4.0 / 9.0), 0.5));
		addParallel(new StowArms());
//		addSequential(new DriveStraight(-100, 0.5));
		if(turn) addSequential(new Turn(0));
	}
}
