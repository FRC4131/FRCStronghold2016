package org.usfirst.frc.team4131.utilities;
import edu.wpi.first.wpilibj.AccumulatorResult;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Timer;

public class AnalogGyro extends edu.wpi.first.wpilibj.AnalogGyro{
	private final double kCalibrationSampleTime = 2.0;
	protected AnalogInput m_analog;
	  double m_voltsPerDegreePerSecond;
	  double m_offset;
	  int m_center;
	  boolean m_channelAllocated = false;
	  AccumulatorResult result;
	  
	public AnalogGyro(AnalogInput channel) {
		super(channel);
	}
	public AnalogGyro(int channel){
		super(channel);
	}
	public AnalogGyro(int channel, int center, double offset){
		super(channel, center, offset);
	}
	public void initGyro(){
		super.initGyro();
	}
	public void calibrate() {
		    m_analog.initAccumulator();
		    m_analog.resetAccumulator();

		    Timer.delay(kCalibrationSampleTime);

		    m_analog.getAccumulatorOutput(result);

		    m_center = (int) ((double) result.value / (double) result.count + .5);

		    m_offset = ((double) result.value / (double) result.count) - m_center;

		    m_analog.setAccumulatorCenter(m_center);
		    m_analog.resetAccumulator();
	 }
	public void setSensitivity(double voltsPerDegreePerSecond){
		super.setSensitivity(voltsPerDegreePerSecond);
	}
	public void setOffset(double offset){
		m_offset = offset;
	}
	public void setCenter(int center){
		m_center = center;
	}
}
