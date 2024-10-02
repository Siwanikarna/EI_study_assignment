// Filename: Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AchievementSystem achievementSystem = new AchievementSystem();

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Award Badge");
            System.out.println("3. View Badges");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    achievementSystem.addStudent(studentName);
                    System.out.println("Student added: " + studentName);
                    break;

                case 2:
                    System.out.print("Enter student name: ");
                    String badgeStudentName = scanner.nextLine();
                    System.out.print("Enter badge name: ");
                    String badgeName = scanner.nextLine();
                    System.out.print("Enter badge description: ");
                    String badgeDescription = scanner.nextLine();
                    Badge badge = new Badge(badgeName, badgeDescription);
                    achievementSystem.awardBadge(badgeStudentName, badge);
                    System.out.println("Badge awarded to " + badgeStudentName);
                    break;

                case 3:
                    System.out.print("Enter student name: ");
                    String viewStudentName = scanner.nextLine();
                    achievementSystem.displayBadges(viewStudentName);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
