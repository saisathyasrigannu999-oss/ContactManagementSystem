public class PersonalContact extends Contact {

    private String relationship;

    public PersonalContact(
            String name,
            String phone,
            String email,
            Address address,
            String relationship) {

        super(name, phone, email, address);
        this.relationship = relationship;
    }

    @Override
    public void displayContactType() {
        System.out.println("Contact Type: Personal Contact");
        System.out.println("Relationship: " + relationship);
    }
}