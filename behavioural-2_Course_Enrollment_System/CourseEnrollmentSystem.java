import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CourseEnrollmentSystem {

    private static final Logger logger = Logger.getLogger(CourseEnrollmentSystem.class.getName());
    private static ArrayList<Student> students = new ArrayList<>();
    private static ArrayList<Course> courses = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        setupCourses();

        boolean running = true;
        while (running) {
            // Call menu after each action
            System.out.println("1. Enroll Student in a Course");
            System.out.println("2. Remove Student from a Course");
            System.out.println("3. View Enrolled Students");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    enrollStudent(scanner);
                    break;
                case 2:
                    removeStudent(scanner);
                    break;
                case 3:
                    viewEnrolledStudents();
                    break;
                case 4:
                    running = false;
                    logger.info("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose a valid option.");
                    logger.warning("User selected an invalid option.");
            }
        }
        scanner.close();
    }

    // Setup courses
    private static void setupCourses() {
        courses.add(new Course("Mathematics"));
        courses.add(new Course("Computer Science"));
        courses.add(new Course("Physics"));
        courses.add(new Course("Chemistry"));
    }

    // Enroll a student
    private static void enrollStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        Student student = new Student(studentName);

        System.out.println("Available courses: ");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i).getName());
        }
        System.out.println("\nChoose a course by number to enroll in: ");
        int courseIndex = scanner.nextInt() - 1;
        scanner.nextLine();  // Consume the newline character

        if (courseIndex >= 0 && courseIndex < courses.size()) {
            Course selectedCourse = courses.get(courseIndex);
            student.enrollInCourse(selectedCourse);
            students.add(student);
            logger.info("Student " + studentName + " enrolled in course: " + selectedCourse.getName());
            System.out.println("Student " + studentName + " enrolled in " + selectedCourse.getName()); // Display before next menu
        } else {
            System.out.println("Invalid course selection.");
            logger.warning("Invalid course selected by the user.");
        }
    }

    // Remove a student
    private static void removeStudent(Scanner scanner) {
        if (students.isEmpty()) {
            System.out.println("No students enrolled.");
            return;
        }

        System.out.println("Enrolled students: ");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getName());
        }
        System.out.print("Choose a student by number to remove: ");
        int studentIndex = scanner.nextInt() - 1;
        scanner.nextLine();  // Consume the newline character

        if (studentIndex >= 0 && studentIndex < students.size()) {
            Student removedStudent = students.remove(studentIndex);
            logger.info("Student " + removedStudent.getName() + " removed from the course.");
            System.out.println("Removed student: " + removedStudent.getName());  // Display before next menu
        } else {
            System.out.println("Invalid student selection.");
            logger.warning("Invalid student selection made by the user.");
        }
    }

    // View enrolled students
    private static void viewEnrolledStudents() {
        if (students.isEmpty()) {
            System.out.println("No students enrolled.");
            logger.info("No students to display.");
        } else {
            System.out.println("List of enrolled students:");
            for (Student student : students) {
                System.out.println("Student: " + student.getName() + ", Enrolled in: " + student.getCourse().getName());
                logger.info("Displaying student: " + student.getName());
            }
        }
    }
}
