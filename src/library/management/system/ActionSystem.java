package library.management.system;

import java.util.ArrayList;
import java.util.List;

// Класс для хранения истории действий пользователя
public class ActionSystem {
    private List<String> actionHistory = new ArrayList<>(); // Список для хранения истории действий

    // Метод для сохранения действия в истории
    public void saveAction(String action) {
        actionHistory.add(action);
    }

    // Метод для отображения всей истории действий
    public void displayHistory() {
        if (actionHistory.isEmpty()) {
            System.out.println("No actions recorded.");
        } else {
            System.out.println("Action history:");
            for (String action : actionHistory) {
                System.out.println(action);
            }
        }
    }

    // Метод для отмены последнего действия (паттерн Memento)
    public String undoAction() {
        if (actionHistory.isEmpty()) {
            System.out.println("No actions to undo.");
            return null;
        }
        // Получаем последнее действие и удаляем его из истории
        String lastAction = actionHistory.remove(actionHistory.size() - 1);
        System.out.println("Undone action: " + lastAction);
        return lastAction;
    }
}
