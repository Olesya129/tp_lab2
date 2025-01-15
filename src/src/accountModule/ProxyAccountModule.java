package accountModule;

// Прокси для AccountModule
public class ProxyAccountModule implements AccountModule {
    private RealAccountModule realAccountModule;  // Ссылка на реальный объект
    private String userData;

    public ProxyAccountModule(String userData) {
        this.userData = userData;
    }

    @Override
    public void getUserData() {
        // Ленивая инициализация
        if (realAccountModule == null) {
            realAccountModule = new RealAccountModule(userData);
        }
        System.out.println("Proxy: Fetching user data...");
        realAccountModule.getUserData();  // Делегирование вызова реальному объекту
    }

    @Override
    public void performAction(String action) {
        // Проверка прав доступа
        System.out.println("Proxy: Checking permissions before action.");
        if (realAccountModule == null) {
            realAccountModule = new RealAccountModule(userData);
        }
        realAccountModule.performAction(action);  // Делегирование вызова реальному объекту
    }
}
