package ToDoListManager;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private TaskList taskList;

    public User(String name) {
        this.name = name;
        this.taskList = new TaskList();
    }

    public String getName() {
        return name;
    }

    public void addTask(String description) {
        taskList.addTask(new Task(description));
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < taskList.size()) {
            taskList.markTaskAsCompleted(index);
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid task number. Please try again.");
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < taskList.size()) {
            taskList.deleteTask(index);
            System.out.println("Task deleted.");
        } else {
            System.out.println("Invalid task number. Please try again.");
        }
    }

    public void printTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("Tasks for " + name + ":");
            taskList.printTasks();
        }
    }
}