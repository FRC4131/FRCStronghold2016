package org.usfirst.frc.team4131.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PositionC extends CommandGroup {

	private static final int LEG1_DISTANCE = 5 * 12;
	private static final int TOWER_ANGLE = 10;
	private static final int LEG2_DISTANCE = 3 * 12;

	public PositionC() {
		addSequential(new DriveStraight(LEG1_DISTANCE, 0, 0.4));
		addSequential(new TurnToAtRate(TOWER_ANGLE, 0.4));
		addSequential(new DriveStraight(LEG2_DISTANCE, TOWER_ANGLE, 0.4));
	}
}
