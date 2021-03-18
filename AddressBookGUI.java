package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *  AddressBookGUI creates a user interface for our AddressBook
 *  with the options to display all contacts, add a new contact,
 *  search an existing contact, remove an existing contact, or
 *  to close the program
 * @Author Michael LaRussa
 * @Since 3/17/2021
 */
public class AddressBookGUI extends JDialog{
    private JPanel contentPane;
    private JButton displayButton;
    private JButton removeButton;
    private JButton newButton;
    private JScrollPane scrollPane;
    JList <AddressEntry> addressEntryJList = new JList<AddressEntry>();
    DefaultListModel<AddressEntry> myaddressEntryListModel = new DefaultListModel<AddressEntry>();
    AddressBook ab = new AddressBook();
    AddressEntry x = new AddressEntry("Michael", "LaRussa", "Calaveras Expy.", "Milpitas", "California", 95035, "555-123-4567", "Example@gmail.com");


    /**
     *  Constructs the user Interface for our AddressBook
     */
    public AddressBookGUI() {
        setContentPane(contentPane);
        setModal(true);
        ab.add(x);


        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myaddressEntryListModel = new DefaultListModel<AddressEntry>();
                for(int i = 0; i<ab.addressEntryList.size(); i++)
                {  myaddressEntryListModel.add(i, ab.addressEntryList.elementAt(i)); }
                addressEntryJList = new JList<AddressEntry>(myaddressEntryListModel);
                addressEntryJList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
                addressEntryJList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
                addressEntryJList.setVisibleRowCount(-1);
                scrollPane.setViewportView(addressEntryJList);

            }
        });
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewGUI newGUI = new NewGUI(ab);
                newGUI.pack();
                newGUI.setVisible(true);
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer index = addressEntryJList.getSelectedIndex();
                ab.addressEntryList.removeElementAt(index);
            }
        });
    }

    /**
     * This is the Main function
     * It creates an instance of the AddressBookGUI object
     *
     * @param args
     */
    public static void main(String[] args) {
        AddressBookGUI dialog = new AddressBookGUI();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

}
