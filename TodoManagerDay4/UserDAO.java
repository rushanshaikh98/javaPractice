public interface UserDAO {
    // Define methods for user data access
    void registerUser(User user);
    User loginUser(String username);
}
