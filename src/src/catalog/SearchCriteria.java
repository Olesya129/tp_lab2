package catalog;
import book.Book;

public interface SearchCriteria {
    boolean match(Book book);
    SearchCriteria createCriteria(String value);  // Метод для создания критериев
}
