package ratingSystem;

import user.User;

// Класс для представления отзыва пользователя
class Review implements RatingComponent {
    private User user;    // Имя пользователя, оставившего отзыв
    private String comment; // Комментарий от пользователя

    // Конструктор, инициализирующий отзыв
    public Review(User user, String comment) {
        this.user = user;
        this.comment = comment;
    }

    // Метод для отображения отзыва
    @Override
    public void display() {
        System.out.println("Отзыв от пользователя " + user + ": " + comment);
    }
}
