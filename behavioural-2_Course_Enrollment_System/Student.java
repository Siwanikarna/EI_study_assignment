public class Student {
    private String name;
    private Course course;

    // Constructor to accept student name
    public Student(String name) {
        this.name = name;
    }

    // Getters
    public String getName() {
        return name;
    }

    public Course getCourse() {
        return course;
    }

    // Method to enroll in a course
    public void enrollInCourse(Course course) {
        this.course = course;
        System.out.println("Student " + name + " enrolled in " + course.getName());
    }
}
