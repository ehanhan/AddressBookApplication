/**
 * This is the Address Book object
 * This object first creates a List of Address Entry Objects
 * and has methods to add an entry to the list, remove it,
 * display a list of all addresses, or read in Addresses from file
 *
 * @author ehabh
 */

import java.io.File;
import java.util.*;

public class AddressBook {

    /* List of Address Entries */
    List<AddressEntry> addressEntryList = new ArrayList<>();

    /* Prints the List of entries */
    public void list() {
        for (AddressEntry addressEntry : addressEntryList) {
            System.out.print(addressEntry.toString());
        }
    }

    /**
     *
     * @param entry Address entry
     */
    public void add(AddressEntry entry) {

        addressEntryList.add(entry);
    }

    /**
     *
     * @param entry Address entry
     */
    public void remove(AddressEntry entry) {
        addressEntryList.remove(entry);
    }

    /**
     *
     * @param filename Name of the input file
     */
    public void readFromFile(String filename) {

        int counter = 0;
        Scanner fileScanner = null;

        try {
            fileScanner = new Scanner(new File(filename));
        }
        catch (Exception e) {
            System.out.println("Could not find file: " + filename);
        }

        while (fileScanner.hasNext()) {
            String firstName = fileScanner.nextLine();
            String lastName = fileScanner.nextLine();
            String street = fileScanner.nextLine();
            String city = fileScanner.nextLine();
            String state = fileScanner.nextLine();
            int zipcode = Integer.parseInt(fileScanner.nextLine());
            String email = fileScanner.nextLine();
            String phone = fileScanner.nextLine();

            AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, zipcode, email, phone);
            this.add(entry);
            counter++;
        }
        fileScanner.close();
        System.out.print("Read in " + counter + " new Addresses, successfully loaded, currently " + counter + " Addresses\n\n");

    }
}

