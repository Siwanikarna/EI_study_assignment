import java.util.List;

public class TaskConflictObserver {
    public boolean checkConflict(Task newTask, List<Task> existingTasks) {
        for (Task task : existingTasks) {
            if (isTimeOverlap(newTask, task)) {
                System.out.println("Error: Task conflicts with existing task \"" + task.getDescription() + "\".");
                return true;
            }
        }
        return false;
    }

    private boolean isTimeOverlap(Task newTask, Task existingTask) {
        return newTask.getStartTime().compareTo(existingTask.getEndTime()) < 0 && newTask.getEndTime().compareTo(existingTask.getStartTime()) > 0;
    }
}
