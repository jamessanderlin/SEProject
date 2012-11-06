/**
 * 
 * @author Mark Duncan, Mudrekh Goderya
 * 
 * Description
 * 
 * @version 1.0
 *
 */
public class Service_Location {
	
	private int ID;
	
	/*
	 * @TODO Make address into a separate class with strings for city, zip, state
	 */
	private String address;
	
	//Describes if the location is residential or commercial
	private String type; 

	//Boolean for if the location is taxable or not, for example in the case of non-profits
	private boolean taxable;
	
	/*
	 * @TODO Create the Taxes class
	 */
	//Contains a list of taxes applied to this location
	private ArrayList<Taxes> taxes;
	
	//The meter installed at the service location
	private Meter meter;
}
