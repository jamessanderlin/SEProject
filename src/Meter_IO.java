import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

/**
 * This is a utility/boundary class for handling
 * serialization and deserialization of Meters.
 *  
 * Format of meters.txt file:
 * 
 * accountid
 * meterId
 * 
 * isdigital - 0 means not digital, 1 means digital 
 * rate - the double that represents the cost per kilowatt
 * address - this is stored over 5 lines
 * READINGS:
 * readingvalue
 * readingDate
 * (Note: the previous lines repeat several times)
 * END READINGS
 * TAXES:
 * taxName
 * taxRate
 * END TAXES
 */
public class Meter_IO 
{
	private static DateFormat formatter = new SimpleDateFormat("MM/dd/yy h:mm a z");
	private Meter_IO() {
	// Suppress default constructor for noninstantiability		
		throw new AssertionError();
	}
	
	/**
	 * This method reads an input file to populate all the Meter-related information
	 * The current accounts data is passed in as well. When a Meter object has been
	 * built, it is passed in to the account it references. There is no return value.
	 * 
	 * TODO: This is currently a no-op because Account does not support storing a
	 * Meter to it yet. Uncomment Line 96 of this file when implemented
	 * 
	 * @param fileIn The name of the input file to deserialize from
	 * @param accountsReference The accounts data we reference
	 * 
	 */
	public static TreeMap<Integer, Meter> read(String fileIn, TreeMap<Integer, Account> accountsReference){
		TreeMap<Integer, Meter> meters = new TreeMap<Integer, Meter>();
		File meterFile = new File(fileIn);
		try
		{
			Scanner in = new Scanner(meterFile);
			//Parse the meters file
			int meterID, accountID;
			
			boolean isDigital;
			
			//Variables for storing data from file for the meterReading object
			int readingValue;
			Date readingDate = new Date();

			//Sets up the formatting of a date throughout the file
			DateFormat formatter = new SimpleDateFormat("MM/dd/yy h:mm a z");			

			//The list of meter readings that we build and pass to the meter object on the fly
			Meter meter;

			while(in.hasNext())
			{
				//Stores the unique meterID of the meter
				accountID = Integer.parseInt(in.nextLine());
				meterID = Integer.parseInt(in.nextLine());

				isDigital = (in.nextInt() == 0) ? false : true;
				in.nextLine();
				
				//Parses the address and generates the meter in one step
				meter = new Meter(meterID, (isDigital) ? "Digital" : "Analog", Double.parseDouble(in.nextLine()), new Address( in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine()));
				
				//Advances the writer past the "READINGS:" delimiter.
				in.nextLine();
				
				while(!in.hasNext("ENDREADINGS"))
				{
					readingValue = Integer.parseInt(in.nextLine());
					try {
						readingDate = (Date)formatter.parse(in.nextLine());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					//Append to Meter
					meter.addReading(new Meter_Reading(readingValue, readingDate));					
				}
				//Advances the writer past the "TAXES:" delimiter.
				in.nextLine();
				in.nextLine();
				
				while(!in.hasNext("ENDTAXES"))
				//while(!in.nextLine().equals("ENDTAXES"))
				{
					//Parse the tax from its name and rate; add it to the meter
					meter.addTax(new Taxes(in.nextLine(),Double.parseDouble(in.nextLine())));
				}				
				
				meters.put(meterID, meter);
				accountsReference.get(accountID).addMeter(meter);
				
				/* This is not implemented yet in Accounts
				 * 
				 * accountsReference.get(accountID).addMeter(meter);
				 */
				
				//Advances the writer past the end delimiter if necessary to get new info
				if(in.hasNext()){
					in.nextLine();
				}
				
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return meters;
	}

	public static void writeMeter(BufferedWriter out, Meter m) throws IOException {
		out.write(m.getMeterID()+"\n" + (m.getIsDigital() ? 1 : 0) + "\n" + m.getMeterRate() + "\n"
				 +m.getPhysicalAddress().getLocation1()
				 +"\n"+m.getPhysicalAddress().getLocation2()
				 +"\n"+m.getPhysicalAddress().getCity()
				 +"\n"+m.getPhysicalAddress().getState()
				 +"\n"+m.getPhysicalAddress().getZip()+"\n");

		out.write("READINGS:\n");
		for(Date d : m.getReadings().keySet()) {
			out.write(m.getReadings().get(d).getReading()+"\n" + formatter.format(d) + "\n");
		}
		out.write("ENDREADINGS\n");
		out.write("TAXES:\n");
		for(String s : m.getTaxes().keySet()) {
			out.write(s+"\n" + m.getTaxes().get(s).getRate() + "\n");
		}
		out.write("ENDTAXES\n");		
	}
	
	/**
	 * This method writes current meter data to an output file to save all of the data related to the meters
	 * There is no return value.
	 * 
	 * 
	 * @param fileIn The name of the input file to deserialize from
	 * @param accountsReference The accounts data we reference
	 * 
	 */
	public static void write(String writeFileName, Collection<Account> accountList){
		try{
			FileWriter fstream = new FileWriter(writeFileName);
			BufferedWriter out = new BufferedWriter(fstream);
	
			for(Account a : accountList) 
			{
				if(a.isCommercial()){
					CommercialAccount ca = (CommercialAccount)a;
	
					for(Meter m : ca.getMeters()) {
						if(m != null) {
						out.write(a.getAccountID()+"\n");
						writeMeter(out, m);
						}
					}
				} else {
					ResidentialAccount ra = (ResidentialAccount)a;
					if(ra.getMeter() != null) {
					out.write(a.getAccountID()+"\n");
					writeMeter(out, ra.getMeter());
					}
				}
			}
			out.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}	
}
