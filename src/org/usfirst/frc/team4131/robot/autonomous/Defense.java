package org.usfirst.frc.team4131.robot.autonomous;

public enum Defense {
	LOW_BAR, ROUGH_TERRAIN, PORTCULLIS, ROCK_WALL, CHEVAL_DE_FRESE, MOAT, SALLY_PORT, RAMPARTS, DRAWBRIDGE;
	public static Defense byName(String name) {
		for (Defense defense : values()) {
			if (defense.name().equalsIgnoreCase(name))
				return defense;
		}
		return null;
	}
}