package library.management.system;

import java.util.ArrayList;
import java.util.List;

public class Notification {
    private List<User> users; // Список пользователей, подписанных на уведомления

    public Notification() {
        this.users = new ArrayList<>();
    }

    // Метод для подписки пользователей на уведомления
    public void subscribe(User user) {
        users.add(user);
    }

    // Метод для отписки пользователя от уведомлений
    public void unsubscribe(User user) {
        users.remove(user);
    }

    // Метод для отправки уведомления всем подписанным пользователям
    public void notifyUsers(String message) {
        for (User user : users) {
            System.out.println("Sending notification to " + user.getName() + ": " + message);
        }
    }
}
