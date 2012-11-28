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
 * meterId
 * accountid
 * isdigital - 0 means not digital, 1 means digital 
 * rate
 * READINGS:
 * readingvalue
 * readingDate
 * reading_id (partial key)
 * (Note: the previous lines repeat several times)
 * end
 */
public class Meter_IO 
{
	private Meter_IO() {
	// Suppress default constructor for noninstantiability		
		throw new AssertionError();
	}
	public static void write(String fileOut, Collection<Account> accountlist){
		
	}
	public static TreeMap<Integer, Account> read(String fileIn){
		TreeMap<Integer, Account> generated = new TreeMap<Integer, Account>();
		File meterFile = new File(fileIn);
		try
		{
			Scanner in = new Scanner(meterFile);
			//Parse the meters file
			while(in.hasNext())
			{
				//Stores the type
				String clientFirstName = in.nextLine();
				String clientLastName = in.nextLine();

				//Stores the unique account number of the account
				int accountId = Integer.parseInt(in.nextLine());
				//Stores the current balance of the account
				double balance = Double.parseDouble(in.nextLine());
				//Stores if there is a flag on the account or not
				boolean flag = (in.nextInt() == 0) ? false : true;
				//Indicates if the account is commercial or residential
				boolean isCommercial = (in.nextInt() == 0) ? false : true; in.nextLine();
				
				//Sets up the formatting of a date throughout the file
				DateFormat formatter = new SimpleDateFormat("MM/dd/yy h:mm a z");
				
				//Reads in the date as a string, to be converted into a date object
				String dateString = in.nextLine();
				Date deadline = new Date();
				try {
					deadline = (Date)formatter.parse(dateString);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				//Gets the first line of the address and stores it in String l1
				String l1 = in.nextLine();
				//Holds the second line of the address and stores it in String l2
				String l2 = in.nextLine();
				//Holds the string for the city
				String city = in.nextLine();
				//Holds the string for the state
				String state = in.nextLine();
				//Holds the string for the zipcode
				String zip = in.nextLine();
				
				//Creates address object and stores its info for storing into the account object
				Address addressParam = new Address(l1,l2,city,state,zip);
				
				//Variables for storing data from file for the payment object
				double amount = 0.0;
				String paymentType = "";
				String paymentDate ="";
				ArrayList<Payment> paymentHist = new ArrayList<Payment>();
				
				//Advances the writer past the "Payments:" delimiter. (We may decide to remove this altogether)
				@SuppressWarnings("unused")
				String paymentsDelimiter = in.nextLine();
				
				while(!in.hasNext("end"))
				{
					amount = Double.parseDouble(in.nextLine());
					paymentType = in.nextLine();
					paymentDate = in.nextLine();
					
					//Creates a date object and parses the string paymentDate from the file
					Date payDate = new Date();
					try {
						payDate = (Date)formatter.parse(paymentDate);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//Creates the payment object to be stored in the account object's paymentHistory list
					Payment newPayment = new Payment(amount,paymentType,payDate);
					paymentHist.add(newPayment);
				}
				
				//Advances the writer past the end delimiter if necessary to get new info
				if(in.hasNext()){
					@SuppressWarnings("unused")
					String delimiter = in.nextLine();
				}
				
				//Change this to writing to the accounts reference object, not the console
				if(isCommercial)
				{		
					CommercialAccount a = new CommercialAccount(clientFirstName, clientLastName, accountId, balance, flag, deadline, addressParam);
					  				  a.paymentHistory = paymentHist;
					  				  //accountlist.add(a);
					  				  generated.put(accountId, a);
				}
				else
				{
					//*TODO* We are need to redo the structure here for residential and commercial account names. Right now we read everything as a name but
					//it also needs to delineate between a company name and a name. They aren't separated right now.
					ResidentialAccount b = new ResidentialAccount(clientFirstName, clientLastName, accountId, balance, flag, deadline, addressParam);
									   b.paymentHistory = paymentHist;
									   generated.put(accountId, b);
				}
				
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return generated;
	}
}
