import java.util.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

/**
 * 
 * @author Mark Duncan, James Sanderlin, Avi Levy, Mudrekh Goderya
 * 
 * The Account_IO class handles input and output of the current state of the program to accounts.txt
 * 
 * @version 1.0
 *
 *
 *Format of an account in accounts.txt:
 *
 *isCommercial (0 or 1)
 *First Name (or just Company name)
 *Last Name
 *Account ID
 *Account Balance
 *Account Flagged
 *Deadline
 *Address Line 1
 *Address Line 2
 *City
 *State
 *Zip
 *end (delimiter)
 *
 *Comments Updated: 12/5/12 8:20pm
 */
public class Account_IO 
{	
	/**
	 * Reads in a text file with the correct formatting containing account information
	 * 
	 * @param fileinName
	 * @return a TreeMap of the accounts from the text file and associated data
	 * 
	 */
		public TreeMap<Integer, Account> read(String fileinName){
			File accountFile = new File(fileinName);
			TreeMap<Integer, Account> accountlist = new TreeMap<Integer, Account>();
			try
			{
				Scanner in = new Scanner(accountFile);
				//Parse the accounts file
				while(in.hasNext())
				{
					String companyName = "";
					String clientFirstName="";
					String clientLastName = "";
					String dateString = "";
					//Indicates if the account is commercial or residential
					boolean isCommercial = (in.nextInt() == 0) ? false : true; in.nextLine();

					if(isCommercial){
						companyName = in.nextLine();						
					}
					else
					{
						clientFirstName = in.nextLine();
						clientLastName = in.nextLine();
					}
					
					//Stores the unique account number of the account
					int accountId = Integer.parseInt(in.nextLine());
					//Stores the current balance of the account
					double balance = Double.parseDouble(in.nextLine());
					//Stores if there is a flag on the account or not
					boolean flag = (in.nextInt() == 0) ? false : true;
					in.nextLine();
					//Sets up the formatting of a date throughout the file
					DateFormat formatter = new SimpleDateFormat("MM/dd/yy h:mm a z");
					//Reads in the date as a string, to be converted into a date object
					dateString = in.nextLine();
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
					TreeMap<Date, Payment> paymentHist = new TreeMap<Date, Payment>();
					
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
						paymentHist.put(payDate, newPayment);
					}
					
					//Advances the writer past the end delimiter if necessary to get new info
					if(in.hasNext()){
						@SuppressWarnings("unused")
						String delimiter = in.nextLine();
					}
					
					if(isCommercial)
					{		
						CommercialAccount a = new CommercialAccount(companyName, accountId, balance, flag, deadline, addressParam);
						  				  a.setPaymentHistory(paymentHist);
						  				  accountlist.put(accountId, a);
					}
					else
					{
						ResidentialAccount b = new ResidentialAccount(clientFirstName, clientLastName, accountId, balance, flag, deadline, addressParam);
										   b.setPaymentHistory(paymentHist);
										   accountlist.put(accountId, b);
					}
					
				}
			}
			catch(FileNotFoundException e)
			{
                            //e.printStackTrace();
                            System.out.println("NO ACCOUNT FILE FOUND");
			}
			
			return accountlist;
		}
		
		/**
		 * Writes the account information to a text file for persisting and storing data
		 * through individual program executions
		 * 
		 * @param writefileName
		 * @param accountlist
		 */
		public static void write(String writefileName, Collection<Account> accountlist){
			//Formatter to format Date back to the correct format
			DateFormat formatter = new SimpleDateFormat("MM/dd/yy h:mm a z");
			try{
				
			FileWriter fstream = new FileWriter(writefileName);
			BufferedWriter out = new BufferedWriter(fstream);

				for(Account a : accountlist) 
				{	if(a.isCommercial()){
					CommercialAccount ca = (CommercialAccount)a;
					Date deadline = ca.getDeadline();					
					String deadlineString = formatter.format(deadline);
						
					out.write(
							ca.isCommercialToString()
							+"\n"+ca.getCompanyName()
							+"\n"+ca.getAccountID()
							+"\n"+ca.getBalance()
							+"\n"+ca.getFlagToString()
							+"\n"+deadlineString
							+"\n"+ca.getBillingAddress().toString()
							+"\n"
							);
					
				}
				else{
					ResidentialAccount ra = (ResidentialAccount)a;
					Date deadline = ra.getDeadline();
					String deadlineString = formatter.format(deadline);
					
					out.write(
							ra.isCommercialToString()
							+"\n"+ra.getClientFirstName() 
							+"\n"+ra.getClientLastName() 
							+"\n"+ra.getAccountID()
							+"\n"+ra.getBalance()
							+"\n"+ra.getFlagToString() 
							+"\n"+ deadlineString
							+"\n"+ra.getBillingAddress().toString() 
							+"\n"
							);
				}
					out.write("PAYMENTS:"+"\n");
                                        Collection<Payment> payments = a.getPaymentHistory().values();
					for (Payment p : payments){
						out.write(p.toString());					
					}
					out.write("end\n");
				}
					out.close();
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}	
}
