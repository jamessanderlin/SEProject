import java.util.*;
import java.util.Map.Entry;
/**
 * 
 * @author James Sanderlin, Mudrekh Goderya, Avi Levy, Mark Duncan
 * 
 * The Commercial Account class extends the Abstract class Account and provides
 * additional fields to an Account applicable to a commercial client.
 * 
 * Additional Fields:
 * String compName: The name of the company
 * TreeMap<Integer, Meter> meters: A treemap of all the meters tied to this commercial account
 *
 * @ version 1.0
 * 
 * Comments Updated 12/7/12 9:34 PM
 */
public class CommercialAccount extends Account
{
	
	private TreeMap<Integer, Meter> meters = new TreeMap<Integer, Meter>();
	private String companyName;

	/**
	 * Constructor
	 * 
	 * @param compName
	 * @param accountID
	 * @param balance
	 * @param flag
	 * @param deadline
	 * @param billingAddress
	 */
	public CommercialAccount(String compName, int accountID, double balance, boolean flag, Date deadline, Address billingAddress)
	{
		this.companyName = compName;
		this.accountID = accountID;
		this.balance = balance;
		this.flag = flag;
		this.deadline = deadline;
		this.billingAddress = billingAddress;
		//1 is commercial, 0 is residential
		this.isCommercial = true;
	}

	/*
	 * Basic Getters and Setters
	 */
	public TreeMap<Integer, Meter> getMeters() {
		return meters;
	}

	public void setMeters(TreeMap<Integer, Meter> meters) {
		this.meters = meters;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	/**
	 * toString method returns the company name
	 * 
	 * @return the company name
	 */
	public String toString()
	{
		return companyName;
	}
	
	@Override
	public double getBalance()
	{
		for(Entry<Integer, Meter> m : getMeters().entrySet()) {
			balance += m.getValue().getMeterBalance();
    	}
		balance = Double.parseDouble(money.format(balance));
		return balance;
	}
	
	
	/**
	 * Convenience method to add a meter to the account
	 * 
	 * @param m
	 */
	@Override
	public void addMeter(Meter m){
		meters.put(m.getMeterID(), m);
	}
       
	/**
	 * Convenience method to see if a meter with the specified ID is tied to the account
	 * 
	 * @param meterID
	 * @return whether or not the account has a meter with the specified ID
	 */
    public boolean hasMeter(int meterID)
    {
        return meters.containsKey(meterID);
    }
        
    /**
     * Convenience method to delete a meter from the account
     * 
     * @param meterID
     * @return the meter that was deleted
     */
    @Override
    public Meter deleteMeter(int meterID)
    {
       return meters.remove(meterID);
    }
    
    /**
     * Convenience method to access a meter based on its ID
     * 
     * @param meterID
     * @return the meter with the specified ID
     */
    public Meter getMeter(int meterID)
    {
        return meters.get(meterID);
    }
    
    /**
     * Convenience method to sum up the total cost from all meters tied to the account
     * 
     * @param cutoffDate
     * @return the total cost from all meters tied to the account
     */
    @Override
    public double getTotalCost(Date start, Date end) {
    	double accumulateCosts = 0.0;	
    	for(Entry<Integer, Meter> m : getMeters().entrySet()) {
    		accumulateCosts += ((Meter) m).getCost(start, end);
    	}
    	return accumulateCosts;
    }
    
    /**
     * Convenience method to sum up the total tax cost from all meters tied to the account
     * 
     * @param start - the start date cutoff
     * @param end - the end date cutoff
     * @return the total tax cost from all meters tied to the account
     */
    @Override
    public double getTotalTaxCost(Date start, Date end) {
    	double accumulateCosts = 0.0;	
    	for(Entry<Integer, Meter> m : getMeters().entrySet()) {
    		accumulateCosts += m.getValue().getTaxCost(start, end);
    	}
    	return accumulateCosts;
    }
    
    /**
     * Convenience method to print out a list of meters tied to the account and their usage
     * 
     * @param start - the start date cutoff
     * @param end - the end date cutoff
     * @return a string depicting a list of meters tied to the account and their usage
     */
    @Override
    public String getMeterUsageString(Date start, Date end){
    	String s = "";
    	for(Entry<Integer, Meter> m : getMeters().entrySet())
    	{
    		Meter meter = m.getValue();
    		s += "Meter #" + meter.getMeterID() + ": " + meter.getTotalUsage(start, end) + " kWh at a rate of $" + meter.getMeterRate() + " per kWh\n";
    	}
    	return s;
    }
}
