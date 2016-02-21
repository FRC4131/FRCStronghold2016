package org.usfirst.frc.team4131.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ThruPortcullis extends CommandGroup {
    
    public  ThruPortcullis() {
    	addSequential(new StowArms());
		addSequential(new DeployArms(750.0));	//need to change the gear box
		addSequential(new DriveStraight(-10.0, 0.0, 0.5));
		addParallel(new StowArms());
		addSequential(new DriveStraight(-50.0, 0.0, 0.5));
    }
}
