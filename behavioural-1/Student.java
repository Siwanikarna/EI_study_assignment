
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student {
    private static final Logger LOGGER = Logger.getLogger(Student.class.getName());
    private String name;
    private String grade;

    public Student(String name) {
        this.name = name;
        this.grade = "N/A"; // Default grade
    }

    public String getName() {
        return name;
    }

    public void notifyGradeUpdate(String newGrade) {
        this.grade = newGrade; // Update student's specific grade
        System.out.println(name + " has been notified with new grade: " + newGrade);
        LOGGER.log(Level.INFO, "Notified student {0} of new grade: {1}", new Object[]{name, newGrade});
    }
}
