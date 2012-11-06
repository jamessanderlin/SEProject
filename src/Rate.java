/**
 * 
 * @author Mark Duncan, Mudrekh Goderya
 *
 *The rate class maintains the data associated with a electricity rate for
 *the meter class.
 *
 * @version 1.0
 *
 */
public class Rate {
	
	//The unique ID associated with a rate. Used to tie meter objects to rates.
	private int ID;
	
	//The rate in USD per kWh
	private double rate;
	
	//Describes the property of this rate, for example it could include the name of the rate
	//such as commercial or residential
	private String type;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
