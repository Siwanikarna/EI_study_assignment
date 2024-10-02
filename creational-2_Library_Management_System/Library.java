import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    // Add a new book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Clone an existing book
    public void cloneBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                Book clonedBook = book.clone();
                if (clonedBook != null) {
                    books.add(clonedBook);
                }
                return;
            }
        }
        System.out.println("Book with ISBN " + isbn + " not found for cloning.");
    }

    // Display all books
    public void displayBooks() {
        System.out.println("Displaying all books in the library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
