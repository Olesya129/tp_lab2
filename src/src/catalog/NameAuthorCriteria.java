package catalog;

import book.Book;

public class NameAuthorCriteria implements SearchCriteria {
    private String author;

    public NameAuthorCriteria(String author) {
        this.author = author;
    }

    @Override
    public boolean match(Book book) {
        return book.getAuthor().equalsIgnoreCase(author);
    }
}
