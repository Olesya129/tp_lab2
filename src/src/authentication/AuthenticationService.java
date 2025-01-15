package authentication;

public class AuthenticationService {
    public boolean authenticate(String username, String password) {
        System.out.println("Проверка логина и пароля...");
        // Простая имитация проверки логина и пароля
        return "user".equals(username) && "password".equals(password);
    }
}