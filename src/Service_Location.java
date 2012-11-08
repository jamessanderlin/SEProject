import java.util.*;
/**
 * 
 * @author Mark Duncan, Mudrekh Goderya, Avi Levy
 * 
 * This class stores the information necessary for a service location, such as where the meter is installed, and
 * will also handle any applicable taxes.
 * 
 * @version 1.0
 *
 */

import java.util.*;
public class Service_Location {
	
	//Describes the identification number related to the service location
	private int ID;

	//Stores the physical address of the service location, different than the billing address stored
	//in account
	private Address physicalAddress;
	
	//Describes if the location is residential or commercial
	private String type; 

	//Boolean for if the location is taxable or not, for example in the case of non-profits
	private boolean taxable;
	
	//Contains a list of taxes applied to this location
	private ArrayList<Taxes> taxes;
	
	//The meter installed at the service location
	private Meter meter;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Address getAddress() {
		return physicalAddress;
	}

	public void setAddress(Address address) {
		this.physicalAddress = physicalAddress;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isTaxable() {
		return taxable;
	}

	public void setTaxable(boolean taxable) {
		this.taxable = taxable;
	}

	public ArrayList<Taxes> getTaxes() {
		return taxes;
	}

	public void setTaxes(ArrayList<Taxes> taxes) {
		this.taxes = taxes;
	}

	public Meter getMeter() {
		return meter;
	}

	public void setMeter(Meter meter) {
		this.meter = meter;
	}
	
}
