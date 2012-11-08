import java.util.*;
import java.io.*;

/**
 * 
 * @author Mudrekh Goderya, James Sanderlin
 * 
 * The Account_IO class handles input and output of the current state of the program to accounts.txt
 * 
 * @
 *
 */
public class Account_IO 
{
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
}	
