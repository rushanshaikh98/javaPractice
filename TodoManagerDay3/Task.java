public class Task {
    private int TaskId;
    private String taskTitle;
    private String taskText;
    // private String assignedTo;


    public Task(int TaskId, String taskTitle, String taskText) {
        this.TaskId = TaskId;
        this.taskTitle = taskTitle;
        this.taskText = taskText;
        // this.assignedTo = assignedTo;
    }

    public int getTaskId() {
        return TaskId;
    }

    public void setTaskId(int TaskId) {
        this.TaskId = TaskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskText() {
        return taskText;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + TaskId +
                ", taskTitle='" + taskTitle + '\'' +
                ", taskText='" + taskText + '\'' +
                '}';
    }
    // public String getAssignedTo() {
    //     return assignedTo;
    // }

    // public void setAssignedTo(String assignedTo) {
    //     this.assignedTo = assignedTo;
    // }
}
