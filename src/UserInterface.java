import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class UserInterface
	{

		public JList accountJList;
		public JList meterJList;
		final JFrame mainFrame;
		public UserInterface()
		{	
			mainFrame = new JFrame();
			mainFrame.setSize(1000, 500);
			//mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			JMenuBar menuBar = new JMenuBar();
			menuBar.add(new JMenuItem("File"));
			mainFrame.setJMenuBar(menuBar);
			

			accountJList = new JList();
			meterJList = new JList();
			
			JScrollPane accountScrollPane = new JScrollPane(accountJList);
			accountScrollPane.setPreferredSize(new Dimension(200, 100));
			JScrollPane meterScrollPane = new JScrollPane(meterJList);
			meterScrollPane.setPreferredSize(new Dimension(200, 100));
			
			
			JPanel input = new JPanel();
			JButton addMeter = new JButton("Enter Meter Information");
			JButton addAccount = new JButton("New Residential Account");
			JButton addReading = new JButton("Enter a Meter Reading");
			JButton save = new JButton("Save");
			
			save.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){	
					Account_IO.AccountOut(Controller.getInstance().getAccountCollection());
				}
			});
					
			addMeter.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){	
					
					
					JTextField meterIDField = new JTextField(5);
				    JTextField meterTypeField = new JTextField(12);
				    Object[] options = {"SAVE", "CANCEL"};

				      JPanel myPanel = new JPanel();
				      myPanel.add(new JLabel("Meter ID"));
				      myPanel.add(meterIDField);
				      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
				      myPanel.add(new JLabel("Meter Type"));
				      myPanel.add(meterTypeField);
				      

				      int result = JOptionPane.showOptionDialog(null, myPanel, 
				               "Enter information for a meter", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				      if (result == 0) 
				      {
				    	  Meter temp = new Meter(Integer.parseInt(meterIDField.getText()), meterTypeField.getText());
				    	  Controller.getInstance().addMeter(temp);
				    	  refreshMeterJList();
				      }
				}
			});
			
			addAccount.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){	
					JTextField firstNameField = new JTextField(10);
				    JTextField lastNameField = new JTextField(10);
				    JTextField accountIDField = new JTextField(10);
				    JTextField line1Field = new JTextField(10);
				    JTextField line2Field = new JTextField(10);
				    JTextField cityField = new JTextField(10);
				    JTextField stateField = new JTextField(10);
				    JTextField zipField = new JTextField(5);
				    
				    Object[] options = {"SAVE", "CANCEL"};

				      JPanel myPanel = new JPanel();
				      myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
				      JPanel namePanel = new JPanel();
				      namePanel.add(new JLabel("First Name"));
				      namePanel.add(firstNameField);
				      namePanel.add(Box.createHorizontalStrut(15));
				      namePanel.add(new JLabel("Last Name"));
				      namePanel.add(lastNameField);
				      myPanel.add(namePanel);
				      JPanel accountIdPanel = new JPanel();
				      accountIdPanel.add(new JLabel("Account ID"));
				      accountIdPanel.add(accountIDField);
				      accountIdPanel.add(Box.createHorizontalStrut(230));
				      myPanel.add(accountIdPanel);
				      JPanel addressPanel = new JPanel();
				      addressPanel.add(new JLabel("Address Line 1"));
				      addressPanel.add(line1Field);
				      addressPanel.add(Box.createHorizontalStrut(15));
				      addressPanel.add(new JLabel("Address Line 2"));
				      addressPanel.add(line2Field);
				      myPanel.add(addressPanel);
				      JPanel cszPanel = new JPanel();
				      cszPanel.add(new JLabel("City"));
				      cszPanel.add(cityField);
				      cszPanel.add(Box.createHorizontalStrut(15));
				      cszPanel.add(new JLabel("State"));
				      cszPanel.add(stateField);
				      cszPanel.add(Box.createHorizontalStrut(15));
				      cszPanel.add(new JLabel("Zip"));
				      cszPanel.add(zipField);
				      myPanel.add(cszPanel);

				      int result = JOptionPane.showOptionDialog(null, myPanel, 
				               "Enter information for the new residential account", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				      if (result == 0) 
				      {
				    	 if(line2Field.getText().isEmpty())
				    	 {
				    		 line2Field.setText("NULL");
				    	 }
				    	 Account temp = new ResidentialAccount(firstNameField.getText(), 
				    			 								lastNameField.getText(), 
				    			 								Integer.parseInt(accountIDField.getText()), 0, false,
				    			 								new Date(), 
				    			 								new Address(line1Field.getText(), line2Field.getText(), cityField.getText(), zipField.getText(), stateField.getText()));
					    	 Controller.getInstance().addAccount(temp);
					    	 /* TODO Error checking for duplicate accounts */
					    	 refreshAccountJList();
				         System.out.println("saved!");
				      }
				}
			});	
			
			addReading.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){	
					JTextField meterIdField = new JTextField(10);
					JTextField readingField = new JTextField(10);
					Object[] options = {"SAVE", "CANCEL"};
					JPanel myPanel = new JPanel();
					myPanel.add(new JLabel("Meter ID"));
					myPanel.add(meterIdField);
					myPanel.add(Box.createHorizontalStrut(15));
					myPanel.add(new JLabel("Reading Amount"));
					myPanel.add(readingField);
					int result = JOptionPane.showOptionDialog(null, myPanel, 
				               "Enter amount for a meter reading", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
					
					if(result == 0)
					{
						Meter_Reading r = new Meter_Reading(Integer.parseInt(readingField.getText()), new Date());
						Controller.getInstance().getMeter(Integer.parseInt(meterIdField.getText())).addReading(r);
					}
				}
			});
			
			input.add(addMeter);
			input.add(addAccount);
			input.add(addReading);
			input.add(save);
			mainFrame.add(accountScrollPane, BorderLayout.WEST);
			mainFrame.add(input, BorderLayout.NORTH);
			mainFrame.add(meterScrollPane, BorderLayout.EAST);
			
			mainFrame.setVisible(true);
		}
		
		public void refreshAccountJList() {
			//System.out.println(Arrays.toString((Controller.getInstance().accounts.toArray()));
			accountJList.setListData(Controller.getInstance().getAccountCollection().toArray());
			//mainFrame.repaint();
			
		}
		
		public void refreshMeterJList() {
			//System.out.println(Arrays.toString(Controller.getInstance().accounts.toArray()));
			meterJList.setListData(Controller.getInstance().getMeterCollection().toArray());
			//mainFrame.repaint();
			
		}
}