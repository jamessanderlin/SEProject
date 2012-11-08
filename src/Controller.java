import java.util.*;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class Controller 
{
	private ArrayList<Account> accounts = new ArrayList<Account>();
	private ArrayList<Meter> meters = new ArrayList<Meter>();
	
	private static final Controller instance = new Controller();
	 
    private Controller() {}
 
    public static Controller getInstance() {
        return instance;
    }
    
    protected Meter_IO dataMeter;
    protected Account_IO dataAccount;
    
	public static void main(String[] args)
	{
		Controller.getInstance().dataAccount = new Account_IO();
		Controller.getInstance().dataMeter = new Meter_IO();
		UserInterface ui = new UserInterface();
	}
	
	public static void createAccount()
	{
		/*TODO write createAccount() method */
	}	
	public static void deleteAccount()
	{
		/*TODO write deleteAccount() method */
	}
	//Save to file

}


