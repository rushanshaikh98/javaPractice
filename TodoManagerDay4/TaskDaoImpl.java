public class TaskDaoImpl implements TaskDAO{
    private Task[] tasks;
    private int nextTaskId;
    private int totalTask;

    public TaskDaoImpl(int maxSize) {
        tasks = new Task[maxSize];
        nextTaskId = 1;
        totalTask = 0;
    }

    @Override
    public void addTask(Task task) {
        task.setTaskId(nextTaskId);
        tasks[totalTask] = task;
        nextTaskId++;
        totalTask++;
    }

    @Override
    public void updateTask(Task updatedTask) {
        for (Task task: tasks){
            if (task.getTaskId() == updatedTask.getTaskId()){
                task.setTaskTitle(updatedTask.getTaskTitle());
                task.setTaskText(updatedTask.getTaskText());
                return;
            }
        }
        System.out.println("Task with ID " + updatedTask.getTaskId() + " not found!");
    }

    @Override
    public void deleteTask(int taskId) {
        for (Task task: tasks){
            if (task!=null){
                if (task.getTaskId() == taskId) {
                    task.setTaskTitle(null);
                }
            }
        }
    }

    @Override
    public Task searchTask(int taskId) {
        for (Task task : tasks) {
            if (task != null){
                if (task.getTaskId() == taskId) {
                    return task;
                }
            }
        }
        return null;
    }

    public void assignTask(String username, int taskId){
        for (Task task : tasks) {
            if (task != null){
                if (task.getTaskId() == taskId) {
                    task.setAssignedTo(username);
                    System.out.println("Task successfully assigned to the user!");
                    break;
                }
            }
        }
    }

    public Task[] getAllTasks() {
        int count = 0;
        for (Task task : tasks) {
            if (task != null) {
                if (task.getTaskTitle()!=null){
                    count++;
                }
            }
        }
        Task[] nonNullTasks = new Task[count];
        int index = 0;
        for (Task task : tasks) {
            if (task != null) {
                if (task.getTaskTitle()!=null){
                    nonNullTasks[index++] = task;
                }
            }
        }
        return nonNullTasks;
    }

    public Task[] getTasksofCurrentUser(String username) {
        System.out.println(username);
        int count = 0;
        for (Task task : tasks) {
            if (task != null) {
                if (task.getAssignedTo().equals(username)){
                    
                    count++;
                }
            }
        }
        Task[] nonNullTasks = new Task[count];
        int index = 0;
        for (Task task : tasks) {
            if (task != null) {
                if (task.getAssignedTo().equals(username)){
                    nonNullTasks[index++] = task;
                }
            }
        }
        return nonNullTasks;
    }
}
