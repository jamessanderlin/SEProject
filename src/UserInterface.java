/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.*;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * UserInterface is the main class for handling user input.
 * 
 * @author Mudrekh Goderya, James Sanderlin
 */
public class UserInterface extends javax.swing.JFrame {

    //The table models for the JTables displayed in the UserInterface
    MapTableModel accountTableModel;
    MeterTableModel meterTableModel;
    
    //Constant ints for easy of identifying arguments;
    public static final int RESIDENTIAL = 0;
    public static final int COMMERCIAL = 1;
    
    /**
     * Creates new form UserInterfacePrototype
     */
    public UserInterface() {
        //Instantiation of the table models
        accountTableModel = new MapTableModel(Controller.getInstance().getAccounts(), "Account ID", "Account Name");
        meterTableModel = new MeterTableModel(Controller.getInstance().getMeters(), "Meter ID");
        
        initComponents();
        
        //Window listener to force saving on exit.
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    Controller.getInstance().save();
                    System.exit(0);
                }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        accountPopup = new javax.swing.JPopupMenu();
        viewAccount = new javax.swing.JMenuItem();
        editAccount = new javax.swing.JMenuItem();
        deleteAccountPopup = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        viewMeters = new javax.swing.JMenuItem();
        addMeterToAccount = new javax.swing.JMenuItem();
        meterScrollPane = new javax.swing.JScrollPane();
        meterTable = new javax.swing.JTable();
        meterViewDialog = new javax.swing.JDialog();
        meterViewSrollPane = new javax.swing.JScrollPane();
        meterViewTable = new javax.swing.JTable();
        accountScrollPane = new javax.swing.JScrollPane();
        accountTable = new javax.swing.JTable();
        menuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        save = new javax.swing.JMenuItem();
        menuEdit = new javax.swing.JMenu();
        addResidentialAccount = new javax.swing.JMenuItem();
        addCommercialAccount = new javax.swing.JMenuItem();
        deleteAccount = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        addMeter = new javax.swing.JMenuItem();
        deleteMeter = new javax.swing.JMenuItem();

        viewAccount.setText("View Account");
        viewAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAccountActionPerformed(evt);
            }
        });
        accountPopup.add(viewAccount);

        editAccount.setText("Edit Account");
        editAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editAccountActionPerformed(evt);
            }
        });
        accountPopup.add(editAccount);

        deleteAccountPopup.setText("Delete Account");
        deleteAccountPopup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAccountPopupActionPerformed(evt);
            }
        });
        accountPopup.add(deleteAccountPopup);
        accountPopup.add(jSeparator2);

        viewMeters.setText("View Meters");
        viewMeters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewMetersActionPerformed(evt);
            }
        });
        accountPopup.add(viewMeters);

        addMeterToAccount.setText("Add Meter To Account");
        addMeterToAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMeterToAccountActionPerformed(evt);
            }
        });
        accountPopup.add(addMeterToAccount);

        meterTable.setModel(meterTableModel);
        meterTable.setDefaultRenderer(Integer.class, new LeftCellRenderer());
        meterScrollPane.setViewportView(meterTable);

        meterViewDialog.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        meterViewTable.setModel(new MeterViewTableModel());
        meterViewSrollPane.setViewportView(meterViewTable);

        javax.swing.GroupLayout meterViewDialogLayout = new javax.swing.GroupLayout(meterViewDialog.getContentPane());
        meterViewDialog.getContentPane().setLayout(meterViewDialogLayout);
        meterViewDialogLayout.setHorizontalGroup(
            meterViewDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(meterViewDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(meterViewSrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addContainerGap())
        );
        meterViewDialogLayout.setVerticalGroup(
            meterViewDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(meterViewDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(meterViewSrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Utility Billing Program");

        accountTable.setModel(accountTableModel);
        accountTable.setDefaultRenderer(Account.class, new LeftCellRenderer());
        accountTable.setDefaultRenderer(Integer.class, new LeftCellRenderer());
        accountTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                accountTableMouseReleased(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                accountTableMousePressed(evt);
            }
        });
        accountScrollPane.setViewportView(accountTable);

        menuFile.setText("File");

        save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        menuFile.add(save);

        menuBar.add(menuFile);

        menuEdit.setText("Edit");

        addResidentialAccount.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        addResidentialAccount.setText("Add Residential Account");
        addResidentialAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addResidentialAccountActionPerformed(evt);
            }
        });
        menuEdit.add(addResidentialAccount);

        addCommercialAccount.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        addCommercialAccount.setText("Add Commercial Account");
        addCommercialAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCommercialAccountActionPerformed(evt);
            }
        });
        menuEdit.add(addCommercialAccount);

        deleteAccount.setText("Delete Account");
        deleteAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteAccountActionPerformed(evt);
            }
        });
        menuEdit.add(deleteAccount);
        menuEdit.add(jSeparator1);

        addMeter.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        addMeter.setText("Add Meter");
        addMeter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMeterActionPerformed(evt);
            }
        });
        menuEdit.add(addMeter);

        deleteMeter.setText("Delete Meter");
        deleteMeter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMeterActionPerformed(evt);
            }
        });
        menuEdit.add(deleteMeter);

        menuBar.add(menuEdit);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(accountScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 871, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(accountScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Action to handle adding a new Residential Account to the program.
     * 
     * @param evt The event passed to this action.
     */
    private void addResidentialAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addResidentialAccountActionPerformed
        Account temp = promptForAccount(RESIDENTIAL);
    	if(temp != null)
    	{
    		Controller.getInstance().addAccount(temp);
                //Call to tell the table to update
    		accountTableModel.fireTableDataChanged();
    	}
    }//GEN-LAST:event_addResidentialAccountActionPerformed

    /**
     * Action to handle force saving the status of the program
     * 
     * @param evt The event passed to this action.
     */
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        Controller.getInstance().save();
    }//GEN-LAST:event_saveActionPerformed

    /**
     * Action to handle adding a new meter to the program.
     * 
     * @param evt The event passed to this action.
     */
    private void addMeterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMeterActionPerformed
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
                   "Enter information for a meter reading", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
          if (result == 0) 
          {
              Meter temp = new Meter(Integer.parseInt(meterIDField.getText()), meterTypeField.getText(), 0.0, new Address("a", "b", "c", "d", "e"));
              Controller.getInstance().addMeter(temp);
              //Call to tell the table to update
              meterTableModel.fireTableDataChanged();
              System.out.println("NEW METER ADDED");
          }
    }//GEN-LAST:event_addMeterActionPerformed

    /**
     * Action to handle deleting an account from the edit menu
     * 
     * @param evt The event passed to this action.
     */
    private void deleteAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAccountActionPerformed
        JTextField accountID = new JTextField(12);
        Object[] options = {"DELETE", "CANCEL"};

          JPanel myPanel = new JPanel();
          myPanel.add(new JLabel("Enter Account ID to Delete:"));
          myPanel.add(accountID);

          int result = JOptionPane.showOptionDialog(null, myPanel, 
                   "Delete an account", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
          if (result == 0) 
          {
             int ID = Integer.parseInt(accountID.getText()); 
             confirmAccountDelete(ID);
          }
    }//GEN-LAST:event_deleteAccountActionPerformed

    
    private void confirmAccountDelete(int accountID)
    {
        Object[] options = {"YES", "NO"};
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Delete Account with the ID:" +  accountID + "?"));
        
        int result = JOptionPane.showOptionDialog(null, myPanel, 
                   "Confirm Deletion", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        
        if(result != 0)
            return;
        
        Controller.getInstance().deleteAccount(accountID);
        //Call to tell the table to update
        accountTableModel.fireTableDataChanged();
        System.out.println("ACCOUNT DELETED");
    }
    
    /**
     * Action to handle deleting a meter from the edit menu
     * 
     * @param evt The event passed to this action.
     */
    private void deleteMeterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMeterActionPerformed
          JTextField meterID = new JTextField(12);
          Object[] options = {"DELETE", "CANCEL"};

          JPanel myPanel = new JPanel();
          myPanel.add(new JLabel("Enter Meter ID to Delete:"));
          myPanel.add(meterID);

          int result = JOptionPane.showOptionDialog(null, myPanel, 
                   "Delete an Meter", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
          if (result == 0) 
          {
              int ID = Integer.parseInt(meterID.getText());
              Controller.getInstance().deleteMeter(ID);
              //Call to tell the table to update
              meterTableModel.fireTableDataChanged();
              System.out.println("METER DELETED");
          }
    }//GEN-LAST:event_deleteMeterActionPerformed

    /**
     * Action to handle adding a commercial account from the edit menu.
     * 
     * @param evt The event passed to this action.
     */
    private void addCommercialAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCommercialAccountActionPerformed
        Account temp = promptForAccount(COMMERCIAL);
    	if(temp != null)
    	{
    		Controller.getInstance().addAccount(temp);
                //Call to tell the table to update
    		accountTableModel.fireTableDataChanged();
    	}

    }//GEN-LAST:event_addCommercialAccountActionPerformed

    /**
     * Event to detect popup
     * 
     * @param evt The event passed to this action.
     */
    private void accountTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountTableMousePressed
        doAccountPopup(evt);
    }//GEN-LAST:event_accountTableMousePressed

    /**
     * Event to detect popup
     * 
     * @param evt The event passed to this action.
     */
    private void accountTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountTableMouseReleased
        doAccountPopup(evt);
    }//GEN-LAST:event_accountTableMouseReleased

    /**
     * Actual method to respond to a call for a popup even. Checks if the event is the
     * popup trigger and then responds accordingly.
     * 
     * @param evt The event passed to this action.
     */
    private void doAccountPopup(java.awt.event.MouseEvent evt)
    {
        if(evt.isPopupTrigger())
        {
            Point p = evt.getPoint();
            int row = accountTable.rowAtPoint(p);
            accountTable.getSelectionModel().setSelectionInterval(row, row);
            accountPopup.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }
    
    /**
     * Returns the currently selected row in the account table. Returns -1 if
     * for some reason the accountTable does not return an Integer
     * 
     * @return 
     */
    private int getSelectedAccountID()
    {
        int row = accountTable.getSelectedRow();
        Object temp = accountTable.getValueAt(row, 0);
        if(!(temp instanceof Integer))
            return -1;
        int accID = ((Integer)temp).intValue();
        return accID;
    }
    
    /**
     * Action to handle calls from the popup to edit the currently selected account.
     * 
     * @param evt The event passed to this action.
     */
    private void editAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editAccountActionPerformed
        //Get the account and remove it from the Controller.
        int accID = getSelectedAccountID();   
        Account acc = Controller.getInstance().deleteAccount(accID);
        Address address = acc.getBillingAddress();
        
        //Handle Residential and Commercial accounts slightly differently
        Account newAccount;
        if(acc instanceof ResidentialAccount)
        {
            newAccount = promptForAccount((ResidentialAccount)acc, RESIDENTIAL);
        }
        else if(acc instanceof CommercialAccount)
        {
            newAccount = promptForAccount((CommercialAccount)acc, COMMERCIAL);
        }
        else
        {
            newAccount = null;
        }
        
        //Updates the account if the new account isnt null, otherwise uses the old
        //account. 
        if(newAccount == null)
        {
            Controller.getInstance().addAccount(acc);
        }
        else
        {
            Controller.getInstance().addAccount(newAccount);
        }
        
        accountTableModel.fireTableDataChanged();
    }//GEN-LAST:event_editAccountActionPerformed

    /**
     * Action called when the user wants to view the information for an account.
     * 
     * @param evt The event passed to this action.
     */
    private void viewAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAccountActionPerformed
        int accID = getSelectedAccountID();
        Account acc = Controller.getInstance().getAccount(accID);
        displayViewAccountDialog(acc);
    }//GEN-LAST:event_viewAccountActionPerformed

    /**
     * Action called when the user wants to delete an account from the popup menu
     * 
     * @param evt The event passed to this action.
     */
    private void deleteAccountPopupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteAccountPopupActionPerformed
        int accID = getSelectedAccountID();
        confirmAccountDelete(accID);
    }//GEN-LAST:event_deleteAccountPopupActionPerformed

    private void addMeterToAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMeterToAccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addMeterToAccountActionPerformed

    private void viewMetersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewMetersActionPerformed
        int accountID = getSelectedAccountID();
        Account acc = Controller.getInstance().getAccount(accountID);
        if(acc instanceof CommercialAccount)
        {
            meterViewTable.setModel(new MeterViewTableModel(((CommercialAccount)acc).getMeters()));
        }
        else
        {
            meterViewTable.setModel(new MeterViewTableModel(((ResidentialAccount)acc).getMeter()));
        }
        meterViewDialog.pack();
        meterViewDialog.setLocationRelativeTo(this);
        meterViewDialog.setVisible(true);
    }//GEN-LAST:event_viewMetersActionPerformed

    /**
     * Helper method to display the account information. This creates the popup
     * that displays the information. 
     * 
     * @param acc 
     */
    private void displayViewAccountDialog(Account acc)
    {
        Address address = acc.getBillingAddress();
        
        //Display the name panel for the different accounts slightly differently
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        if(acc instanceof CommercialAccount)
        {
            CommercialAccount comAcc = (CommercialAccount)acc;
            namePanel.add(new JLabel("Company Name:"));
            namePanel.add(new JLabel(comAcc.getCompanyName()));
        }
        else
        {
            ResidentialAccount resAcc = (ResidentialAccount)acc;
            namePanel.add(new JLabel("First Name:"));
            namePanel.add(new JLabel(resAcc.getClientFirstName()));
            namePanel.add(Box.createHorizontalStrut(15));
            namePanel.add(new JLabel("Last Name:"));
            namePanel.add(new JLabel(resAcc.getClientLastName()));
        }  
        
        //Construct the rest of the panel. 
        Object[] options = {"OK"};

		JPanel myPanel = new JPanel();
		myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));

		myPanel.add(namePanel);
		JPanel accountIdPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		accountIdPanel.add(new JLabel("Account ID:"));
		accountIdPanel.add(new JLabel("" + acc.getAccountID()));
		accountIdPanel.add(Box.createHorizontalStrut(230));
		myPanel.add(accountIdPanel);
		JPanel addressPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                JPanel addressPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		addressPanel.add(new JLabel("Address Line 1:"));
		addressPanel.add(new JLabel(address.getLocation1()));
		addressPanel.add(Box.createHorizontalStrut(15));
		addressPanel2.add(new JLabel("Address Line 2:"));
		addressPanel2.add(new JLabel(address.getLocation2()));
		myPanel.add(addressPanel);
                myPanel.add(addressPanel2);
		JPanel cszPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		cszPanel.add(new JLabel("City:"));
		cszPanel.add(new JLabel(address.getCity()));
		cszPanel.add(Box.createHorizontalStrut(15));
		cszPanel.add(new JLabel("State:"));
		cszPanel.add(new JLabel(address.getState()));
		cszPanel.add(Box.createHorizontalStrut(15));
		cszPanel.add(new JLabel("Zip:"));
		cszPanel.add(new JLabel(address.getZip()));
		myPanel.add(cszPanel);
                JOptionPane.showOptionDialog(null, myPanel, 
                         "View Account Information", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    }
    
    /**
     * Convinience method for promptForAccount. Calls the normal method with a null
     * account parameter. Note this will create a popup that has empty fields.
     * 
     * @param type The type of the account
     * @return The new/edited account.
     */
    private Account promptForAccount(int type)
    {
        return promptForAccount(null, type);
    }
    
    /**
     * Method to create or edit an account. If the method is passed an account,
     * it will use the account information to populate the fields in the dialog.
     * 
     * @param acc The account with which to populate the fields.
     * @param type The type of the Account. 
     * @return 
     */
    private Account promptForAccount(Account acc, int type)
    {   
        //Fields for the name panel.
        JTextField firstNameField = new JTextField(10);
        JTextField lastNameField = new JTextField(10);           
        JTextField companyName = new JTextField(30);
          
        //Fields for the rest of the panels.
        JTextField accountIDField = new JTextField(10);
        JTextField line1Field = new JTextField(20);
        JTextField line2Field = new JTextField(20);
        JTextField cityField = new JTextField(10);
        JTextField stateField = new JTextField(10);
        JTextField zipField = new JTextField(5);
            
        //Populate the fields with the current account if it is not null    
        if(acc != null)
        {
            Address address = acc.getBillingAddress();
            if(type == RESIDENTIAL && acc instanceof ResidentialAccount)
            {
                ResidentialAccount resAcc = (ResidentialAccount)acc;
                firstNameField.setText(resAcc.getClientFirstName());
                lastNameField.setText(resAcc.getClientLastName());
            }
            else if(type == COMMERCIAL && acc instanceof CommercialAccount)
            {
                CommercialAccount comAcc = (CommercialAccount)acc;
                companyName.setText(comAcc.getCompanyName());
            }
            else
            {
                return null;
            }
            
            accountIDField.setText(Integer.toString(acc.getAccountID()));
            line1Field.setText(address.getLocation1());
            line2Field.setText(address.getLocation2());
            cityField.setText(address.getCity());
            stateField.setText(address.getState());
            zipField.setText(address.getZip());
        }
        
        //Handle the name panel depending on the type of account. 
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        if(type == COMMERCIAL)
        {
            namePanel.add(new JLabel("Company Name:"));
            namePanel.add(companyName);
        }
        else if(type == RESIDENTIAL)
        {
            namePanel.add(new JLabel("First Name:"));
            namePanel.add(firstNameField);
            namePanel.add(Box.createHorizontalStrut(15));
            namePanel.add(new JLabel("Last Name:"));
            namePanel.add(lastNameField);
        }
        //Return null for a unhandled account. 
        else
        {
            return null;
        }
        
        //Create the other standard fields for the dialog
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
        myPanel.add(namePanel);
        JPanel accountIdPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        accountIdPanel.add(new JLabel("Account ID:"));
        accountIdPanel.add(accountIDField);
        accountIdPanel.add(Box.createHorizontalStrut(230));
        myPanel.add(accountIdPanel);
        JPanel addressPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel addressPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        addressPanel.add(new JLabel("Address Line 1:"));
        addressPanel.add(line1Field);
        addressPanel2.add(new JLabel("Address Line 2:"));
        addressPanel2.add(line2Field);
        myPanel.add(addressPanel);
        myPanel.add(addressPanel2);
        JPanel cszPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cszPanel.add(new JLabel("City:"));
        cszPanel.add(cityField);
        cszPanel.add(Box.createHorizontalStrut(15));
        cszPanel.add(new JLabel("State"));
        cszPanel.add(stateField);
        cszPanel.add(Box.createHorizontalStrut(15));
        cszPanel.add(new JLabel("Zip"));
        cszPanel.add(zipField);
        myPanel.add(cszPanel);
        
        //Display the dialog.
        Object[] options = {"SAVE", "CANCEL"};
        int result = JOptionPane.showOptionDialog(null, myPanel, "Enter information for the account", 
                                                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
                                                    null, options, options[0]);
        
        //If the user clicks ok, create the new account based on the parameters
        if (result == 0) 
        {
            try
            {  
                Account temp;
                if(type == RESIDENTIAL)
                {
                    temp = new ResidentialAccount(firstNameField.getText(), lastNameField.getText(),	
                                                        Integer.parseInt(accountIDField.getText()), 0, false,
                                                        new Date(), new Address(line1Field.getText(), 
                                                        line2Field.getText(), cityField.getText(), 
                                                        stateField.getText(), zipField.getText()));
                }
                else if(type == COMMERCIAL)
                {
                    temp = new CommercialAccount(companyName.getText(), 
                                                        Integer.parseInt(accountIDField.getText()), 0, false, 
                                                        new Date(), new Address(line1Field.getText(), 
                                                        line2Field.getText(), cityField.getText(), 
                                                        stateField.getText(), zipField.getText()));
                }
                else
                {
                    temp = null;
                }
                return temp;
            }
            catch(Exception e)
            {
                return null;
            }
        }
        else
        {
            return null;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserInterface().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu accountPopup;
    private javax.swing.JScrollPane accountScrollPane;
    private javax.swing.JTable accountTable;
    private javax.swing.JMenuItem addCommercialAccount;
    private javax.swing.JMenuItem addMeter;
    private javax.swing.JMenuItem addMeterToAccount;
    private javax.swing.JMenuItem addResidentialAccount;
    private javax.swing.JMenuItem deleteAccount;
    private javax.swing.JMenuItem deleteAccountPopup;
    private javax.swing.JMenuItem deleteMeter;
    private javax.swing.JMenuItem editAccount;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JMenu menuFile;
    private javax.swing.JScrollPane meterScrollPane;
    private javax.swing.JTable meterTable;
    private javax.swing.JDialog meterViewDialog;
    private javax.swing.JScrollPane meterViewSrollPane;
    private javax.swing.JTable meterViewTable;
    private javax.swing.JMenuItem save;
    private javax.swing.JMenuItem viewAccount;
    private javax.swing.JMenuItem viewMeters;
    // End of variables declaration//GEN-END:variables
}
