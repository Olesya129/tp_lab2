package bookCopy;

import book.Book;
import java.util.UUID;

// Класс BookCopy (конкретный прототип)
public class BookCopy implements Prototype {
    private final String id;  // Уникальный идентификатор экземпляра книги
    private final Book book;  // Ссылка на книгу (объект, который описывает книгу)

    // Конструктор, который принимает книгу и создает новый экземпляр с уникальным ID
    public BookCopy(Book book) {
        this.book = book;
        this.id = UUID.randomUUID().toString(); // Генерация уникального идентификатора
    }

    // Получить ID экземпляра книги
    public String getId() {
        return id;
    }

    // Получить саму книгу
    public Book getBook() {
        return book;
    }

    // Реализация метода clone из интерфейса Prototype
    @Override
    public BookCopy clone() {
        // Возвращаем новый экземпляр с тем же типом книги
        return new BookCopy(book);
    }
}
