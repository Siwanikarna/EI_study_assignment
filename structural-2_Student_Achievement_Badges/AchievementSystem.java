// Filename: AchievementSystem.java
import java.util.ArrayList;
import java.util.List;

public class AchievementSystem {
    private List<Student> students;

    public AchievementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(String name) {
        students.add(new Student(name));
    }

    public Student getStudent(String name) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null; // Student not found
    }

    public void awardBadge(String studentName, Badge badge) {
        Student student = getStudent(studentName);
        if (student != null) {
            student.awardBadge(badge);
        }
    }

    public void displayBadges(String studentName) {
        Student student = getStudent(studentName);
        if (student != null) {
            System.out.println("Badges for :" + studentName);
            for (Badge badge : student.getBadges()) {
                System.out.println(badge);
            }
        } else {
            System.out.println("Student not found.");
        }
    }
}
