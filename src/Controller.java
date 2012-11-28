import java.util.*;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class Controller 
{
	//TreeMap of the accounts
	private TreeMap<Integer, Account> accounts = new TreeMap<Integer, Account>();
	//TreeMap of the meters
	private TreeMap<Integer, Meter> meters = new TreeMap<Integer, Meter>();
	private Meter_IO dataMeter;
    private Account_IO dataAccount;
	//Singleton instance of the Controller. 
	private static final Controller instance = new Controller();
	/**
	 * Private constructor to maintain singleton copy 
	 */
    private Controller() {
    	dataAccount = new Account_IO();
		dataMeter = new Meter_IO();
		accounts = dataAccount.accountIn();
		UserInterface ui = new UserInterface();
    }
 
    /**
     * Method to return the singleton copy of the controller
     * 
     * @return The singleton controller
     */
    public static Controller getInstance() {
        return instance;
    }
    
    
    /**
     * Main class to drive the program.
     * 
     * @param args
     */
	public static void main(String[] args)
	{
		
	}
	
	/**
	 * Creates an account with the specified fields
	 * 
	 * @param clientFirstName 	First name of the client
	 * @param clientLastName	Last name of the client
	 * @param accountID	The ID of the account
	 * @param balance	The current balance of the account
	 * @param flag	The current flag of the account
	 * @param deadline	The deadline for the next payment
	 * @param billingAddress	The billing address of the account
	 * @param commercial	Boolean indicating whether the account is commercial
	 * @return	 True if the new account was added. 
	 */
	public boolean createAccount(String clientFirstName, String clientLastName, int accountID, double balance, boolean flag, Date deadline, Address billingAddress, boolean commercial)
	{
		if(accounts.containsKey(accountID))
			return false;
		else if(commercial)
		{
			accounts.put(accountID, new CommercialAccount(clientFirstName, clientLastName, accountID, balance, flag, deadline, billingAddress));
			return true;
		}
		else
		{
			accounts.put(accountID, new ResidentialAccount(clientFirstName, clientLastName, accountID, balance, flag, deadline, billingAddress));
			return true;
		}
		
	}
	
	/**
	 * Returns the deleted account or null if the account was not found.
	 * 
	 * @param accountID The Account to be deleted.
	 * @return The deleted account. 
	 */
	public Account deleteAccount(int accountID)
	{
		return accounts.remove(accountID);
	}
	
	/**
	 * Returns the account with the specified accountID. Returns null if the account was not found.
	 * 
	 * @param accountID The ID of the account to find. 
	 * @return The account with the specified ID
	 */
	public Account getAccount(int accountID)
	{
		if(accounts.containsKey(accountID))
			return accounts.get(accountID);
		else
			return null;
	}
	
	/**
	 * Convenience method to add accounts to the program controller. Returns true if the account was added. 
	 * 
	 * @param account The account to add
	 * @return A boolean indicating whether the add was successful
	 */
	public boolean addAccount(Account account)
	{
		int accountID = account.getAccountID();
		if(accounts.containsKey(accountID))
			return false;
		else
			accounts.put(accountID, account);
		return true;
	}
	
	/**
	 * Returns whether the specifed account is in the account of not.
	 * 
	 * @param accountID The ID to search for
	 * @return The account with the specified ID
	 */
	public boolean hasAccountID(int accountID)
	{
		return accounts.containsKey(accountID);
	}
	
	/**
	 * Creates a new meter in the hash map. Returns true if the meter was added. Returns false if there is a meter with the current ID
	 * 
	 * @param meterID The ID of the meter to be created. 
	 * @param type A string denoting the type of the meter. 
	 * @return A boolean indicating whether the meter was created or not. 
	 */
	public boolean createMeter(int meterID, String type)
	{
		if(!meters.containsKey(meterID))
		{
			meters.put(meterID, new Meter(meterID, type));
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Deletes the meter with the specified ID. 
	 * 
	 * @param meterID The meter to delete
	 * @return The deleted meter
	 */
	public Meter deleteMeter(int meterID)
	{
		return meters.remove(meterID);
	}
	
	/**
	 * Return true if the controller already has a meter with that ID
	 * 
	 * @param meterID The meter to check for.
	 * @return A boolean indicating whether the meter was found. 
	 */
	public boolean hasMeterID(int meterID)
	{
		return meters.containsKey(meterID);
	}
	
	/**
	 * Returns the meter with the specified ID. The meter was not found the method returns null;
	 * 
	 * @param meterID The ID of the meter to be returned 
	 * @return The meter with the specified ID;
	 */
	public Meter getMeter(int meterID)
	{
		return meters.get(meterID);
	}
	
	/**
	 * Convenience method to add a meter to the list. To be used for input and output. 
	 * 
	 * @param meter The meter to be added.
	 * @return Whether the meter could be added. 
	 */
	public boolean addMeter(Meter meter)
	{
		int meterID = meter.getMeterID();
		if(meters.containsKey(meterID))
		{
			return false;
		}
		else
			meters.put(meterID, meter);
		return true;
	}
	
	/**
	 * Returns an unmodifiable version of the meters
	 * 
	 * @return
	 */
	public Collection<Meter> getMeterCollection()
	{
		return Collections.unmodifiableCollection(meters.values());
	}
	
	/**
	 * Returns an unmodifiable version of the accounts
	 * 
	 * @return
	 */
	public Collection<Account> getAccountCollection()
	{
		return Collections.unmodifiableCollection(accounts.values());
	}

	public TreeMap<Integer, Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(TreeMap<Integer, Account> accounts) {
		this.accounts = accounts;
	}

	public TreeMap<Integer, Meter> getMeters() {
		return meters;
	}

	public void setMeters(TreeMap<Integer, Meter> meters) {
		this.meters = meters;
	}
	

	
	//Save to file

}


