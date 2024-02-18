public class UserDaoImpl implements UserDAO {
    private User[] users;
    private int userCount;

    public UserDaoImpl(int maxSize) {
        users = new User[maxSize];
        userCount = 0;
    }

    @Override
    public void registerUser(User user) {
        users[userCount++] = user;
    }

    @Override
    public User loginUser(String username) {
        for (User user : users) {
            if (user != null && user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public User[] getAllClients() {
        int count = 0;
        for (User user : users) {
            if (user != null) {
                if (user.getRole()=="Client"){
                    count++;
                }
            }
        }
        User[] clientUsers = new User[count];
        int index = 0;
        for (User user : users) {
            if (user != null) {
                if (user.getRole()=="Client"){
                    clientUsers[index++] = user;
                }
            }
        }
        return clientUsers;
    }
}
