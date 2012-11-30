import java.util.*;

/**
 * 
 * @author Mark Duncan, James Sanderlin, Mudrekh Goderya, Avi Levy
 * 
 * The Meter class is the entity class for a real life meter. It stores important info such
 * as the location, type of meter and the unique meter ID number
 * 
 * @version 1.0
 *
 */
public class Meter
{
	//Specifies if the meter is Analog (manual reading) or digital (digital reading)
	private Boolean isDigital; 
	
	// A unique meter ID number for referencing
	private int meterID;
	
	//Stores a list of readings for the meter instance
	private TreeMap<Date, Meter_Reading> readings; 
	
	//Stores the rate for the meter
	private Rate meterRate;
	public Meter(int meterID, String type) {
		this.meterID = meterID;
		readings = new TreeMap<Date, Meter_Reading>();
		setType(type);
	}
	public void addReading(Meter_Reading r)
	{
		readings.put(r.getReadingDate(),r);
	}
	
	public String getType() {
		if(isDigital) {
			return "Digital";
		}
		return "Analog";
	}
	public void setType(String type) {
		if(type.equals("Digital")) {
			isDigital = true;
		}
		isDigital = false;
	}
	public int getMeterID() {
		return meterID;
	}
	public void setMeterID(int meterID) {
		this.meterID = meterID;
	}
	public TreeMap<Date, Meter_Reading> getReadings() {
		return readings;
	}

	public Rate getMeterRate() {
		return meterRate;
	}
	public void setMeterRate(Rate meterRate) {
		this.meterRate = meterRate;
	}
	
	public String toString()
	{
		return "ID: " + meterID;
	}
}
