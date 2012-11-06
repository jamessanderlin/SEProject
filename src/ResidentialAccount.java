import java.util.*;
public class ResidentialAccount extends Account
{
	private Meter meter;

	public ResidentialAccount(String clientName, int accountID, double balance, boolean flag, Date deadline, String billingAddress)
	{
		this.clientName = clientName;
		this.accountID = accountID;
		this.balance = balance;
		this.flag = flag;
		this.deadline = deadline;
		this.billingAddress = billingAddress;
	}
	
	public Meter getMeter() {
		return meter;
	}

	public void setMeter(Meter meter) {
		this.meter = meter;
	}
}
