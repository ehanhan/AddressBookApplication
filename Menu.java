/**
 * This is the Menu class
 * This class controls most of the User interface
 * It starts with the Run method which has a continuous
 * while loop that allows the user to choose which process they want
 * to run.
 * Depending on the user's choice the program
 * will run one of these processes
 *
 * a) Loading From File - Prompts the user for a file name then
 *                        reads the file and adds the contacts to the address book
 *
 * b) Addition - Allows the user to enter a contact manually
 *
 * c) Removal - Allows the user to remove a contact by searching Last Name
 *
 * d) Find - Searches the Address book for a contact by prompting
 *           the user for a Last name or  partial ragment of Last Name
 *
 * e) Listing - Prints a list of all contacts currently stored
 *
 * f) Quit - Exit the program
 *
 * @author ehabh
 */

import java.util.*;

public class Menu {

    /**
     * Runs the main menu and executes each of the
     * user's inputted choices
     *
     * @param ab Passes in the Address Book object
     */
    public static void Run(AddressBook ab) {
        char choice = '0';

        while(choice != 'f') {

            choice = PromptChoice();
            if(choice == 'a') {
                ab.readFromFile(PromptFileName());
            }
            else if(choice == 'b') {
                Addition(ab);
            }
            else if(choice == 'c') {
                Removal(ab);
            }
            else if(choice == 'd') {
                Find(ab);
            }
            else if(choice == 'e') {
                Listing(ab);
            }
            else if(choice == 'f') {
                Quit();
            }
            else {
                System.out.print("ERROR: please enter a single letter choice (between a-f)\n\n");
            }
        }

    }

    /**
     * prompts the user to select an option from the menu
     *
     * @return returns the user's menu choice
     */
    public static char PromptChoice() {

        System.out.print("\n***************************************\n");
        System.out.print("Please enter in your menu selection\n");
        System.out.print("a) Loading From File\n");
        System.out.print("b) Addition\n");
        System.out.print("c) Removal\n");
        System.out.print("d) Find\n");
        System.out.print("e) Listing\n\n");
        System.out.print("f) Quit\n");
        System.out.print("***************************************\n\n");


        Scanner choiceScanner = new Scanner(System.in);
        System.out.print(">");
        char choice = choiceScanner.next().charAt(0);
        return choice;
    }

    /**
     * Prompts the user for an input file name
     *
     * @return returns the file name entered by the user
     */
    public static String PromptFileName() {
        System.out.print("Enter in File Name: \n");
        Scanner readFileName = new Scanner(System.in);
        System.out.print(">");
        String filename = readFileName.next();
        return filename;
    }

    /**
     * Allows the user to manually add an entry
     * by prompting them for user input for each varriable
     *
     * @param ab Passes in the Addressbook object
     */
    public static void Addition(AddressBook ab) {

        Scanner sc = new Scanner(System.in);
        AddressEntry newEntry = new AddressEntry();
        String input = "";

        System.out.print("First Name:\n>");
        input = sc.nextLine();
        newEntry.setFirstName(input);

        System.out.print("Last Name:\n>");
        input = sc.nextLine();
        newEntry.setLastName(input);

        System.out.print("Street:\n>");
        input = sc.nextLine();
        newEntry.setStreet(input);

        System.out.print("City:\n>");
        input = sc.nextLine();
        newEntry.setCity(input);

        System.out.print("State:\n>");
        input = sc.nextLine();
        newEntry.setState(input);

        System.out.print("Zip:\n>");
        input = sc.nextLine();
        newEntry.setZipcode(Integer.parseInt(input));

        System.out.print("Phone: xxx-aaa-bbbb:\n>");
        input = sc.nextLine();
        newEntry.setPhone(input);

        System.out.print("Email:\n>");
        input= sc.nextLine();
        newEntry.setEmail(input);

        ab.add(newEntry);
        System.out.print("\nThank you, the following contact has been added to your address book:\n");
        System.out.print(newEntry.toString());


    }

    /**
     * Takes in a user input string and displays all
     * entries with the same last name prompting the user
     * for a choice to delete one of the entries
     *
     * @param ab Passes in the Address Book object
     */
    public static void Removal(AddressBook ab) {

        System.out.print("Enter in Last Name of contact to remove:\n>");
        Scanner removeScanner = new Scanner(System.in);
        String lastname = removeScanner.nextLine();
        boolean contains = false;
        List<AddressEntry> tempList = new ArrayList<>();

        for(AddressEntry entry: ab.addressEntryList) {
            if (entry.getLastName().equals(lastname)) {
                contains = true;
                tempList.add(entry);
            }
        }

        if(contains) {
            System.out.print("\nThe following " + tempList.size() + " entries were found in the addressbook");
            int counter=0;
            for(AddressEntry entry: tempList) {
                counter++;
                System.out.print(counter +". " + entry.toString());
            }
            System.out.print("Select number of entry you wish to remove:\n>");
            Scanner numScanner = new Scanner(System.in);
            int removeContactID = numScanner.nextInt() - 1;
            ab.remove(tempList.get(removeContactID));
            System.out.print("Contact " + tempList.get(removeContactID).getFirstName() + " " + tempList.get(removeContactID).getLastName() + " has been successfully removed.\n");
        }
        else {
            System.out.print("Contact not found...Returning to Main menu.\n\n");
        }
    }

    /**
     * takes in a string from user input and displays entries with a last name
     * that matches that string up to 2 letters
     *
     * @param ab Passes in the Address Book Object
     */
    public static void Find(AddressBook ab) {
        List<AddressEntry> tempList = new ArrayList<>();
        boolean found = false;
        int lettersMatched = 0, matchesFound = 0, charArrayIndex = 0;
        System.out.print("Enter in all or the beginning of the Last Name of the contact you wish to find:\n>");
        Scanner findScanner = new Scanner(System.in);
        String nameFragment = findScanner.nextLine();

        for(AddressEntry entry : ab.addressEntryList) {
            System.out.print("ASSESING A NEW PERSON\n");
            for(char ch : nameFragment.toCharArray()) {
                if(ch == entry.getLastName().charAt(charArrayIndex)) {
                    lettersMatched++;
                    charArrayIndex++;
                }
            }
            if(lettersMatched > 1) {
                tempList.add(entry);
                matchesFound++;
            }
            lettersMatched = 0;
            charArrayIndex = 0;
        }
        if(matchesFound != 0) {
            System.out.print("\nThe following " + tempList.size() + " entries were found in the addressbook for a last name starting with '" + nameFragment + "':\n");
            int counter=0;
            for(AddressEntry entry: tempList) {
                counter++;
                System.out.print(counter +". " + entry.toString());
            }
        }
    }

    /**
     * Calls the print function to print the entire list of entries
     * @param ab passes in the Address Book object
     */
    public static void Listing(AddressBook ab) {
        ab.list();
    }

    /**
     * Quits the program
     */
    public static void Quit() {
        System.exit(0);
    }

}
