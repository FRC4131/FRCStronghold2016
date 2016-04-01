package org.usfirst.frc.team4131.robot.autonomous;

public class DirectionConfiguration extends Configuration<Integer>{
	private static final String[] names = {"North", "Northeast", "East", "Southeast", "South", "Southwest", "West", "Northwest"};
	private static final String[] abbreviations = {"N", "NE", "E", "SE", "S", "SW", "W", "NW"};
	public DirectionConfiguration(String name, String prefix){this(name, prefix, true);}
	public DirectionConfiguration(String name, String prefix, boolean longNames){
		super(name);
		int i = 0;
		for(String direction : longNames ? names : abbreviations){
			put(prefix + direction, i++);
		}
	}
	public String direction(){return names[key()];}
	public String dir(){return abbreviations[key()];}
	public int angle(){return key() * 45;}
}
