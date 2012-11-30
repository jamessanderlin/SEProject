import java.util.*;
public class CommercialAccount extends Account
{
	private ArrayList<Service_Location> locations;
	private String companyName;

	public CommercialAccount(String compName, int accountID, double balance, boolean flag, Date deadline, Address billingAddress)
	{
		this.companyName = compName;
		this.accountID = accountID;
		this.balance = balance;
		this.flag = flag;
		this.deadline = deadline;
		this.billingAddress = billingAddress;
		this.isCommercial = true;
	}

	public ArrayList<Service_Location> getLocations() {
		return locations;
	}

	public void setLocations(ArrayList<Service_Location> locations) {
		this.locations = locations;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Override
	public void addServiceLocation(Service_Location s) {
		this.locations.add(s);
	}
	
	public String toString()
	{
		return companyName;
	}
}