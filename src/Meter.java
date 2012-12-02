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
	
	private Address physicalAddress;
	private boolean taxable;
	private ArrayList<Taxes> taxes;
	
	
	public Meter(int meterID, String type) {
		this.meterID = meterID;
		readings = new TreeMap<Date, Meter_Reading>();
		setType(type);
	}
	public Meter(int meterID, String type, Address physicalAddress, boolean taxable)
	{
		this.meterID = meterID;
		setType(type);
		this.physicalAddress = physicalAddress;
		this.taxable = taxable;
	}
	
	public void addTax(Taxes t)
	{
		taxes.add(t);
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
	
	public Boolean getIsDigital() {
		return isDigital;
	}

	public void setIsDigital(Boolean isDigital) {
		this.isDigital = isDigital;
	}

	public Address getPhysicalAddress() {
		return physicalAddress;
	}

	public void setPhysicalAddress(Address physicalAddress) {
		this.physicalAddress = physicalAddress;
	}

	public boolean isTaxable() {
		return taxable;
	}

	public void setTaxable(boolean taxable) {
		this.taxable = taxable;
	}

	public ArrayList<Taxes> getTaxes() {
		return taxes;
	}

	public void setTaxes(ArrayList<Taxes> taxes) {
		this.taxes = taxes;
	}

	public void setReadings(TreeMap<Date, Meter_Reading> readings) {
		this.readings = readings;
	}

	public String toString()
	{
		return "ID: " + meterID;
	}
}
