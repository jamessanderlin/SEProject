
import java.util.*;
public class ResidentialAccount extends Account
{
	private Meter meter;
	
	private String clientFirstName;
	private String clientLastName;
	
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

	public Meter getMeter() {
		return meter;
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
	public String toString()
	{
		return clientFirstName + " " + clientLastName;
	}
	
	@Override
	public void addMeter(Meter m){
		meter = m;
	}

		
}
