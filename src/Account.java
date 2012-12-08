import java.text.DecimalFormat;
import java.util.*;

/**
 * 
 * @author James Sanderlin, Mudrekh Goderya, Avi Levy, Mark Duncan
 * 
 * The Account class handles input and output of the current state of the program to accounts.txt
 * 
 * TODO: Handle adding a meter or list of meters to an account
 * Interface: will be called from Meter_IO as Account.addMeter(Meter meter)
 * 
 * @ version 1.0
 *
 *Comments Updated 12/15/12 8:00pm
 */
public abstract class Account 
{
	protected int accountID;
	protected double balance;
	protected boolean flag;
	protected boolean isCommercial;
	protected Date deadline;
	protected Address billingAddress;
	protected TreeMap<Date, Payment> paymentHistory = new TreeMap<Date, Payment>();
	
	protected DecimalFormat money = new DecimalFormat("0.00");

	
	/*
	 * Basic Getters and Setters
	 */
	public int getAccountID() {
		return accountID;
	}
	public void setAccountNum(int accountID) {
		this.accountID = accountID;
	}
	public TreeMap<Date, Payment> getPaymentHistory() {
		return paymentHistory;
	}
	public void setPaymentHistory(TreeMap<Date, Payment> paymentHistory) {
		this.paymentHistory = paymentHistory;
    }
	
	/**
	 * Adds a payment and adjusts the account balance
	 * 
	 * @param p
	 */
    public void addPayment(Payment p){        
        paymentHistory.put(p.getPaymentDate(), p);
        
        balance += p.getPaidAmount();
	}
    
    /**
     * Deletes a payment and adjusts the account balance
     * 
     * @param d
     * @return the payment removed
     */
    public Payment deletePayment(Date d)
    {
    	balance -= paymentHistory.get(d).getPaidAmount();
        return paymentHistory.remove(d);
        
    }
    
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public boolean isCommercial() {
		return isCommercial;
	}
	public void setCommercial(boolean isCommercial) {
		this.isCommercial = isCommercial;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	/**
     * Checks all meters for possible additions/subtractions to the balance
     * 
     * @return balance
     */
	public abstract double getBalance();
	
	/**
	 * Abstract convenience method to add a meter to the account
	 * 
	 * @param m
	 */
	public abstract void addMeter(Meter m);
	
	/**
	 * Abstract convenience method to delete a meter from the account
	 * 
	 * @param meterID
	 * @return the meter that was deleted
	 */
	public abstract Meter deleteMeter(int meterID);
   
    /**
     * Abstract convenience method to access a meter based on its ID
     * 
     * @param meterID
     * @return the meter with the specified ID
     */ 
    public abstract Meter getMeter(int meterID);
    
    /**
     * Abstract convenience method to see if an account has a meter with the specified ID
     * 
     * @param meterID
     * @return whether or not the account has the specified meter
     */    
    public abstract boolean hasMeter(int meterID);
	
    /**
	 * Prints the boolean isCommercial as a '0' or '1' for persisting
	 * 
	 * @return '0' or '1' to denote the flag's value
	 */
	public String isCommercialToString(){
		if(isCommercial){
			return "1";
		}
		else{
			return "0";
		}
	}
	
	/**
	 * Prints the flag as a '0' or '1' instead of 'true' or 'false'
	 * 
	 * @return '0' or '1' to denote the flag's value
	 */
	public String getFlagToString(){
		if(flag) {
			return "1";
		}
		else {
			return "0";
		}
	}
	
	/**
	 * getMeterUsage returns the total usage from all meters tied to the account in the time period
	 * 
	 * @param start
	 * @param end
	 * @return total usage from all meters tied to the account (since cutoffDate)
	 */
	
	public abstract String getMeterUsageString(Date start, Date end);
	
	/**
	 * getTotalCost returns the total cost from all meters tied to the account in the time period
	 * 
	 * @param start
	 * @param end
	 * @return the total cost from all meters tied to the account in the time period
	 */
	
	public abstract double getTotalCost(Date start, Date end);
	
	/**
	 * getTotalTaxCost gets the total tax cost from all meters tied to the account in the time period
	 * 
	 * @param start
	 * @param end
	 * @return the total tax cost from all meters tied to the account in the time period
	 */
	
	public abstract double getTotalTaxCost(Date start, Date end);
}
