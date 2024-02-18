import java.util.Scanner;

public class TodoManager {
    private static UserDaoImpl userDao;
    private static TaskDaoImpl taskDao;
    private static Scanner scanner;
    int choice;
    String username;

    public TodoManager(UserDaoImpl userDao, TaskDaoImpl taskDao) {
        TodoManager.userDao = userDao;
        TodoManager.taskDao = taskDao;
        scanner = new Scanner(System.in);
        User user = new User("admin", "Admin"); 
        userDao.registerUser(user);
        user = new User("rushan", "Client"); 
        userDao.registerUser(user);
    }

    public void registerUser(String username, String role) {
        User existingUser = userDao.loginUser(username);
        if (existingUser == null){
            User user = new User(username, role); 
            userDao.registerUser(user);
            System.out.println(user.getUsername()+user.getRole());
        }
        else{
            System.out.println("User with this username already exists!");
        }
    }

    // Method to handle user login
    public User loginUser(String username) {
        User currentUser = userDao.loginUser(username);
        if (currentUser!=null){
            if (currentUser.role=="Admin"){
                displayMenu();
            }
            else{
                displayCurrentUserTasks(username);
            }
            start(); 
        }
        else{
            System.out.println("User does not exist!");
        }

        return currentUser;
    }

    private void displayMenu() {
        do {
            System.out.println("\n=== Todo Manager Menu ===");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Search Task");
            System.out.println("5. View All Tasks");
            System.out.println("6. Assign a task to a user");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    updateTask();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    searchTask();
                    break;
                case 5:
                    viewAllTasks();
                    break;
                case 6:
                    assignTask();
                    break;
                case 0:
                    System.out.println("Exiting.....");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        while (choice != 0);
    }


    private static void viewAllTasks() {
        System.out.println("All Tasks:");
        for (Task task : taskDao.getAllTasks()) {
            if (task != null){
                System.out.println(task.toString());
            }
        }
    }

    private static void addTask() {
        Task[] currentTasks = taskDao.getAllTasks();
        if (currentTasks.length<10){
            System.out.print("Enter task title: ");
            String title = scanner.nextLine();
            System.out.print("Enter task text: ");
            String text = scanner.nextLine();

            Task task = new Task(0, title, text);
            taskDao.addTask(task);
            System.out.println("Task added successfully with ID: " + task.getTaskId());
        }
        else{
            System.out.println("Task sheet is already full and so you cannot add any additional tasks!");
        }
    }

    private static void updateTask() {
        System.out.print("Enter task ID to update: ");
        int taskId = scanner.nextInt();
        scanner.nextLine();

        Task existingTask = taskDao.searchTask(taskId);
        if (existingTask != null) {
            System.out.print("Enter new task title: ");
            String title = scanner.nextLine();
            System.out.print("Enter new task text: ");
            String text = scanner.nextLine();

            Task updatedTask = new Task(taskId, title, text);
            taskDao.updateTask(updatedTask);
        } else {
            System.out.println("Task with ID " + taskId + " not found.");
        }
    }

    private static void deleteTask() {
        System.out.print("Enter task ID to delete: ");
        int taskId = scanner.nextInt();
        scanner.nextLine();

        Task existingTask = taskDao.searchTask(taskId);
        if (existingTask != null) {
            taskDao.deleteTask(taskId);
        } else {
            System.out.println("Task with ID " + taskId + " not found.");
        }
    }

    private static void searchTask() {
        System.out.print("Enter task ID to search: ");
        int taskId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Task task = taskDao.searchTask(taskId);
        if (task != null) {
            System.out.println("Task found:");
            System.out.println(task);
        } else {
            System.out.println("Task with ID " + taskId + " not found.");
        }
    }

    public static void assignTask(){
        System.out.println("All Client Users:");
        for (User user : userDao.getAllClients()) {
            if (user != null){
                System.out.println(user.toString());
            }
        }
        Task[] allTasks = taskDao.getAllTasks();
        if (allTasks.length>0){
            System.out.println("All Tasks:");
            for (Task task : allTasks) {
                if (task != null){
                    System.out.println(task.toString());
                }
            }
            System.out.print("Enter task ID to assign: ");
            int taskId = scanner.nextInt();
            scanner.nextLine();

            Task existingTask = taskDao.searchTask(taskId);
            if (existingTask != null) {
                System.out.println("Please enter the username you want to assign this task: ");
                String username = scanner.next();
                User existingUser = userDao.loginUser(username);
                if (existingUser != null && existingUser.getRole()=="Client"){
                   taskDao.assignTask(username, taskId);
                }
                else{
                    System.out.println("Client user with this username does not exist!");
                }
            } else {
                System.out.println("Task with ID " + taskId + " not found.");
            }
            
        }
        else{
            System.out.println("There are not tasks to assign!");
        }
    }

    public void displayCurrentUserTasks(String username) {
        System.out.println(username);
        Task[] allTasks = taskDao.getTasksofCurrentUser(username);
        if (allTasks.length>0){
            System.out.println("Here are all your Tasks:");
            for (Task task : allTasks) {
                if (task != null){
                    System.out.println(task.toString());
                }
            }
        }
        else{
            System.out.println("There are no tasks assigned to you!");
        }
    }

    public void start() {
        do {
            System.out.println("---------------------------------------Welcome to ToDo Manager---------------------------------------");
            System.out.println("1.Login \n2.Register\n0.Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter username:");
                    username = scanner.next();
                    loginUser(username);
                    break;
                case 2:
                    System.out.println("Enter username:");
                    username = scanner.next();
                    registerUser(username, "Client");
                    break;
                case 0:
                    System.out.println("Exiting......");
                    break;
                default:
                    System.out.println("Please enter valid option!");
            }
        }
        while (choice!=0);
        
    }

    // Implement menu and other application logic
}
