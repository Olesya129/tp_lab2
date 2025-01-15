package authentication;

public class AuthenticationFacade {
    private AuthenticationService authService;
    private SessionManager sessionManager;

    public AuthenticationFacade() {
        this.authService = new AuthenticationService();
        this.sessionManager = new SessionManager();
    }

    public boolean login(String username, String password) {
        if (authService.authenticate(username, password)) {
            sessionManager.createSession(username);
            System.out.println("Пользователь успешно вошел в систему.");
            return true;
        } else {
            System.out.println("Ошибка: неверный логин или пароль.");
            return false;
        }
    }

    public void logout(String username) {
        sessionManager.destroySession(username);
        System.out.println("Пользователь вышел из системы.");
    }
}