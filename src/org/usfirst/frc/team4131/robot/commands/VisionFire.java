package org.usfirst.frc.team4131.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class VisionFire extends CommandGroup {
	public VisionFire() {
		addSequential(new VisionSeek());
		addSequential(new LoadBoulder());
	}
}
