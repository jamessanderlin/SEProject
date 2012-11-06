import java.util.*;
public class CommercialAccount extends Account
{
	private ArrayList<Meter> meters = new ArrayList<Meter>();

	public CommercialAccount(String clientName, int accountID, double balance, boolean flag, Date deadline, String billingAddress)
	{
		this.clientName = clientName;
		this.accountID = accountID;
		this.balance = balance;
		this.flag = flag;
		this.deadline = deadline;
		this.billingAddress = billingAddress;
	}
	
	public ArrayList<Meter> getMeters() {
		return meters;
	}

	public void setMeters(ArrayList<Meter> meters) {
		this.meters = meters;
	}
}
