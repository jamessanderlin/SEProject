import java.util.*;

/**
 * 
 * @author Mark Duncan, James Sanderlin, Mudrekh Goderya
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
	private String type; 
	
	// A unique meter ID number for referencing
	private int meterID;
	
	//Stores a list of readings for the meter instance
	private ArrayList<Meter_Reading> readings = new ArrayList<Meter_Reading>(); 
	
	//Stores the physical location of the meter
	private String physicalAddress; 
	
	//Stores the rate for the meter
	private Rate meterRate;
	
	public void addReading(Meter_Reading r)
	{
		readings.add(r);
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getMeterID() {
		return meterID;
	}
	public void setMeterID(int meterID) {
		this.meterID = meterID;
	}
	public ArrayList<Meter_Reading> getReadings() {
		return readings;
	}
	public void setReadings(ArrayList<Meter_Reading> readings) {
		this.readings = readings;
	}
	public String getPhysicalAddress() {
		return physicalAddress;
	}
	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}
	public Rate getMeterRate() {
		return meterRate;
	}
	public void setMeterRate(Rate meterRate) {
		this.meterRate = meterRate;
	}
	
	
}
