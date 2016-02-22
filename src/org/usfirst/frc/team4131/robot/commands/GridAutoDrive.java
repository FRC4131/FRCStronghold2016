package org.usfirst.frc.team4131.robot.commands;


import org.usfirst.frc.team4131.robot.Robot;
import org.usfirst.frc.team4131.utilities.Point;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class GridAutoDrive extends CommandGroup {
    public Command driveStraight, turn;
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
    	goTo(points);
    }
    public void goTo(Point...coordinates){
		for(Point coord:coordinates){
				addSequential(new TurnToAtRate(coord, 5));
				addSequential(new DriveStraight(coord, 0.75));
				addSequential(new UpdateXY());//makes sure to end current command first
		}
	}
}
