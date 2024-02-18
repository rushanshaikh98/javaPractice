import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TaskDAO taskDAO = new TaskDAO();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== Todo Manager Menu ===");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Search Task");
            System.out.println("5. View All Tasks");
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
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        while (choice != 0);
    }

    private static void viewAllTasks() {
        System.out.println("All Tasks:");
        for (Task task : taskDAO.getAllTasks()) {
            if (task != null){
                System.out.println(task.toString());
            }
        }
    }

    private static void addTask() {
        Task[] currentTasks = taskDAO.getAllTasks();
        if (currentTasks.length<10){
            System.out.print("Enter task title: ");
            String title = scanner.nextLine();
            System.out.print("Enter task text: ");
            String text = scanner.nextLine();

            Task task = new Task(0, title, text);
            taskDAO.addTask(task);
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

        Task existingTask = taskDAO.searchTask(taskId);
        if (existingTask != null) {
            System.out.print("Enter new task title: ");
            String title = scanner.nextLine();
            System.out.print("Enter new task text: ");
            String text = scanner.nextLine();

            Task updatedTask = new Task(taskId, title, text);
            taskDAO.updateTask(updatedTask);
        } else {
            System.out.println("Task with ID " + taskId + " not found.");
        }
    }

    private static void deleteTask() {
        System.out.print("Enter task ID to delete: ");
        int taskId = scanner.nextInt();
        scanner.nextLine();

        Task existingTask = taskDAO.searchTask(taskId);
        if (existingTask != null) {
            taskDAO.deleteTask(taskId);
        } else {
            System.out.println("Task with ID " + taskId + " not found.");
        }
    }

    private static void searchTask() {
        System.out.print("Enter task ID to search: ");
        int taskId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Task task = taskDAO.searchTask(taskId);
        if (task != null) {
            System.out.println("Task found:");
            System.out.println(task);
        } else {
            System.out.println("Task with ID " + taskId + " not found.");
        }
    }
}