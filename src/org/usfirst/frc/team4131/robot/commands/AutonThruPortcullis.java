package org.usfirst.frc.team4131.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonThruPortcullis extends CommandGroup {
    
    public  AutonThruPortcullis() {
		addSequential(new DeployArms(830.0));	//need to change the gear box
		addSequential(new DriveStraight(-10.0, 0.0, 0.5));
		addSequential(new DriveStraight(2.0, 0.0, 0.5));
		addParallel(new StowArms());
		addSequential(new DriveStraight(-70.0, 0.0, 0.4));
    }
}
