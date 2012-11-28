import java.util.*;

/**
 * 
 * @author Mark Duncan, James Sanderlin, Mudrekh Goderya, Avi Levy
 * 
 * The Meter_Reading class is the entity class for a meter reading.
 * 
 * @version 1.0
 *
 */
public class Meter_Reading
{
	private int reading;
	private Date readingDate;
	private int meterReadingID;
	
	public Meter_Reading(int reading, Date readingDate, int meterID) {
		setReading(reading);
		setReadingDate(readingDate);
		setMeterReadingID(meterID);
	}
	
	public int getReading() {
		return reading;
	}
	public void setReading(int reading) {
		this.reading = reading;
	}
	public Date getReadingDate() {
		return readingDate;
	}
	public void setReadingDate(Date readingDate) {
		this.readingDate = readingDate;
	}
	
	public int getMeterReadingID() {
		return meterReadingID;
	}
	public void setMeterReadingID(int meterID) {
		this.meterReadingID = meterID;
	}
	
}

