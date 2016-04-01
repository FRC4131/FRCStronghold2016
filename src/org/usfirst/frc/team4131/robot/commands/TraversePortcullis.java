package org.usfirst.frc.team4131.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TraversePortcullis extends CommandGroup {
	public TraversePortcullis(){
		addSequential(new DeployArms(800));
		addSequential(new DriveStraight(90, 0));
		addParallel(new StowArms());
		addSequential(new DriveStraight(100, 0));
	}
}
