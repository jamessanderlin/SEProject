import java.util.*;
/**
 * 
 * @author James Sanderlin, Mudrekh Goderya, Avi Levy, Mark Duncan
 * 
 * The Residential Account class extends the Abstract class Account and provides
 * additional fields to an Account applicable to a residential account.
 * 
 * Additional Fields:
 * String clientFirstName: The first name of the client
 * String clientLastName: The last name of the client
 * Meter meter: Residential accounts have a single meter instance
 *
 * @ version 1.0
 * 
 * Comments Updated 12/15/12 8:00pm
 */
public class ResidentialAccount extends Account
{
	/*
	 * Class Data Fields
	 */
	private Meter meter;
	private String clientFirstName;
	private String clientLastName;
	
	/**
	 * Constructor
	 * 
	 * @param clientFirstName
	 * @param clientLastName
	 * @param accountID
	 * @param balance
	 * @param flag
	 * @param deadline
	 * @param billingAddress
	 */
	public ResidentialAccount(String clientFirstName, String clientLastName, int accountID, double balance, boolean flag, Date deadline, Address billingAddress)
	{
		this.clientFirstName = clientFirstName;
		this.clientLastName = clientLastName;
		this.accountID = accountID;
		this.balance = balance;
		this.flag = flag;
		this.deadline = deadline;
		this.billingAddress = billingAddress;
		this.isCommercial = false;
	}

	/*
	 * Basic Getters and Setters
	 */
	public Meter getMeter() {
		if(meter == null)
                    return null;
                else 
                    return getMeter(meter.getMeterID());
	}
	public void setMeter(Meter meter) {
		this.meter = meter;
	}

	public String getClientFirstName() {
		return clientFirstName;
	}

	public void setClientFirstName(String clientFirstName) {
		this.clientFirstName = clientFirstName;
	}

	public String getClientLastName() {
		return clientLastName;
	}

	public void setClientLastName(String clientLastName) {
		this.clientLastName = clientLastName;
	}
	
	@Override
	public double getBalance()
	{
		if(meter != null)
		{
			balance += meter.getMeterBalance();
		}
		
		balance = Double.parseDouble(money.format(balance));
		return balance;
	}
	
	/**
	 * Method to print the first and last name as a string
	 * 
	 * @return the string of the concatenation of first and last name
	 */
	@Override
	public String toString()
	{
		return clientFirstName + " " + clientLastName;
	}
	
	/**
	 * Method to add a meter to the account 
	 * (Residential Accounts only have one meter anyways)
	 * Implemented for public abstract method addMeter
	 * 
	 * @param m
	 *
	 */
	@Override
	public void addMeter(Meter m){
		meter = m;
	}
	
	/**
	 * Method to determine if the account has the meter specified in the argument
	 * 
	 * @param meterID
	 * 
	 * @return true or false if the object contains the meter in argument with 
	 * the specified Integer meter ID
	 */   
	
    public boolean hasMeter(int meterID)
    {
        if(meter != null)
            return meterID == meter.getMeterID();
        else
            return false;
    }
    
    /**
	 * Abstract convenience method to delete a meter from the account
	 * with the specified meterID in the argument
	 * 
	 * Changed the implementation to catch a null pointer exception.
	 * Removed duplication of functionality by using the hasMeter() method
	 * as well as moved the deletion operation to deleteMeter() instead of
	 * the other way around.
	 * 
	 * Got around the null pointer exception by adding a copy constructor
	 * to the Meter class, so that we properly copy the Meter data to
	 * a temporary location before deleting the reference.
	 * 
	 * @param meterID
	 * @return the meter Object that was deleted if applicable
	 */      
    
    @Override
    public Meter deleteMeter(int meterID)
    {
    	if(hasMeter(meterID)) {
    		return deleteMeter();
    	} else {
    		return null;
    	}
    }
    
    /**
	 * Convenience method to delete the unique meter
	 * 
	 * @return the meter Object that was deleted
	 */ 
    
    public Meter deleteMeter()
    {
    	if(meter == null) {
    		return null;
    	} else {
	        Meter temp = new Meter(meter);
	        meter = null;
	        return temp;       	
    	}
    }
    
    /**
	 * Method to return the Meter object with the specified
	 * meterID in the argument
	 * 
	 * @param meterID
	 * @return the specified meter Object
	 */ 
    
    public Meter getMeter(int meterID)
    {
        return meter;
    }
    
    /**
	 * This method returns a string summarizing
	 * the usage data of this meter.
	 * 
	 * @param start - the start date
	 * @param end - the end date
	 * @return a string of the Meter ID and the meter's usage, to be used for generating bills and reports
	 */
    @Override
    public String getMeterUsageString(Date start, Date end){
    	if(meter == null) {
    		return "This account has no meter tied to it.";
    	} else {
            return "Meter #" + meter.getMeterID() + ": " + meter.getTotalUsage(start, end) + " kWh at a rate of $" + meter.getMeterRate() + " per kWh\n";
    	}
    }
    
    /**
	 * Abstract convenience method to sum the total cost of the
	 * meter's usage for the account, expressed as a double
	 * 
	 * @param start - the start date cutoff
     * @param end - the end date cutoff
	 * @return a double of the cost of the meter's usage
	 */
    @Override
    public double getTotalCost(Date start, Date end) {
    	double result = 0.0;
        if(meter != null)
            result = meter.getCost(start, end);
        return result;
    }
    
    /**
	 * Abstract convenience method to get the total tax cost 
	 * of the meter for the account, expressed as a double
	 * 
	 * @param cutoffDate
	 * @return a double of the total tax cost of the meter
	 */
    
    @Override
    public double getTotalTaxCost(Date start, Date end) {
        double result = 0.0;
        if(meter != null)
            result = getMeter().getTaxCost(start, end);
        return result;
    }
}
