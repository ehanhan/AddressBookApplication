/**
 * @author ehabh
 * This is the Address Entry Object
 * This object holds all the variables
 * Neccesary to store a contact
 */
public class AddressEntry {

    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private int zipcode;
    private String email;
    private String phone;

    public AddressEntry() {
        firstName = "";
        lastName = "";
        street = "";
        city = "";
        state = "";
        zipcode = 0;
        email = "";
        phone = "";
    }

    public AddressEntry(String fn, String ln, String str, String cit, String sta, int zip, String eml, String pnum) {
        firstName = fn;
        lastName = ln;
        street = str;
        city = cit;
        state = sta;
        zipcode = zip;
        email = eml;
        phone = pnum;
    }

    public String toString() {
        return (this.firstName + " " + this.lastName + "\n"
                + this.street + " " + this.city + ", " + this.state + " " + this.zipcode + "\n"
                + this.email + "\n" + this.phone + "\n\n");
    }

    public void setFirstName (String fn) {
        this.firstName = fn;
    }
    public void setLastName (String ln) {
        this.lastName = ln;
    }
    public void setStreet (String str) {
        this.street = str;
    }
    public void setCity (String cit) {
        this.city = cit;
    }
    public void setState (String sta) {
        this.state = sta;
    }
    public void setZipcode (int zip) {
        this.zipcode = zip;
    }
    public void setEmail (String eml) {
        this.email = eml;
    }
    public void setPhone (String pnum) {
        this.phone = pnum;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }

    public String getStreet() {
        return this.street;
    }
    public String getCity() {
        return this.city;
    }
    public String getState() {
        return this.state;
    }
    public int getZipcode() {
        return this.zipcode;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPhone() {
        return this.phone;
    }
}
