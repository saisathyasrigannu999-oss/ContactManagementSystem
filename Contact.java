public class Contact extends Person {

    private String email;
    private Address address;

    // Final constant
    public static final String CONTACT_TYPE = "GENERAL";

    // Composition
    public Contact(String name, String phone, String email, Address address) {
        super(name, phone);
        this.email = email;
        this.address = address;
    }

    // Copy Constructor
    public Contact(Contact other) {
        super(other.getName(), other.getPhone());
        this.email = other.email;
        this.address = new Address(
                other.address.getCity(),
                other.address.getState()
        );
    }

    // Inner Class
    public class ContactDetails {

        public void showDetails() {
            System.out.println("Name    : " + getName());
            System.out.println("Phone   : " + getPhone());
            System.out.println("Email   : " + email);
            System.out.println("Address : " + address);
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public void displayContactType() {
        System.out.println("Contact Type: General Contact");
    }

    // Method Overloading
    public void updateEmail(String email) {
        this.email = email;
    }

    public void updateEmail(String email, String domain) {
        this.email = email + "@" + domain;
    }

    @Override
    public String toString() {
        return getName() + " | " +
               getPhone() + " | " +
               email + " | " +
               address;
    }
}