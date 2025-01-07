package library.management.system;

public class BookCopy implements Cloneable {
    private String bookId;        // Идентификатор книги
    private Book book;            // Ссылка на объект книги (например, PrintedBook, EBook)
    private String description;   // Описание книги
    private boolean isAvailable;  // Доступность книги
    private String fileLocation;  // Местоположение файла (если это электронная книга)

    // Конструктор для создания экземпляра книги
    public BookCopy(String bookId, Book book, String description, boolean isAvailable, String fileLocation) {
        this.bookId = bookId;
        this.book = book;
        this.description = description;
        this.isAvailable = isAvailable;
        this.fileLocation = fileLocation;
    }

    // Геттеры и сеттеры
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    // Реализация паттерна Prototype
    @Override
    public BookCopy clone() {
        try {
            return (BookCopy) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
