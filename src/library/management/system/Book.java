package library.management.system;

// Базовый класс Book
public abstract class Book {
    private String title;
    private String author;

    // Конструктор для инициализации общих свойств книги
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Геттеры для получения названия и автора книги
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Абстрактный метод для получения описания книги
    public abstract String getDescription();
}

// Класс EBook, наследник Book
class EBook extends Book {
    private double fileSize; // Размер файла в мегабайтах
    private String format;   // Формат файла (например, PDF, EPUB)

    public EBook(String title, String author, double fileSize, String format) {
        super(title, author);
        this.fileSize = fileSize;
        this.format = format;
    }

    @Override
    public String getDescription() {
        return getTitle() + " by " + getAuthor() + " (EBook, " + fileSize + "MB, Format: " + format + ")";
    }
}

// Класс PrintedBook, наследник Book
class PrintedBook extends Book {
    private String shelfLocation; // Местоположение книги на полке

    public PrintedBook(String title, String author, String shelfLocation) {
        super(title, author);
        this.shelfLocation = shelfLocation;
    }

    @Override
    public String getDescription() {
        return getTitle() + " by " + getAuthor() + " (Printed, Shelf Location: " + shelfLocation + ")";
    }
}

// Класс Magazine, наследник Book
class Magazine extends Book {
    private int issueNumber;      // Номер выпуска
    private String publicationDate; // Дата публикации

    public Magazine(String title, String author, int issueNumber, String publicationDate) {
        super(title, author);
        this.issueNumber = issueNumber;
        this.publicationDate = publicationDate;
    }

    @Override
    public String getDescription() {
        return getTitle() + " by " + getAuthor() + " (Magazine, Issue: " + issueNumber + ", Published on: " + publicationDate + ")";
    }
}
