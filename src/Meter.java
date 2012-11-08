import java.util.*;

/**
 * 
 * @author Mark Duncan, James Sanderlin, Mudrekh Goderya, Avi Levy
 * 
 * The Meter class is the entity class for a real life meter. It stores important info such
 * as the location, type of meter and the unique meter ID number
 * 
 * Each meter generates a series of meter readings. Each month, a new meter reading is generated
 * and stored with the meter information. The meter readings are stored in a hash map, with
 * key representing the meter reading date
 * 
 * The hash map is used to ensure that no two readings with the same date are stored.
 * This corresponds to Date being a primary key in the database model.
 * 
 * @version 1.5
 *
 */
public class Meter
{
	//Specifies if the meter is Analog (manual reading) or digital (digital reading)
	private Boolean isDigital; 
	
	// A unique meter ID number for referencing
	private int meterID;
	
	//Stores a list of readings for the meter instance
	private HashMap<Date,Meter_Reading> readings = new HashMap<Date,Meter_Reading>(); 
	
	
	//Stores the rate for the meter
	private Rate meterRate;
	public Meter(int meterID, String type) {
		this.meterID = meterID;
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
	/*
	 * I believe these are unnecessary - Avi
	public HashMap<Date,Meter_Reading> getReadings() {
		return readings;
	}
	public void setReadings(HashMap<Date, Meter_Reading> readings) {
		this.readings = readings;
	}
	*/
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
