/**
 * 
 * @author Mark Duncan
 *
 *Description
 *
 *@version 1.0
 *
 */
public class Address {
	
	//Describes the first (and primary) line of the address
	private String location1;
	//Describes the second (optional) line of the address, for suites, apartment numbers, etc...
	private String location2;
	//Stores the city of the serviced address
	private String city;
	//Stores the zip code of the serviced address
	private String zip;
	//Stores the state of the serviced address
	private String state;
	
	public String getLocation1() {
		return location1;
	}
	public void setLocation1(String location1) {
		this.location1 = location1;
	}
	public String getLocation2() {
		return location2;
	}
	public void setLocation2(String location2) {
		this.location2 = location2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
