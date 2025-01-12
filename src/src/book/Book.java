package book;

// Базовый класс Книга
public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Метод для получения информации о книге
    public String getData() {
        return "Title: " + title + ", Author: " + author;
    }
}
