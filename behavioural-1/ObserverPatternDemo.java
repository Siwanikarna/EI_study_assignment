import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

// Main Demo class
public class ObserverPatternDemo {
    private static final Logger LOGGER = Logger.getLogger(ObserverPatternDemo.class.getName());

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Gathering input from users
        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;
            while (!exit) {
                // Show menu options first
                System.out.println("1. Add Student\n2. Remove Student\n3. Update Grade\n4. Exit");
                System.out.print("Choose an option: ");
                String option = scanner.nextLine();

                switch (option) {
                    case "1":
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        Student student = new Student(name);
                        students.add(student);
                        LOGGER.log(Level.INFO, "Added student: {0}", name);
                        System.out.println("Student added: " + name); // Inform the user
                        break;
                    case "2":
                        System.out.print("Enter student name to remove: ");
                        name = scanner.nextLine();
                        Student studentToRemove = findStudent(students, name);
                        if (studentToRemove != null) {
                            students.remove(studentToRemove);
                            LOGGER.log(Level.INFO, "Removed student: {0}", name);
                            System.out.println("Student removed: " + name); // Inform the user
                        } else {
                            LOGGER.log(Level.WARNING, "Student {0} not found", name);
                            System.out.println("Student not found: " + name); // Inform the user
                        }
                        break;
                    case "3":
                        if (students.isEmpty()) {
                            System.out.println("No students available to update grade.");
                        } else {
                            // Display list of students
                            System.out.println("Students:");
                            for (int i = 0; i < students.size(); i++) {
                                System.out.println((i + 1) + ". " + students.get(i).getName());
                            }

                            System.out.print("Choose a student by number to update grade: ");
                            int studentIndex = Integer.parseInt(scanner.nextLine()) - 1;

                            if (studentIndex >= 0 && studentIndex < students.size()) {
                                Student selectedStudent = students.get(studentIndex);
                                System.out.print("Enter new grade for " + selectedStudent.getName() + ": ");
                                String grade = scanner.nextLine();

                                selectedStudent.notifyGradeUpdate(grade);  // Notify only the selected student

                                System.out.println("Grade updated to: " + grade + " for " + selectedStudent.getName());
                            } else {
                                System.out.println("Invalid student selection.");
                            }
                        }
                        break;
                    case "4":
                        exit = true;
                        LOGGER.log(Level.INFO, "Exiting the system.");
                        System.out.println("Exiting the system."); // Inform the user
                        break;
                    default:
                        System.out.println("Invalid option, please try again.");
                }
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error in the system: ", e);
        }
    }

    private static Student findStudent(List<Student> students, String name) {
        return students.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
    }
}
