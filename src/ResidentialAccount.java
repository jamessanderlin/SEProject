
import java.util.*;
public class ResidentialAccount extends Account
{
	private Service_Location location;
	
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
	 
	public Service_Location getLocation() {
		return location;
	}


	public void setLocation(Service_Location location) {
		this.location = location;
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
	public void addServiceLocation(Service_Location s) {
		setLocation(s);
	}

		
}
