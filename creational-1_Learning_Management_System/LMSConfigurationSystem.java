import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LMSConfigurationSystem {
    private static final Logger logger = LMSLogger.getLogger();
    private static LMS lms = new LMS();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            try {
                displayMenu();
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                switch (choice) {
                    case 1:
                        createCourse();
                        break;
                    case 2:
                        addInstructor();
                        break;
                    case 3:
                        enrollStudent();
                        break;
                    case 4:
                        viewCourses();
                        break;
                    case 5:
                        logger.info("Exiting system.");
                        running = false;
                        break;
                    default:
                        logger.warning("Invalid option chosen.");
                }
            } catch (Exception e) {
                logger.log(Level.SEVERE, "An error occurred: " + e.getMessage(), e);
                scanner.nextLine();  // Clear the invalid input
            }
        }
    }

    private static void displayMenu() {
        logger.info("Displaying menu to the user...");
        System.out.println("1. Create a Course");
        System.out.println("2. Add an Instructor");
        System.out.println("3. Enroll a Student");
        System.out.println("4. View Courses");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private static void createCourse() {
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        Course course = new Course(courseName);
        lms.addCourse(course);
        logger.info("Created course: " + courseName);
        System.out.println("Course '" + courseName + "' created.");
    }

    private static void addInstructor() {
        System.out.print("Enter instructor name: ");
        String instructorName = scanner.nextLine();
        Instructor instructor = new Instructor(instructorName);
        lms.addInstructor(instructor);
        logger.info("Added instructor: " + instructorName);
        System.out.println("Instructor '" + instructorName + "' added.");
    }

    private static void enrollStudent() {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        Student student = new Student(studentName);
        System.out.println("Available courses: ");
        lms.listCourses();
        System.out.print("Choose a course by number to enroll in: ");
        int courseIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline
        if (courseIndex >= 0 && courseIndex < lms.getCourses().size()) {
            Course selectedCourse = lms.getCourses().get(courseIndex);
            lms.enrollStudentInCourse(student, selectedCourse);
            logger.info("Enrolled student " + studentName + " in course: " + selectedCourse.getName());
            System.out.println("Student '" + studentName + "' enrolled in course: " + selectedCourse.getName());
        } else {
            System.out.println("Invalid course selection.");
            logger.warning("Invalid course selection made.");
        }
    }

    private static void viewCourses() {
        lms.listCourses();
    }
}
