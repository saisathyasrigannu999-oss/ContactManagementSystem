public interface ContactOperations {

    void insert(Contact contact);

    void delete(String phone);

    void search(String name);

    // Default interface method
    default void logActivity(String message) {
        System.out.println("[LOG] " + message);
    }
}