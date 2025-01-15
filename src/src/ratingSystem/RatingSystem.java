package ratingSystem;

import book.Book;
import user.User;

import java.util.ArrayList;
import java.util.List;

// Класс для системы рейтингов, которая позволяет пользователям оценивать книги и оставлять отзывы
public class RatingSystem {
    private List<Rating> ratings;

    public RatingSystem() {
        ratings = new ArrayList<>();
    }

    // Метод для добавления рейтинга для книги
    public void addRating(Book book, double averageRating) {
        Rating rating = new Rating(book, averageRating);
        ratings.add(rating);
    }

    // Метод для добавления отзыва к книге
    public void addReview(Book book, User user, String comment) {
        Rating rating = findRating(book);
        if (rating != null) {
            Review review = new Review(user, comment);  // Передаем объект User напрямую
            rating.add(review);
            System.out.println("Отзыв пользователя " + user + " для книги " + book.getTitle() + " добавлен.");
        }
    }

    // Метод для поиска рейтинга книги
    private Rating findRating(Book book) {
        for (Rating rating : ratings) {
            if (rating.getBook().equals(book)) {
                return rating;
            }
        }
        return null;
    }

    // Метод для отображения всех рейтингов
    public void displayAllRatings() {
        for (Rating rating : ratings) {
            rating.display();
        }
    }
}
