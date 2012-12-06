/**
 * 
 * @author Mark Duncan, Avi Levy
 *
 * This class stores the tax name and tax percentage to be used in the bill calculation, and is
 * associated with a service location since this tax is assumed to be location based.
 *
 *@version 1.0
 *
 *Comments Updated: 12/5/12 8:30pm
 */
public class Taxes {

	//Describes the rate of the tax being applied to the service location
	private double rate;
	//Describes the name of the tax linked to the respective rate
	private String name;
	
	/**
	 * Default Constructor
	 * 
	 * @param name
	 * @param rate
	 */
	public Taxes(String name, double rate) {
		this.rate = rate;
		this.name = name;
	}
	
	/*
	 * Basic Getters and Setters
	 */
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}