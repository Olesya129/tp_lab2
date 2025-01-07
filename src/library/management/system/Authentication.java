package library.management.system;

import java.util.HashMap;
import java.util.Map;

// Класс для авторизации и аутентификации пользователей
public class Authentication {
    private Map<String, String> userCredentials; // Список пользователей и паролей
    private User loggedInUser; // Текущий аутентифицированный пользователь

    // Конструктор для инициализации данных пользователей
    public Authentication() {
        this.userCredentials = new HashMap<>();
        // Для примера добавим несколько пользователей с паролями
        this.userCredentials.put("student1", "password123");
        this.userCredentials.put("professor1", "professorPass");
        this.userCredentials.put("librarian1", "libAdmin123");
        this.loggedInUser = null;
    }

    // Метод для аутентификации пользователя по имени и паролю
    public boolean authenticate(String username, String password) {
        if (userCredentials.containsKey(username) && userCredentials.get(username).equals(password)) {
            System.out.println("Authentication successful for user: " + username);
            loggedInUser = getUserByUsername(username);
            return true;
        }
        System.out.println("Authentication failed for user: " + username);
        return false;
    }

    // Метод для получения пользователя по имени
    private User getUserByUsername(String username) {
        switch (username) {
            case "student1":
                return new Student("Student Name", "student1");
            case "professor1":
                return new Professor("Professor Name", "professor1");
            case "librarian1":
                return new Librarian("Librarian Name", "librarian1");
            default:
                return null;
        }
    }

    // Метод для получения текущего аутентифицированного пользователя
    public User getLoggedInUser() {
        return loggedInUser;
    }

    // Метод для выхода из системы
    public void logout() {
        System.out.println("User logged out.");
        loggedInUser = null;
    }

    // Метод для проверки, аутентифицирован ли пользователь
    public boolean isAuthenticated() {
        return loggedInUser != null;
    }
}
