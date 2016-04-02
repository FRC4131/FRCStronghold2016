package org.usfirst.frc.team4131.robot.autonomous;

public class StringConfiguration extends Configuration<String> {
	public StringConfiguration(String name, String... options) {
		super(name);
		for (String option : options)
			put(option, option);
	}
}
