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
 *isCommercial
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
 *
 */
public class Account_IO 
{	
	//This method writes the account information from the accounts file to a list of accounts by reference
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
					
					if(isCommercial)
					{		
						CommercialAccount a = new CommercialAccount(companyName, accountId, balance, flag, deadline, addressParam);
						  				  a.paymentHistory = paymentHist;
						  				  accountlist.put(accountId, a);
					}
					else
					{
						ResidentialAccount b = new ResidentialAccount(clientFirstName, clientLastName, accountId, balance, flag, deadline, addressParam);
										   b.paymentHistory = paymentHist;
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
		
		//This method persists the account information from a list by reference to a file for reading in later
		public static void write(String writefileName, Collection<Account> accountlist){
			try{
				
			FileWriter fstream = new FileWriter(writefileName);
			BufferedWriter out = new BufferedWriter(fstream);

				for(Account a : accountlist) 
				{	if(a.isCommercial()){
					CommercialAccount ca = (CommercialAccount)a;
					//Format Date back to the correct format
					DateFormat formatter = new SimpleDateFormat("MM/dd/yy h:mm a z");
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
					
					//Format Date back to the correct format
					DateFormat formatter = new SimpleDateFormat("MM/dd/yy h:mm a z");
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
					for (int i = 0; i<a.paymentHistory.size();i++){
						out.write(a.paymentHistory.get(i).toString());					
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
