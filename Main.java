import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ContactManager manager = new ContactManager();

        while (true) {

            System.out.println("\n==============================");
            System.out.println("   CONTACT MANAGEMENT SYSTEM");
            System.out.println("==============================");

            System.out.println("1. Add Contact");
            System.out.println("2. Add Personal Contact");
            System.out.println("3. Add Business Contact");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Search Contact");
            System.out.println("6. Delete Contact");
            System.out.println("7. Show Contact Count");
            System.out.println("8. Copy Contact Demo");
            System.out.println("9. Inner Class Demo");
            System.out.println("10. Exit");

            System.out.print("Enter your choice: ");

            int choice;

            try {

                choice = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {

                case 1:

                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();

                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    Address address =
                            new Address("Hyderabad", "Telangana");

                    Contact contact =
                            new Contact(
                                    name,
                                    phone,
                                    email,
                                    address
                            );

                    manager.insert(contact);

                    break;

                case 2:

                    System.out.print("Enter name: ");
                    name = scanner.nextLine();

                    System.out.print("Enter phone: ");
                    phone = scanner.nextLine();

                    System.out.print("Enter email: ");
                    email = scanner.nextLine();

                    System.out.print("Enter relationship: ");
                    String relationship = scanner.nextLine();

                    Address personalAddress =
                            new Address("Hyderabad", "Telangana");

                    PersonalContact personalContact =
                            new PersonalContact(
                                    name,
                                    phone,
                                    email,
                                    personalAddress,
                                    relationship
                            );

                    manager.insert(personalContact);

                    break;

                case 3:

                    System.out.print("Enter name: ");
                    name = scanner.nextLine();

                    System.out.print("Enter phone: ");
                    phone = scanner.nextLine();

                    System.out.print("Enter email: ");
                    email = scanner.nextLine();

                    System.out.print("Enter company: ");
                    String company = scanner.nextLine();

                    Address businessAddress =
                            new Address("Hyderabad", "Telangana");

                    BusinessContact businessContact =
                            new BusinessContact(
                                    name,
                                    phone,
                                    email,
                                    businessAddress,
                                    company
                            );

                    manager.insert(businessContact);

                    break;

                case 4:

                    manager.displayAll();

                    break;

                case 5:

                    System.out.print("Enter name to search: ");

                    name = scanner.nextLine();

                    manager.search(name);

                    break;

                case 6:

                    System.out.print("Enter phone to delete: ");

                    phone = scanner.nextLine();

                    manager.delete(phone);

                    break;

                case 7:

                    System.out.println(
                            "Total Contacts: " +
                            ContactManager.getContactCount()
                    );

                    break;

                case 8:

                    Address copyAddress =
                            new Address("Hyderabad", "Telangana");

                    Contact original =
                            new Contact(
                                    "Shivani",
                                    "9876543210",
                                    "shivani@gmail.com",
                                    copyAddress
                            );

                    Contact copy =
                            new Contact(original);

                    System.out.println(
                            "Original Contact:"
                    );

                    System.out.println(original);

                    System.out.println(
                            "Copied Contact:"
                    );

                    System.out.println(copy);

                    break;

                case 9:

                    Address innerAddress =
                            new Address(
                                    "Hyderabad",
                                    "Telangana"
                            );

                    Contact innerContact =
                            new Contact(
                                    "Shivani",
                                    "9876543210",
                                    "shivani@gmail.com",
                                    innerAddress
                            );

                    Contact.ContactDetails details =
                            innerContact.new ContactDetails();

                    details.showDetails();

                    break;

                case 10:

                    System.out.println(
                            "Thank you for using Contact Management System!"
                    );

                    scanner.close();

                    return;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }
        }
    }
}