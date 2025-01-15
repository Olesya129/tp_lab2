package ratingSystem;


// Класс для представления отзыва пользователя
class Review implements RatingComponent {
    private String user;    // Имя пользователя, оставившего отзыв
    private String comment; // Комментарий от пользователя

    // Конструктор, инициализирующий отзыв
    public Review(String user, String comment) {
        this.user = user;
        this.comment = comment;
    }

    // Метод для отображения отзыва
    @Override
    public void display() {
        // Реализация отображения отзыва
    }
}

