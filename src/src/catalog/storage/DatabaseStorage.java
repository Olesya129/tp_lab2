package catalog.storage;

import book.Book;
import java.util.ArrayList;
import java.util.List;

public class DatabaseStorage implements Storage {
    private List<Book> books = new ArrayList<>();

    @Override
    public void saveBook(Book book) {
        books.add(book);
        System.out.println("Книга сохранена в базе данных: " + book.getTitle());
    }

    @Override
    public List<Book> loadBooks() {
        return new ArrayList<>(books);
    }
}
