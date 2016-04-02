package org.usfirst.frc.team4131.robot.autonomous;

import org.usfirst.frc.team4131.robot.commands.DriveStraight;
import org.usfirst.frc.team4131.robot.commands.LoadBoulder;
import org.usfirst.frc.team4131.robot.commands.TraversePortcullis;
import org.usfirst.frc.team4131.robot.commands.Turn;
import org.usfirst.frc.team4131.robot.commands.VisionSeek;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Autonomous {
	private NumericConfiguration startPos = new NumericConfiguration("AutonStartPos", "Starting Position ", 1, 5);
	private DefenseConfiguration startDef = new DefenseConfiguration("AutonStartDef");
	private Configuration<?>[] configurations = { startPos, startDef };

	public Autonomous() {
	}

	public void init() {
		for (Configuration<?> config : configurations)
			config.init();
	}

	public int startPosition() {
		return startPos.value();
	}

	public Defense startDefense() {
		return startDef.value();
	}

	public Command assembleCommand() {
		CommandGroup cmd = new CommandGroup();
		cmd.addSequential(new DriveStraight(60, 0, 0.5));// Move to the start defense
		switch (startDefense()) {// Traverse the start defense
		case LOW_BAR:
			cmd.addSequential(new DriveStraight(60, 0, 0.5));
			break;
		case PORTCULLIS:
			cmd.addSequential(new TraversePortcullis(true));//Travels 50
			cmd.addSequential(new DriveStraight(10, 0, 0.5));
			break;
		case CHEVAL_DE_FRESE:
			return null;
		case SALLY_PORT:
			return null;
		case DRAWBRIDGE:
			return null;
		case ROUGH_TERRAIN:
			cmd.addSequential(new DriveStraight(60, 0, 0.3));
			break;
		case RAMPARTS:
			return null;
		case ROCK_WALL:
			cmd.addSequential(new DriveStraight(60, 0, 0.8));
			break;
		case MOAT:
			cmd.addSequential(new DriveStraight(60, 0, 0.7));
			break;
		}
		//Move to firing position
		switch (startPosition()) {
		case(1):
			cmd.addSequential(new DriveStraight(60, 0, 0.5));
			cmd.addSequential(new Turn(52));
			break;
		case(2):
			cmd.addSequential(new DriveStraight(120, 0, 0.5));
			break;
		case(3):
			cmd.addSequential(new Turn(45));
			cmd.addSequential(new DriveStraight(45, 0.5));
			cmd.addSequential(new Turn(0));
			break;
		case(4):
			cmd.addSequential(new DriveStraight(20, 0, 0.5));
			break;
		case(5):
			cmd.addSequential(new Turn(335));
			cmd.addSequential(new DriveStraight(60, 0.5));
			cmd.addSequential(new Turn(0));
			break;
		}
		cmd.addSequential(new VisionSeek());
		cmd.addSequential(new LoadBoulder());
		return cmd;
	}
}
