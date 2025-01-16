package notification;

import java.util.ArrayList;
import java.util.List;
import user.User;

public class Notification {
    private String message;
    private List<Observer> observers;

    // Конструктор для инициализации сообщения
    public Notification(String message) {
        this.message = message;
        this.observers = new ArrayList<>();
    }

    // Метод для получения сообщения
    public String getMessage() {
        return message;
    }

    // Метод для отправки уведомления конкретному пользователю
    public void send(User user) {
        user.update(message);  // Отправляем уведомление пользователю
    }

    // Метод для добавления наблюдателя
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Метод для удаления наблюдателя
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Метод для уведомления всех наблюдателей
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
