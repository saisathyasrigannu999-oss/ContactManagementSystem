import java.util.ArrayList;

public class ContactManager implements ContactOperations {

    private ArrayList<Contact> contacts = new ArrayList<>();

    private static int contactCount = 0;

    // Static method
    public static int getContactCount() {
        return contactCount;
    }

    // Method Overloading
    public void insert(String name, String phone) {

        Address address = new Address("Unknown", "Unknown");

        Contact contact = new Contact(
                name,
                phone,
                "notprovided@email.com",
                address
        );

        insert(contact);
    }

    public void insert(
            String name,
            String phone,
            String email) {

        Address address = new Address("Unknown", "Unknown");

        Contact contact = new Contact(
                name,
                phone,
                email,
                address
        );

        insert(contact);
    }

    // Interface method
    @Override
    public void insert(Contact contact) {

        try {

            if (!Person.isValidPhone(contact.getPhone())) {
                throw new InvalidContactException(
                        "Phone number must contain exactly 10 digits."
                );
            }

            for (Contact c : contacts) {

                if (c.getPhone().equals(contact.getPhone())) {
                    throw new DuplicateContactException(
                            "Contact already exists."
                    );
                }
            }

            contacts.add(contact);
            contactCount++;

            logActivity(
                    "Contact added: " + contact.getName()
            );

        } catch (InvalidContactException |
                 DuplicateContactException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void delete(String phone) {

        boolean removed = contacts.removeIf(
                contact -> contact.getPhone().equals(phone)
        );

        if (removed) {

            contactCount--;

            logActivity(
                    "Contact deleted: " + phone
            );

        } else {

            System.out.println("Contact not found.");
        }
    }

    @Override
    public void search(String name) {

        boolean found = false;

        for (Contact contact : contacts) {

            if (contact.getName()
                    .toLowerCase()
                    .contains(name.toLowerCase())) {

                System.out.println(contact);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No contact found.");
        }
    }

    public void displayAll() {

        if (contacts.isEmpty()) {

            System.out.println("No contacts available.");
            return;
        }

        System.out.println("\n----- ALL CONTACTS -----");

        for (Contact contact : contacts) {

            System.out.println(contact);

            // Polymorphism
            contact.displayContactType();

            System.out.println("------------------------");
        }
    }
}