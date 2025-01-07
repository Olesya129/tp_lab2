package library.management.system;

import java.util.ArrayList;
import java.util.List;

// Класс Catalog отвечает за поиск книг по разным критериям
public class Catalog {
    private List<Book> books;

    // Конструктор инициализирует пустую коллекцию книг
    public Catalog() {
        this.books = new ArrayList<>();
    }

    // Метод для добавления книги в каталог
    public void addBook(Book book) {
        books.add(book);
    }

    // Метод поиска книг по критерию
    public List<Book> search(SearchCriteria criteria) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (criteria.matches(book)) {
                result.add(book);
            }
        }
        return result;
    }
}

// Интерфейс для критериев поиска
interface SearchCriteria {
    boolean matches(Book book);
}

// Класс для поиска по названию
class TitleSearchCriteria implements SearchCriteria {
    private String title;

    public TitleSearchCriteria(String title) {
        this.title = title;
    }

    @Override
    public boolean matches(Book book) {
        return book.getTitle().equalsIgnoreCase(title);
    }
}

// Класс для поиска по автору
class AuthorSearchCriteria implements SearchCriteria {
    private String author;

    public AuthorSearchCriteria(String author) {
        this.author = author;
    }

    @Override
    public boolean matches(Book book) {
        return book.getAuthor().equalsIgnoreCase(author);
    }
}
