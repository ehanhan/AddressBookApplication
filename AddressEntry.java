/**
 * This is the Address Entry Object Class
 * This object holds all the variables
 * Neccesary to store a contact
 *
 * @author ehabh
 */
public class AddressEntry {

    /* PRIVATE VARIABLES */
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private int zipcode;
    private String email;
    private String phone;

    /* DEFAULT CONSTRUCTOR */
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

    /**
     * CONSTRUCTOR
     * @param fn first name
     * @param ln last name
     * @param str street address
     * @param cit city
     * @param sta state
     * @param zip zipcode
     * @param eml email
     * @param pnum phone number
     */
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

    /**
     *
     * @return toString Collects each AddressEntry Variable into a concise String
     */
    public String toString() {
        return (this.firstName + " " + this.lastName + "\n"
                + this.street + " " + this.city + ", " + this.state + " " + this.zipcode + "\n"
                + this.email + "\n" + this.phone + "\n\n");
    }

    /**
     * @param fn firstname
     */
    public void setFirstName (String fn) {
        this.firstName = fn;
    }

    /**
     *
     * @param ln lastname
     */
    public void setLastName (String ln) {
        this.lastName = ln;
    }

    /**
     *
     * @param str street_address
     */
    public void setStreet (String str) {
        this.street = str;
    }

    /**
     *
     * @param cit city
     */
    public void setCity (String cit) {
        this.city = cit;
    }

    /**
     *
     * @param sta state
     */
    public void setState (String sta) {
        this.state = sta;
    }

    /**
     *
     * @param zip zipcode
     */
    public void setZipcode (int zip) {
        this.zipcode = zip;
    }

    /**
     *
     * @param eml email
     */
    public void setEmail (String eml) {
        this.email = eml;
    }

    /**
     *
     * @param pnum phone_number
     */
    public void setPhone (String pnum) {
        this.phone = pnum;
    }

    /**
     *
     * @return first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     *
     * @return last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     *
     * @return street address
     */
    public String getStreet() {
        return this.street;
    }

    /**
     *
     * @return city
     */
    public String getCity() {
        return this.city;
    }

    /**
     *
     * @return state
     */
    public String getState() {
        return this.state;
    }

    /**
     *
     * @return zipcode
     */
    public int getZipcode() {
        return this.zipcode;
    }

    /**
     *
     * @return email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     *
     * @return phone number
     */
    public String getPhone() {
        return this.phone;
    }
}
