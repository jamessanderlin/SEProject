import java.util.*;
import java.io.*;

/**
 * 
 * @author James Sanderlin, Mark Duncan, Avi Levi, Mudrekh Goderya
 * 
 * The Account_IO class handles input and output of the current state of the program to accounts.txt
 * 
 * @
 *
 */
public class Account_IO 
{
	//This method reads data stored from a text file and creates the account objects again
	public Account_IO()
	{
		File accountFile = new File("accounts.txt");
		
		try
		{
			Scanner in = new Scanner(accountFile);
			//Parse the accounts file
			while(in.hasNext())
			{
				String clientFirstName = in.next();
				//System.out.println(clientFirstName)
				String clientLastName = in.nextLine();
				//System.out.println(clientLastName)

				int accountId = Integer.parseInt(in.nextLine());
				//System.out.println(accountId);
				double balance = Double.parseDouble(in.nextLine());
				//System.out.println(balance);
				boolean flag = (in.nextInt() == 0) ? false : true;
				//System.out.println(flag);
				boolean isCommercial = (in.nextInt() == 0) ? false : true;
				in.nextLine();
				String dateString = in.nextLine();
				/*TODO Convert dateString into Date (or Calendar?) object */
				Date deadline = new Date();
				String l1=in.nextLine();
				String l2 = "";
				
				//*TODO* Add functionality for line 2 later...
				/*if(foo.equals("LINE 2"))
				{
					l2 = in.nextLine();
				}*/
				
				String city = in.nextLine();
				String state = in.nextLine();
				String zip = in.nextLine();
				Address addressdummy = new Address(l1,l2,city,state,zip);
	
				//Read Payments until you see a blank line.
				String line = in.nextLine();
				while(!line.equals(""))
				{
					/*TODO Read in and create the payment objects */
					//System.out.println("Line " + line);
					line = in.nextLine();
				}
				
				if(isCommercial)
				{
					CommercialAccount a = new CommercialAccount(clientFirstName, clientLastName, accountId, balance, flag, deadline, addressdummy);

					System.out.println("COMMERCIAL ACCOUNT INFO:");
					System.out.println(a.clientFirstName);
					System.out.println(a.clientLastName);
					System.out.println(a.accountID);
					System.out.println(a.balance);
					System.out.println(a.flag);
					System.out.println(a.deadline);
					System.out.println(addressdummy.toString());
					System.out.println("END COMMERCIAL INFO");
				}
				else
				{
					//*TODO* We are need to redo the structure here for residential and commercial account names. Right now we read everything as a name but
					//it also needs to delineate between a company name and a name. They aren't separated right now.
					ResidentialAccount a = new ResidentialAccount(clientFirstName, clientLastName, accountId, balance, flag, deadline, addressdummy);
					System.out.println("RESIDENTIAL ACCOUNT INFO:");
					System.out.println(a.clientFirstName);
					System.out.println(a.clientLastName);
					System.out.println(a.accountID);
					System.out.println(a.balance);
					System.out.println(a.flag);
					System.out.println(a.deadline);
					System.out.println(addressdummy.toString());	
					System.out.println("END RESIDENTIAL INFO");
				}
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	//This method writes the account information from the console out to a file for persisting
	public static void AccountOut(ArrayList<Account> accountlist){
		try{
		
		FileWriter fstream = new FileWriter("accounts.txt");
		BufferedWriter out = new BufferedWriter(fstream);

			for(Account a : accountlist) 
			{
				out.write("Account Info:"+"\n");
				out.write(a.getClientFirstName() +"\n" + a.getClientLastName() 
												 +"\n"+a.accountID
												 +"\n"+a.balance
												 +"\n"+a.flag
												 +"\n"+a.deadline
												 +"\n"+a.billingAddress.getLocation1()
												 +"\n"+a.billingAddress.getLocation2()
												 +"\n"+a.billingAddress.getCity()
												 +"\n"+a.billingAddress.getState()
												 +"\n"+a.billingAddress.getZip()
						);
			}
				out.close();
		}
		
		//*TODO* Add exception here...
		catch (Exception e)
		{
		
		}
	}	
	
	
	//This method writes the account information from the accounts file to the account list by reference
		public static void AccountIn(ArrayList<Account> accountlist){
			File accountFile = new File("accounts.txt");
			
			try
			{
				Scanner in = new Scanner(accountFile);
				//Parse the accounts file
				while(in.hasNext())
				{
					String clientFirstName = in.next();
					//System.out.println(clientFirstName)
					String clientLastName = in.nextLine();
					//System.out.println(clientLastName)

					int accountId = Integer.parseInt(in.nextLine());
					//System.out.println(accountId);
					double balance = Double.parseDouble(in.nextLine());
					//System.out.println(balance);
					boolean flag = (in.nextInt() == 0) ? false : true;
					//System.out.println(flag);
					boolean isCommercial = (in.nextInt() == 0) ? false : true;
					in.nextLine();
					String dateString = in.nextLine();
					/*TODO Convert dateString into Date (or Calendar?) object */
					Date deadline = new Date();
					String l1=in.nextLine();
					String l2 = "";
					
					//*TODO* Add functionality for line 2 later...
					/*if(foo.equals("LINE 2"))
					{
						l2 = in.nextLine();
					}*/
					
					String city = in.nextLine();
					String state = in.nextLine();
					String zip = in.nextLine();
					Address addressdummy = new Address(l1,l2,city,state,zip);
		
					//Read Payments until you see a blank line.
					String line = in.nextLine();
					while(!line.equals(""))
					{
						/*TODO Read in and create the payment objects */
						//System.out.println("Line " + line);
						line = in.nextLine();
					}
					
					if(isCommercial)
					{
						CommercialAccount a = new CommercialAccount(clientFirstName, clientLastName, accountId, balance, flag, deadline, addressdummy);

						System.out.println("COMMERCIAL ACCOUNT INFO:");
						System.out.println(a.clientFirstName);
						System.out.println(a.clientLastName);
						System.out.println(a.accountID);
						System.out.println(a.balance);
						System.out.println(a.flag);
						System.out.println(a.deadline);
						System.out.println(addressdummy.toString());
						System.out.println("END COMMERCIAL INFO");
					}
					else
					{
						//*TODO* We are need to redo the structure here for residential and commercial account names. Right now we read everything as a name but
						//it also needs to delineate between a company name and a name. They aren't separated right now.
						ResidentialAccount a = new ResidentialAccount(clientFirstName, clientLastName, accountId, balance, flag, deadline, addressdummy);
						System.out.println("RESIDENTIAL ACCOUNT INFO:");
						System.out.println(a.clientFirstName);
						System.out.println(a.clientLastName);
						System.out.println(a.accountID);
						System.out.println(a.balance);
						System.out.println(a.flag);
						System.out.println(a.deadline);
						System.out.println(addressdummy.toString());	
						System.out.println("END RESIDENTIAL INFO");
					}
				}
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
		}
}
