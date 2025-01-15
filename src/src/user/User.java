package user;

import notification.Observer;

public abstract class User implements Observer {
    // Шаблонный метод, который использует абстрактные методы
    public void printUserPermissions() {
        System.out.println("Максимальное количество книг: " + getNumberBooks());
        System.out.println("Срок займа: " + getAmountTime() + " дней");
    }

    // Абстрактные методы, которые будут переопределяться в наследниках
    public abstract int getNumberBooks();
    public abstract int getAmountTime();

    // Реализация метода update из Observer
    @Override
    public void update(String message) {
        System.out.println("Уведомление для пользователя: " + message);
    }
}
