import java.util.*;
/**
 * 
 * @author Mark Duncan, James Sanderlin, Mudrekh Goderya, Avi Levy
 * 
 * The Meter_Reading class is the entity class for a meter reading.
 * 
 * @version 1.0
 *
 *Comments Updated: 12/5/12 8:30pm
 */
public class Meter_Reading
{
	/*
	 * Data Fields
	 */
	//An integer representing the reading of the meter usage
	private int reading;
	//A date of the meter reading
	private Date readingDate;
	
	/**
	 * Default Constructor
	 * 
	 * @param reading
	 * @param readingDate
	 */
	public Meter_Reading(int reading, Date readingDate) {
		setReading(reading);
		setReadingDate(readingDate);
	}
	/*
	 * Basic Getters and Setters
	 */
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
}