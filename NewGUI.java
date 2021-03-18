package com.company;

import javax.swing.*;
import java.awt.event.*;

/**
 *  NewGUI creates an interface for the user to enter information about a contact and then
 *  add that contact to the addressbook
 * @author Michael LaRussa
 * @since 3/17/2021
 */

public class NewGUI extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;

    /**
     * Constructs the user interface for our New Contact
     * @param ab the addressbook which the new entry will be saved to
     */
    public NewGUI(AddressBook ab) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK(ab);
            }

        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    /**
     * This method saves the new contact to the AddressBook when the user hits the "OK" button
     * @param ab the addressbook which the new entry will be saved to
     */
    private void onOK(AddressBook ab) {
        // add your code here
        String fn = textField1.getText();
        String ln = textField2.getText();
        String str = textField3.getText();
        String ci = textField4.getText();
        String sta = textField5.getText();
        Integer zi = Integer.parseInt(textField6.getText());
        String ph = textField7.getText();
        String em = textField8.getText();

        AddressEntry ae = new AddressEntry(fn, ln, str, ci, sta, zi, ph, em);
        ab.add(ae);

        dispose();
    }

    /**
     *  This method closes the NewGUI when the user presses the "cancel" button
     */
    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
