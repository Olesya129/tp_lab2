package catalog.storage;

import book.Book;
import java.util.List;

public interface Storage {
    void saveBook(Book book);
    List<Book> loadBooks();
}
