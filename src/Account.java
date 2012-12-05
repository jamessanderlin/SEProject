import java.util.*;

/**
 * 
 * @author James Sanderlin, Mudrekh Goderya, Avi Levy
 * 
 * The Account class handles input and output of the current state of the program to accounts.txt
 * 
 * TODO: Handle adding a meter or list of meters to an account
 * Interface: will be called from Meter_IO as Account.addMeter(Meter meter)
 * 
 * @ version 1.0
 *
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
	
	public abstract void addMeter(Meter m);
        public abstract Meter deleteMeter(int meterID);
        public abstract Meter getMeter(int meterID);
        public abstract boolean hasMeter(int meterID);
	
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
	
	public abstract String getMeterUsage(Date cutoffDate);
	public abstract double getTotalCost(Date cutoffDate);
	public abstract double getTotalTaxCost(Date cutoffDate);
}
