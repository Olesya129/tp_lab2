package authentication;

import user.User;

import java.lang.reflect.Field;


public class AuthenticationFacade {
    private AuthenticationService authService;
    private SessionManager sessionManager;

    public AuthenticationFacade() {
        this.authService = new AuthenticationService();
        this.sessionManager = new SessionManager();
    }

    private String getUsername(User user) {
        try {
            Field field = user.getClass().getDeclaredField("username");
            field.setAccessible(true);
            return (String) field.get(user);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean login(User user, String password) {
        String username = getUsername(user);
        if (username != null && authService.authenticate(username, password)) {
            sessionManager.createSession(username);
            System.out.println("Пользователь " + username + " успешно вошел в систему.");
            return true;
        } else {
            System.out.println("Ошибка: неверный логин или пароль.");
            return false;
        }
    }

    public void logout(User user) {
        String username = getUsername(user);
        if (username != null) {
            sessionManager.destroySession(username);
            System.out.println("Пользователь " + username + " вышел из системы.");
        }
    }
}
