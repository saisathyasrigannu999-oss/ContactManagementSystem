public abstract class Person {

    private String name;
    private String phone;

    // Static block
    static {
        System.out.println("Contact Management System Initialized");
    }

    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    // Getters and Setters - Encapsulation
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Abstract method - Abstraction
    public abstract void displayContactType();

    // Static method
    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("\\d{10}");
    }
}