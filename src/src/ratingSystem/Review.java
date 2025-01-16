package ratingSystem;

import user.User;

// Класс для представления отзыва пользователя
class Review {
    private User user;  // Пользователь, который оставил отзыв
    private String comment;  // Текст отзыва

    public Review(User user, String comment) {
        this.user = user;
        this.comment = comment;
    }

    // Метод для отображения отзыва
    public void display() {
        System.out.println("Отзыв от пользователя " + user.getName() + ": " + comment);
    }
}
