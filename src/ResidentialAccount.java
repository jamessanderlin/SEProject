
import java.util.*;
import java.util.Map.Entry;
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
        
        public boolean hasMeter(int meterID)
        {
            if(meter != null)
                return meterID == meter.getMeterID();
            else
                return false;
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
    
    public String getMeterUsage(Date cutoffDate){
    	String s = "";
    	s += "Meter #" + meter.getMeterID() + ": " + meter.getTotalUsage(cutoffDate) + " kWh at a rate of $" + meter.getMeterRate() + " per kWh\n";
    	return s;
    }
}
