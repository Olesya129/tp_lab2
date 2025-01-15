package catalog;

import book.Book;

public interface SearchCriteria {
    boolean match(Book book);
}
