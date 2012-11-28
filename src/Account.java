import java.util.*;

/**
 * 
 * @author James Sanderlin, Mudrekh Goderya
 * 
 * The Account class handles input and output of the current state of the program to accounts.txt
 * 
 * @ version 1.0
 *
 */
public abstract class Account 
{
	protected String clientFirstName;
	protected String clientLastName;
	protected int accountID;
	protected double balance;
	protected boolean flag;
	protected boolean isCommercial;
	protected Date deadline;
	protected Address billingAddress;
	protected ArrayList<Payment> paymentHistory = new ArrayList<Payment>();
	
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
	
	@Override
	public String toString()
	{
		return clientFirstName + " " + clientLastName + " ID: " + accountID;
	}
	
	public String isCommercialtoString(){
		String s = "";
		
		if(isCommercial){
			s = "1";
		}
		else{
			s = "0";
		}
		
		return s;
	}
}
