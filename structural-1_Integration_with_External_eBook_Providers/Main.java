// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initial eBook provider
        eBookProvider amazon = new AmazonProvider();
        eBookService eBookService = new eBookService(amazon);

        while (true) {
            System.out.println("1. Fetch eBook from Amazon");
            System.out.println("2. Fetch eBook from Google Books");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 3) {
                break;
            }

            System.out.print("Enter the title of the book: ");
            String bookTitle = scanner.nextLine();

            switch (choice) {
                case 1:
                    eBookService.setProvider(new AmazonProvider());
                    System.out.println(eBookService.getEBook(bookTitle));
                    break;
                case 2:
                    eBookService.setProvider(new GoogleBooksProvider());
                    System.out.println(eBookService.getEBook(bookTitle));
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
