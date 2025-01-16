package catalog;

import book.Book;
import catalog.storage.Storage;
import java.util.List;
import java.util.stream.Collectors;

public class Catalog {
    private Storage storage;

    public Catalog(Storage storage) {
        this.storage = storage;
    }

    public void addBook(Book book) {
        storage.saveBook(book);
    }

    public List<Book> search(SearchCriteria criteria) {
        List<Book> books = storage.loadBooks();
        return books.stream()
                .filter(criteria::match)
                .collect(Collectors.toList());
    }
}
