package ratingSystem;

import book.Book;
import user.User;
import java.util.ArrayList;
import java.util.List;

// Класс для системы рейтингов, которая позволяет пользователям оценивать книги и оставлять отзывы
public class RatingSystem {
    private List<Rating> ratings; // Список всех рейтингов

    public RatingSystem() {
        ratings = new ArrayList<>();
    }

    // Метод для добавления рейтинга для книги
    public void addRating(Book book, int rating) {
        Rating ratingObj = findRating(book);
        if (ratingObj == null) {
            ratingObj = new Rating(book, rating);
            ratings.add(ratingObj);
        } else {
            ratingObj.addRating(rating);  // Добавляем новый рейтинг для книги
        }
    }

    // Метод для добавления отзыва к книге
    public void addReview(Book book, User user, String reviewText) {
        Rating rating = findRating(book);
        if (rating != null) {
            Review review = new Review(user, reviewText);
            rating.addReview(review);  // Добавляем отзыв к рейтингу книги
        }
    }

    // Метод для поиска рейтинга книги
    private Rating findRating(Book book) {
        for (Rating rating : ratings) {
            if (rating.getBook().equals(book)) {
                return rating;
            }
        }
        return null;  // Если рейтинг для книги не найден
    }

    // Метод для отображения всех рейтингов
    public void displayAllRatings() {
        for (Rating rating : ratings) {
            rating.display();
        }
    }
}
