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
	protected ArrayList<Payment> paymentHistory = new ArrayList<Payment>();
	
	/*
	 * Basic Getters and Setters
	 */
	public int getAccountID() {
		return accountID;
	}
	public void setAccountNum(int accountID) {
		this.accountID = accountID;
	}
	public ArrayList<Payment> getPaymentHistory() {
		return paymentHistory;
	}
	public void setPaymentHistory(ArrayList<Payment> paymentHistory) {
		this.paymentHistory = paymentHistory;
	}
	public double getBalance() {
		return balance;
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
		String s = "";
		
		if(isCommercial){
			s = "1";
		}
		else{
			s = "0";
		}
		
		return s;
	}
	
	/**
	 * Prints the flag as a '0' or '1' instead of 'true' or 'false'
	 * 
	 * @return '0' or '1' to denote the flag's value
	 */
	public String getFlagToString(){
		String s = "";
		
		if(flag){
			s = "1";
		}
		else
		{
			s="0";
		}
		
		return s;
	}
	
	/**
	 * getMeterUsage returns the total usage from all meters tied to the account (since cutoffDate)
	 * 
	 * @param cutoffDate
	 * @return total usage from all meters tied to the account (since cutoffDate)
	 */
	
	public abstract String getMeterUsage(Date cutoffDate);
	
	/**
	 * getTotalCost returns the total cost from all meters tied to the account (since cutoffDate)
	 * 
	 * @param cutoffDate
	 * @return the total cost from all meters tied to the account (since cutoffDate)
	 */
	
	public abstract double getTotalCost(Date cutoffDate);
	
	/**
	 * getTotalTaxCost gets the total tax cost from all meters tied to the account (since the cutoffDate)
	 * 
	 * @param cutoffDate
	 * @return the total tax cost from all meters tied to the account (since the cutoffDate)
	 */
	
	public abstract double getTotalTaxCost(Date cutoffDate);
}
