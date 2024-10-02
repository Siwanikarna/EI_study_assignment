import java.util.ArrayList;

public class Course {
    private String name;
    private Instructor instructor;
    private ArrayList<Student> enrolledStudents;

    public Course(String name) {
        this.name = name;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
}
