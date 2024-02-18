public class Main {
    public static void main(String[] args) {
        // Instantiate UserDaoImpl and TaskDaoImpl
        UserDaoImpl userDao = new UserDaoImpl(10); // Adjust the size as needed
        TaskDaoImpl taskDao = new TaskDaoImpl(100); // Adjust the size as needed

        // Instantiate TodoManager and start the application
        TodoManager todoManager = new TodoManager(userDao, taskDao);
        todoManager.start();
    }
}