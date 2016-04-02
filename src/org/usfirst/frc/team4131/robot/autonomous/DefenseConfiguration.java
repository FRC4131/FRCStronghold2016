package org.usfirst.frc.team4131.robot.autonomous;

public class DefenseConfiguration extends Configuration<Defense> {
	public DefenseConfiguration(String name) {
		super(name);
		for (Defense defense : Defense.values())
			put(defense.name(), defense);
	}
}
