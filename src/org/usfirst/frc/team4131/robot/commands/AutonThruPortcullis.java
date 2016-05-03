package org.usfirst.frc.team4131.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonThruPortcullis extends CommandGroup {
    public final double RATIO = (2.0 + 4.0 / 9.0);
	public AutonThruPortcullis() {
		addParallel(new DriveStraight(-16.0 * RATIO, 0.0, 0.5));
		addSequential(new DeployArms(-800.0));
		addSequential(new DriveStraight(-16 * RATIO, 0.0, 0.5));
		addParallel(new StowArms());
		addSequential(new CommandGroup(){
			{
				addSequential(new DriveStraight(4.5 * RATIO, 0.0, 0.5));
				addSequential(new DriveStraight(-30.0 * RATIO, 0.0, 0.6));
			}
		});
    }
}
