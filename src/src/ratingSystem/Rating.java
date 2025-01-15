package ratingSystem;

import book.Book;
import java.util.ArrayList;
import java.util.List;

// Класс для представления общего рейтинга книги
class Rating implements RatingComponent {
    private Book book; // Связь с книгой
    private double averageRating; // Средний рейтинг книги
    private List<RatingComponent> children = new ArrayList<>(); // Список дочерних элементов (отзывов)

    // Конструктор, инициализирующий рейтинг книги
    public Rating(Book book, double averageRating) {
        this.book = book;
        this.averageRating = averageRating;
    }

    // Метод для добавления дочернего элемента (например, отзыва)
    public void add(RatingComponent component) {
        children.add(component);
    }

    // Метод для удаления дочернего элемента
    public void remove(RatingComponent component) {
        children.remove(component);
    }

    // Метод для отображения информации о рейтинге и его дочерних элементах
    @Override
    public void display() {
        System.out.println("Рейтинг книги: " + book.getTitle() + " - " + averageRating);
        for (RatingComponent component : children) {
            component.display();
        }
    }

    public Book getBook() {
        return book;
    }
}
