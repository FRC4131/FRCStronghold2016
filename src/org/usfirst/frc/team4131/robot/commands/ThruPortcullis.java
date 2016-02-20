package org.usfirst.frc.team4131.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ThruPortcullis extends CommandGroup {
    
    public  ThruPortcullis() {
    	addSequential(new StowArms());
		addSequential(new DeployArms(800.0));
		addSequential(new DriveStraight(-13, 0, 0.3));
		addSequential(new Wait(1.0));
		addParallel(new DeployArms(550.0));
		addSequential(new CommandGroup(){{
			addSequential(new Wait(1));
			addSequential(new DriveStraight(3, 0, 0.4));
			addSequential(new Wait(1));
			addSequential(new DriveStraight(-100, 0, 0.3));
		}});
    }
}
