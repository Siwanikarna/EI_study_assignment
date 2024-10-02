import java.util.ArrayList;

public class LMS {
    private ArrayList<Course> courses;
    private ArrayList<Instructor> instructors;

    public LMS() {
        this.courses = new ArrayList<>();
        this.instructors = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
    }

    public void enrollStudentInCourse(Student student, Course course) {
        course.enrollStudent(student);
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void listCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            for (int i = 0; i < courses.size(); i++) {
                System.out.println((i + 1) + ". " + courses.get(i).getName());
            }
        }
    }
}
