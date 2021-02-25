/**
 * This is the Main class of the Address Book program
 * It first Creates an instance of an Address Book object
 * then creates an instance of a Menu object
 * finally it passes the addressbook object into the Menu's Run method,
 * which initiates the User interface menu
 *
 * @author ehabh
 *
 */

public class AddressBookApplication {

    public static void main(String args[]) {

        AddressBook ab = new AddressBook();
        Menu menu = new Menu();
        Menu.Run(ab);
    }
}