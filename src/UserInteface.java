import java.awt.*;
import javax.swing.*;
import java.util.*;

public class UserInteface
{

	public static void main(String[] args) 
	{
		
		final JFrame mainFrame = new JFrame();
		mainFrame.setSize(1000, 1000);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(new JMenuItem("File"));
		mainFrame.setJMenuBar(menuBar);
		
		String acc[] = new String[2];
		acc[0] = "Mark Duncan";
		acc[1] = "Avi Levy";
		JList accounts = new JList(acc);
		JScrollPane accountScrollPane = new JScrollPane(accounts);
		JPanel input = new JPanel();
		mainFrame.add(accounts, BorderLayout.WEST);
		mainFrame.add(input, BorderLayout.EAST);
		
		
		mainFrame.setVisible(true);
	}

}
