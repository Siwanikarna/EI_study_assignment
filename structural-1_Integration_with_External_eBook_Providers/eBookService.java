// eBookService.java
public class eBookService {
    private eBookProvider provider;

    public eBookService(eBookProvider provider) {
        this.provider = provider;
    }

    public void setProvider(eBookProvider provider) {
        this.provider = provider;
    }

    public String getEBook(String bookTitle) {
        return provider.fetchEBook(bookTitle);
    }
}
