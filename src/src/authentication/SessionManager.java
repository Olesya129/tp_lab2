package authentication;

class SessionManager {
    public void createSession(String username) {
        System.out.println("Создание сессии для пользователя: " + username);
        // Логика создания сессии
    }

    public void destroySession(String username) {
        System.out.println("Удаление сессии для пользователя: " + username);
        // Логика уничтожения сессии
    }
}