// GoogleBooksProvider.java
public class GoogleBooksProvider implements eBookProvider {
    @Override
    public String fetchEBook(String bookTitle) {
        return "Fetched \"" + bookTitle + "\" from Google Books.";
    }
}