package catalog;
import book.Book;

public class NameBookCriteria implements SearchCriteria {
    private String title;

    public NameBookCriteria(String title) {
        this.title = title;
    }

    @Override
    public boolean match(Book book) {
        return book.getTitle().equalsIgnoreCase(title);
    }

    @Override
    public SearchCriteria createCriteria(String value) {
        return new NameBookCriteria(value);
    }
}

