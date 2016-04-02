package org.usfirst.frc.team4131.robot.autonomous;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Configuration<T> {
	protected String name;
	protected List<String> keys = new ArrayList<>();
	protected List<T> values = new ArrayList<>();
	protected SendableChooser chooser = new SendableChooser();

	public Configuration(String name) {
		this.name = name;
	}

	public Configuration<T> put(String key, T value) {
		keys.add(key);
		values.add(value);
		return this;
	}

	public void init() {
		chooser.addDefault(keys.get(0), 0);
		for (int i = 1; i < keys.size(); i++)
			chooser.addObject(keys.get(i), i);
		SmartDashboard.putData(name, chooser);
	}

	public int key() {
		return (int) chooser.getSelected();
	}

	public T value() {
		return values.get(key());
	}
}
