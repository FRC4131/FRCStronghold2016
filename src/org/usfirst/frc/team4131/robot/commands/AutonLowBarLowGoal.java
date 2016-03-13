package org.usfirst.frc.team4131.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonLowBarLowGoal extends CommandGroup {

	public AutonLowBarLowGoal() {
		addSequential(new DriveStraight(197, 0, 0.3));
		addSequential(new TurnToAtRate(48, 0.4));
		addSequential(new DriveStraight(66, 48, 0.3));
		addSequential(new TurnToAtRate(180, 0.4));
		addSequential(new UnloadBoulder());
	}
}
