package ratingSystem;

import book.Book;
import java.util.ArrayList;
import java.util.List;

// Класс для представления общего рейтинга книги
class Rating {
    private Book book;  // Связь с книгой
    private List<Integer> ratings;  // Список всех рейтингов
    private List<Review> reviews;  // Список отзывов

    public Rating(Book book, int rating) {
        this.book = book;
        this.ratings = new ArrayList<>();
        this.reviews = new ArrayList<>();
        addRating(rating);  // Инициализируем рейтинг
    }

    // Метод для добавления нового рейтинга
    public void addRating(int rating) {
        ratings.add(rating);
    }

    // Метод для добавления нового отзыва
    public void addReview(Review review) {
        reviews.add(review);
    }

    public Book getBook() {
        return book;
    }

    // Метод для вычисления среднего рейтинга
    public double getAverageRating() {
        if (ratings.isEmpty()) {
            return 0;
        }
        int sum = 0;
        for (int rating : ratings) {
            sum += rating;
        }
        return sum / (double) ratings.size();
    }

    // Метод для отображения информации о рейтинге и отзывах
    public void display() {
        System.out.println("Рейтинг книги: " + book.getTitle() + " - Средний рейтинг: " + getAverageRating());
        for (Review review : reviews) {
            review.display();
        }
    }
}
