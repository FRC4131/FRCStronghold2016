package org.usfirst.frc.team4131.utilities;

import edu.wpi.first.wpilibj.Timer;

public class PIDController {
	private double Kp, Ki, Kd, setpoint, previousError, accumulatedError, previousTime;
	private double commandMin, commandMax;
	private Timer timer;

	public PIDController(double Kp, double Ki, double Kd, double setpoint, double commandMin, double commandMax) {
		this.Kp = Kp;
		this.Ki = Ki;
		this.Kd = Kd;
		this.setpoint = setpoint;
		this.timer = new Timer();

		this.previousError = 0.0;
		this.accumulatedError = 0.0;

		this.commandMin = commandMin;
		this.commandMax = commandMax;

		timer.reset();
		timer.start();

		previousTime = timer.get();
	}

	public double update(double input) {
		double dt = timer.get() - previousTime;
		previousTime = timer.get();
		double error = input - setpoint;
		double proportionalError = Kp * error;
		double differentialError = Kd * (error - previousError) * dt;
		double integralError = Ki * error * dt + accumulatedError;

		previousError = error;

		double totalCommand = proportionalError + differentialError + integralError;
		if (totalCommand > commandMax || totalCommand < commandMin) {
			totalCommand -= integralError;
		} else {
			accumulatedError = integralError;
		}

		return Math.min(commandMax, Math.max(commandMin, totalCommand));
	}
	
	public void reset(){
		accumulatedError = 0.0;
		previousError = 0.0;
	}
	public void changeSetpoint(double newSetpoint) {
		setpoint = newSetpoint;
		reset();
	}
}
