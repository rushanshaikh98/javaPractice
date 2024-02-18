public interface TaskDAO {
    // Define methods for task data access
    void addTask(Task task);
    void updateTask(Task task);
    void deleteTask(int taskId);
    Task searchTask(int taskId);
}
