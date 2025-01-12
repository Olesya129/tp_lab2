package catalog;
import book.Book;
import java.util.ArrayList;
import java.util.List;


public class Catalog {

    private List<Book> books;

    // Конструктор принимает список книг
    public Catalog(List<Book> books) {
        this.books = books;
    }

    // Метод поиска по заданному критерию
    public List<Book> search(SearchCriteria criteria) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (criteria.match(book)) {
                result.add(book);
            }
        }
        return result;
    }
}

