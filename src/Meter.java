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
 *Comments Updated: 12/7/12 9:29 PM
 */
public class Meter
{
    
	/*
	 * Data Fields
	 */
	
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
	
	//Address object of the physicalAddress of the meter
	private Address physicalAddress;

	//TreeMap that stores the taxes associated with the meter
	private TreeMap<String, Taxes> taxes;
	
	//Store balance from meter readings that Account has not added to its balance yet
	private double meterBalance = 0;
	
	/**
	 * Copy Constructor - used to avoid null pointer exceptions in deleteMeter() functions
	 * @param other
	 */
	public Meter(Meter other) {
		isDigital = other.isDigital;
		meterID = other.meterID;
		readings = other.readings;
		meterRate = other.meterRate;
		physicalAddress = other.physicalAddress;
		taxes = other.taxes;
		meterBalance = other.meterBalance;
	}
	/**
	 * Constructor
	 * 
	 * @param meterID
	 * @param type
	 * @param rate
	 * @param physicalAddress
	 *
	 */
	public Meter(int meterID, String type, double rate, Address physicalAddress)
	{
		this.meterID = meterID;
		setType(type);
		this.physicalAddress = physicalAddress;
		readings = new TreeMap<Date, Meter_Reading>();
		taxes = new TreeMap<String, Taxes>();
		meterRate = rate;
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
     * Returns true if the given meter reading is the
     * most recent meter reading associated with this
     * meter.
     * 
     * @param mr - the meter reading to test
     * @return - whether it is last reading
     */
    public Boolean isLastReading(Date d) {
    	return readings.lastKey().equals(d);
    }
    
    /**
     * Returns true if the given date is the
     * most recent date of a meter reading associated with this
     * meter.
     * 
     * @param d - the date to test
     * @return - whether it is last reading
     */
    public Boolean isLastReading(Meter_Reading mr) {
    	return isLastReading(mr.getReadingDate());
    }
    
    /**
     * A utility method to return the usage from a Meter_Reading
     * stored in our list of readings.
     * 
     * This is computed as the difference in values of the
     * passed in meter reading and the previous meter reading in
     * 
     * @param mr - The Meter_Reading for which we want to compute usage 
     * @return usage value
     */
    public int getUsageFromReading(Meter_Reading mr) {
    	Meter_Reading secondLast;
    	try {
    		secondLast = readings.lowerEntry(mr.getReadingDate()).getValue();
    	} catch (NullPointerException e) {
    		return mr.getReading();
    	}
    	if(secondLast == null) {
    		return mr.getReading();
    	} else {
    		return mr.getReading() - secondLast.getReading();
    	}
    }
    /**
     * Convenience method to add a meter reading, adds to meterBalance so that next time the
     * Account checks, it will be added to its balance
     * 
     * Note: I factored out some of the computation into the above method,
     * getUsageFromReading. Also, I updated the algorithm to use fewer steps and 
     * it is more straightforward in my opinion now. Lastly it uses the positive balance
     * convention we are switching to. -Avi
     * 
     * @param r
     */
	public void addReading(Meter_Reading r, boolean fromFile)
	{
		readings.put(r.getReadingDate(),r);
		System.out.println("adding reading");
		if((!fromFile) && isLastReading(r))
		{
            System.out.println("adjusting meter balance");
			double readingCost = getUsageFromReading(r) * meterRate;
        	meterBalance += (1 + getTotalTaxRate()) * readingCost; 
		}
		
	}
    
	public Meter_Reading deleteReading(Meter_Reading mr) {
		return deleteReading(mr.getReadingDate());
	}
	
	/**
	 * Convenience method to delete a meter reading
	 * 
	 * @param d
	 * @return the meter reading that was deleted
	 */
    public Meter_Reading deleteReading(Date d)
    {
    	if(isLastReading(d) && readings.lowerKey(d) != null) {
    		System.out.println("adjusting meter balance");
			double readingCost = getUsageFromReading(readings.get(d)) * meterRate;
        	meterBalance -= (1 + getTotalTaxRate()) * readingCost; 
    	}
        return readings.remove(d);
    }
    
	/**
	 * Retrieves and clears the meterBalance
	 * To be used by account, every time it tries to get its balance it
	 * calls this method for every meter to see if they have stored balances.
	 * 
	 * @return mb Variable representing the unread balance on the meter
	 */
	public double getMeterBalance()
	{
		double mb = meterBalance;
		meterBalance = 0;
		return mb;
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
		if(type.toLowerCase().equals("digital")) {
			isDigital = true;
		} else {
            isDigital = false;
        }
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
	
	public int getTotalUsage(Date start, Date end) {
//		int accumulateReadings = 0;
//                Map<Date, Meter_Reading> readings
//		for (Entry<Date, Meter_Reading> mr : getReadings().tailMap(start).headMap(end).entrySet() ) {
//			accumulateReadings += mr.getValue().getReading();
//		}
//		return accumulateReadings;
            
           int result;
           try
           {
               Map.Entry<Date, Meter_Reading> lastReadingInPeriod = getReadings().lowerEntry(end);
               Map.Entry<Date, Meter_Reading> firstReadingInPeriod = getReadings().ceilingEntry(start);
               result = lastReadingInPeriod.getValue().getReading() - firstReadingInPeriod.getValue().getReading();
           }
           catch(Exception e)
           {
              result = 0;
           }
           
           return result;
           
	}

	/**
	 * Returns the total cost of usage on this meter using the getTotalUsage method
	 * 
	 * @param cutoffDate
	 * @return the total cost of usage on this meter using the getTotalUsage method
	 */
	
	public double getCost(Date start, Date end) {
		return getTotalUsage(start, end)*getMeterRate();
	}

	/**
	 * Returns the total tax cost on usage of this meter using the getTotalTaxRate method
	 * 
	 * @param cutoffDate
	 * @return the total tax cost on usage of this meter using the getTotalTaxRate method
	 */
	
	public double getTaxCost(Date start, Date end) {
		return getCost(start, end)*getTotalTaxRate();
	}
}