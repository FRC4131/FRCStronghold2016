package org.usfirst.frc.team4131.robot.commands;


import org.usfirst.frc.team4131.utilities.Point;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GridAutoDrive extends CommandGroup {
	private Command[] cmds;
    public  GridAutoDrive(Point...points) {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	this.cmds = new Command[4 * points.length];
    	int cmdCounter = 0;
    	for(int i = 0; i < points.length; ++i){
    		cmds[cmdCounter++] = new TurnToAtRate(points[i], .5);
    		cmds[cmdCounter++] = new Wait(1);
    		cmds[cmdCounter++] = new DriveStraight(points[i], 0.25);
    		cmds[cmdCounter++] = new Wait(1);
    	}
    	for(Command cmd : cmds){
    		addSequential(cmd);
    	}
   }
}
