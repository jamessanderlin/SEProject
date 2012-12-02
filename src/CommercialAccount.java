import java.util.*;
public class CommercialAccount extends Account
{
	private ArrayList<Meter> meters = new ArrayList<Meter>();
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

	public ArrayList<Meter> getMeters() {
		return meters;
	}

	public void setMeters(ArrayList<Meter> meters) {
		this.meters = meters;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String toString()
	{
		return companyName;
	}
	
	@Override
	public void addMeter(Meter m){
		meters.add(m);
	}
	
}