package notification;
import user.User;

public class Notification {
    private String message;

    public Notification(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void send(User user) {
        user.update(message);  // Отправляем уведомление пользователю
    }
}
