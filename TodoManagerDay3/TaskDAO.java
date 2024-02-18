public class TaskDAO {
    private Task[] tasks = new Task[100];
    private int nextTaskId = 1;
    private int totalTask = 0;
    
    public void addTask(Task task){
        task.setTaskId(nextTaskId);
        tasks[totalTask] = task;
        nextTaskId++;
        totalTask++;
    }

    public void updateTask(Task updatedTask){
        for (Task task: tasks){
            if (task.getTaskId() == updatedTask.getTaskId()){
                task.setTaskTitle(updatedTask.getTaskTitle());
                task.setTaskText(updatedTask.getTaskText());
                return;
            }
        }
        System.out.println("Task with ID " + updatedTask.getTaskId() + " not found!");
    }

    public void deleteTask(int taskId) {
        for (Task task: tasks){
            if (task!=null){
                if (task.getTaskId() == taskId) {
                    task.setTaskTitle(null);
                }
            }
        }
    }

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
}
