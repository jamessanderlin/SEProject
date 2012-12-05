
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
		if(meter == null)
                    return null;
                else 
                    return getMeter(meter.getMeterID());
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
        
    @Override
    public Meter deleteMeter(int meterID)
    {
        if(meterID == meter.getMeterID())
        {
            Meter temp = meter;
            meter = null;
            return meter;
        }
        else
        {
            return null;
        }
    }
    
    public Meter deleteMeter()
    {
        return deleteMeter(meter.getMeterID());
    }
    
    public Meter getMeter(int meterID)
    {
        return meter;
    }

    @Override
    public double getTotalCost(Date cutoffDate) {
    	return getMeter().getCost(cutoffDate);
    }
    
    @Override
    public double getTotalTaxCost(Date cutoffDate) {
    	return getMeter().getTaxCost(cutoffDate);
    }
}
