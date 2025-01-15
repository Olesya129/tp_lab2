package accountModule;

// Реальная реализация интерфейса
public class RealAccountModule implements AccountModule {
    private String userData;

    public RealAccountModule(String userData) {
        this.userData = userData;
    }

    @Override
    public void getUserData() {
        // Возвращает данные пользователя
        System.out.println("User data: " + userData);
    }

    @Override
    public void performAction(String action) {
        // Выполняет действие
        System.out.println("Performing action: " + action);
    }
}
