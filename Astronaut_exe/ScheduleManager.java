import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks;
    private TaskConflictObserver observer;
    private TaskFactory taskFactory;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observer = new TaskConflictObserver();
        taskFactory = new TaskFactory();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addTask(String description, String startTime, String endTime, String priority) {
        try {
            Task newTask = taskFactory.createTask(description, startTime, endTime, priority);
            if (!observer.checkConflict(newTask, tasks)) {
                tasks.add(newTask);
                System.out.println("Task added successfully. No conflicts.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void removeTask(String description) {
        Task taskToRemove = findTaskByDescription(description);
        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Error: Task not found.");
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
            return;
        }
        Collections.sort(tasks, Comparator.comparing(Task::getStartTime));
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void markTaskCompleted(String description) {
        Task task = findTaskByDescription(description);
        if (task != null) {
            task.setCompleted(true);
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Error: Task not found.");
        }
    }

    private Task findTaskByDescription(String description) {
        return tasks.stream()
                .filter(task -> task.getDescription().equalsIgnoreCase(description))
                .findFirst()
                .orElse(null);
    }
}
