import java.util.*;
import java.util.Map.Entry;

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
    
    //Denotes the types of meters possible
    private static final String[] types = {"Digital", "Analog"};
        
	//Specifies if the meter is Analog (manual reading) or digital (digital reading)
	private Boolean isDigital; 
	
	// A unique meter ID number for referencing
	private int meterID;
	
	//Stores a list of readings for the meter instance
	private TreeMap<Date, Meter_Reading> readings; 
	
	//Stores the rate for the meter
	private double meterRate;
	
	private Address physicalAddress;

	private TreeMap<String, Taxes> taxes;
	
	public Meter(int meterID, String type, double rate, Address physicalAddress)
	{
		this.meterID = meterID;
		setType(type);
		this.physicalAddress = physicalAddress;
		readings = new TreeMap<Date, Meter_Reading>();
		taxes = new TreeMap<String, Taxes>();
		meterRate = rate;
	}
	
	/**
	 * Convenience method to add a tax to a meter
	 * 
	 * @param t
	 */
	public void addTax(Taxes t)
	{
		taxes.put(t.getName(),t);
	}
    
	/**
	 * Convenience method to remove a tax from a meter
	 * 
	 * @param n
	 * @return the tax deleted
	 */
    public Taxes deleteTax(String n)
    {
        return taxes.remove(n);
    }
    /**
     * Convenience method to add a meter reading
     * 
     * @param r
     */
	public void addReading(Meter_Reading r)
	{
		readings.put(r.getReadingDate(),r);
		
	}
     
	/**
	 * Convenience method to delete a meter reading
	 * 
	 * @param d
	 * @return the meter reading that was deleted
	 */
    public Meter_Reading deleteReading(Date d)
    {
        return readings.remove(d);
    }
	
    /**
     * Returns the type of the meter ("Digital" or "Analog")
     * 
     * @return the type of the meter ("Digital" or "Analog")
     */
	public String getType() {
		if(isDigital) {
			return "Digital";
		}
		return "Analog";
	}
	/**
	 * Receives a string denoting the type of the meter, sets it to that
	 * 
	 * @param type
	 */
	public void setType(String type) {
		if(type.toLowerCase().equals("digital")) 
                {
			isDigital = true;
		}
                else
                {
                    isDigital = false;
                }
	}
	
	/*
	 * Basic Getters and Setters
	 */
	public int getMeterID() {
		return meterID;
	}
	public void setMeterID(int meterID) {
		this.meterID = meterID;
	}
	public TreeMap<Date, Meter_Reading> getReadings() {
		return readings;
	}
	public void setReadings(TreeMap<Date, Meter_Reading> readings) {
		this.readings = readings;
	}
	
	public double getMeterRate() {
		return meterRate;
	}
	public void setMeterRate(double meterRate) {
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
	public TreeMap<String, Taxes> getTaxes() {
		return taxes;
	}

	/**
	 * Prints out the ID of the meter
	 * 
	 * @return the ID of the meter
	 */
	public String toString()
	{
		return "ID: " + meterID;
	}
    
	/**
	 * Returns the types, "Digital" and "Analog"
	 * 
	 * @return the types, "Digital" and "Analog"
	 */
    public static String[] getTypes()
    {
        return types;
    }
	
    /**
     * Returns the total tax rate of all taxes on the meter
     * 
     * @return the total tax rate of all taxes on the meter
     */
	public double getTotalTaxRate() {
        double accumulateTaxes = 0.0;
        for(Taxes t : getTaxes().values()) {
            accumulateTaxes += t.getRate();
        }
        return accumulateTaxes;
    }

	/**
	 * Returns the total usage on the meter by summing up all the meter readings
	 * 
	 * @param cutoffDate
	 * @return the total usage on the meter by summing up all the meter readings
	 */
	public int getTotalUsage(Date cutoffDate) {
		int accumulateReadings = 0;
		for (Entry<Date, Meter_Reading> mr : getReadings().tailMap(cutoffDate).entrySet() ) {
			accumulateReadings += mr.getValue().getReading();
		}
		return accumulateReadings;
	}

	/**
	 * Returns the total cost of usage on this meter using the getTotalUsage method
	 * 
	 * @param cutoffDate
	 * @return the total cost of usage on this meter using the getTotalUsage method
	 */
	public double getCost(Date cutoffDate) {
		return getTotalUsage(cutoffDate)*getMeterRate();
	}

	/**
	 * Returns the total tax cost on usage of this meter using the getTotalTaxRate method
	 * 
	 * @param cutoffDate
	 * @return the total tax cost on usage of this meter using the getTotalTaxRate method
	 */
	public double getTaxCost(Date cutoffDate) {
		return getCost(cutoffDate)*getTotalTaxRate();
	}

}
