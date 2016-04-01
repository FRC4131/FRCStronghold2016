package org.usfirst.frc.team4131.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class VisionOnly extends CommandGroup {
    
    public  VisionOnly() {
    	addSequential(new VisionSeek());
    	addSequential(new LoadBoulder());
    }
}
