import java.util.Scanner;

public class TodoManagerDay2{
    public static void main(String[] args){
        System.out.println("Welcome to ToDo App!\nEnter your name here:");
        Scanner in = new Scanner(System.in);
        String userName = in.next();
        System.out.println("Welcome "+ userName); 

        int choice;
        int no_of_tasks;
        int index = 0;
        String[] taskList = new String[10];

        do{
            System.out.println("Please choose an option\n");
            System.out.println("1. Enter tasks ");
            System.out.println("2. Remove a task ");
            System.out.println("3. Update a task ");
            System.out.println("4. List all tasks in ascending order ");
            System.out.println("5. List all tasks in descending order ");
            System.out.println("6. List repetitive tasks ");
            System.out.println("7. List repetitive tasks ");
            System.out.println("0. Exit");
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Please enter how many number of tasks you want to add:");
                    no_of_tasks = Integer.parseInt(in.next());
                    if (no_of_tasks+index>=1 && no_of_tasks+index<=10){
                        int noOfTasks = no_of_tasks+index;
                        for (int i=index; i<noOfTasks; i++){
                            System.out.println("Enter Task " + (i+1));
                            taskList[i] = in.next();
                            index+=1;
                        }
                    }
                    else {
                        System.out.println("You already have added " + index + " tasks today! And you can only add " + (10-index) + " tasks for today!");
                    }
        
                    
                    break;
                    
                case 2:
                    if (index>0){
                        System.out.println("Here are all the tasks for the day:");
                        for (int i = 1; i < index+1; i++){
                            System.out.println(i+". "+taskList[i-1]);
                        }
                        System.out.println("Enter the index of the task you want to remove (1 to " + index + "):");
                        int removeIndex = in.nextInt();
                        if (removeIndex >= 1 && removeIndex <= index) {
                            // Shift elements to the left starting from removeIndex
                            for (int i = removeIndex; i < index; i++) {
                                taskList[i - 1] = taskList[i];
                            }
                            // Clear the last element
                            taskList[index - 1] = null;
                            index--;
                            System.out.println("Task at index " + removeIndex + " removed successfully.");
                        } else {
                            System.out.println("Invalid index. Please enter a valid index.");
                        }
                    }
                    else{
                        System.out.println("You do not have any task added!");
                    }
                    break;

                case 3:
                    if (index>0){
                        System.out.println("Here are all the tasks for the day:");
                        for (int i = 1; i < index+1; i++){
                            System.out.println(i+". "+taskList[i-1]);
                        }
                        System.out.println("Enter the index of the task you want to update (1 to " + index + "):");
                        int updateIndex = in.nextInt();
                        if (updateIndex >= 1 && updateIndex <= index) {
                            System.out.println("Enter Task " + (updateIndex));
                            taskList[updateIndex-1] = in.next();
                            
                            System.out.println("Task at index " + updateIndex + " updated successfully.");
                        } else {
                            System.out.println("Invalid index. Please enter a valid index.");
                        }
                    }
                    else{
                        System.out.println("You do not have any task added!");
                    }
                    break;

                case 4:
                    System.out.println("Here are all the tasks in ascending order for the day:");
                    for (int i = 1; i < index+1; i++){
                        System.out.println(i+". "+taskList[i-1]);
                    }
                    break;

                case 5:
                    System.out.println("Here are all the tasks in descending order for the day:");
                    for (int i = index; i >= 1; i--){
                        System.out.println((index - i + 1)+". "+taskList[i-1]);
                    }
                    break;
                case 6:
                    String[] repetitiveTasks = new String[10]; // Increase size to accommodate more repetitive tasks
                    int index2 = 0;
                    System.out.println("Repetitive tasks:");
                    for (int i = 0; i < index; i++) {
                        for (int j = i + 1; j < index; j++) {
                            if (taskList[i] != null && taskList[j] != null && taskList[i].equals(taskList[j])) {
                                boolean isRepeated = false;
                                for (int k = 0; k < index2; k++) {
                                    if (taskList[j].equals(repetitiveTasks[k])) {
                                        isRepeated = true;
                                        break;
                                    }
                                }
                                if (!isRepeated) {
                                    repetitiveTasks[index2] = taskList[j];
                                    System.out.println((index2 + 1) + ". " + taskList[j]);
                                    index2++;
                                }
                            }
                        }
                    }
                    break;

                case 7:
                    if (index > 0) {
                        System.out.println("Enter the task you want to search for:");
                        String searchTask = in.next();
                        boolean found = false;
                        for (int i = 0; i < index; i++) {
                            if (taskList[i].equalsIgnoreCase(searchTask)) {
                                System.out.println("Task found at index " + (i + 1) + ": " + taskList[i]);
                                found = true;
                            }
                        }
                        if (!found) {
                            System.out.println("Task not found.");
                        }
                    } else {
                        System.out.println("You do not have any task added!");
                    }
                    break;
                
                case 0:
                    break;

                default:
                    System.out.println("Please enter a valid option!");
                    break;
            }
        }
        while (choice!=0);

    }
}