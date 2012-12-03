import java.util.*;
public class CommercialAccount extends Account
{
	private TreeMap<Integer, Meter> meters = new TreeMap<Integer, Meter>();
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

	public TreeMap<Integer, Meter> getMeters() {
		return meters;
	}

	public void setMeters(TreeMap<Integer, Meter> meters) {
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
		meters.put(m.getMeterID(), m);
	}
        
        @Override
        public Meter deleteMeter(int meterID)
        {
           return meters.remove(meterID);
        }
	
}