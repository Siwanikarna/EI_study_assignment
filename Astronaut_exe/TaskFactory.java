public class TaskFactory {
    public Task createTask(String description, String startTime, String endTime, String priority) throws IllegalArgumentException {
        if (!isValidTimeFormat(startTime) || !isValidTimeFormat(endTime)) {
            throw new IllegalArgumentException("Invalid time format.");
        }
        if (!isValidPriority(priority)) {
            throw new IllegalArgumentException("Invalid priority level. Use High, Medium, or Low.");
        }
        return new Task(description, startTime, endTime, priority);
    }

    private boolean isValidTimeFormat(String time) {
        return time.matches("([01]?\\d|2[0-3]):[0-5]\\d");
    }

    private boolean isValidPriority(String priority) {
        return priority.equalsIgnoreCase("High") || priority.equalsIgnoreCase("Medium") || priority.equalsIgnoreCase("Low");
    }
}
