public class AmazonProvider implements eBookProvider {
    @Override
    public String fetchEBook(String bookTitle) {
        return "Fetched \"" + bookTitle + "\" from Amazon.";
    }
}