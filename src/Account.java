import java.util.*;

/**
 * 
 * @author James Sanderlin
 * 
 * The Account_IO class handles input and output of the current state of the program to accounts.txt
 * 
 * @ version 1.0
 *
 */
public abstract class Account 
{
	protected String clientName;
	protected int accountID;
	protected double balance;
	protected boolean flag;
	protected Date deadline;
	protected Address billingAddress;
	protected Payment[] paymentHistory;
		
	
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public int getAccountID() {
		return accountID;
	}
	public void setAccountNum(int accountID) {
		this.accountID = accountID;
	}
	public Payment[] getPaymentHistory() {
		return paymentHistory;
	}
	public void setPaymentHistory(Payment[] paymentHistory) {
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
	
}
