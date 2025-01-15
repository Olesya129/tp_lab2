package ratingSystem;
import java.util.ArrayList;
import java.util.List;

// Класс для представления общего рейтинга книги
class Rating implements RatingComponent {
    private String bookTitle;              // Название книги
    private double averageRating;          // Средний рейтинг книги
    private List<RatingComponent> children = new ArrayList<>(); // Список дочерних элементов (отзывов)

    // Конструктор, инициализирующий рейтинг книги
    public Rating(String bookTitle, double averageRating) {
        this.bookTitle = bookTitle;
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
        // Реализация отображения рейтинга и дочерних компонентов
    }
}
