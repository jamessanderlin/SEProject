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
	private String location;
	private String type;
	private int meterID;
	private ArrayList<Meter_Reading> readings = new ArrayList<Meter_Reading>();
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	
}
