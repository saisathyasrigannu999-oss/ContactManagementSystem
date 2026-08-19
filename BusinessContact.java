public class BusinessContact extends Contact {

    private String company;

    public BusinessContact(
            String name,
            String phone,
            String email,
            Address address,
            String company) {

        super(name, phone, email, address);
        this.company = company;
    }

    @Override
    public void displayContactType() {
        System.out.println("Contact Type: Business Contact");
        System.out.println("Company: " + company);
    }
}