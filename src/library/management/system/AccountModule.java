package library.management.system;

// Класс AccountModule управляет учетной записью пользователя
public class AccountModule {
    private String userId;
    private String password;

    // Конструктор
    public AccountModule(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    // Метод для проверки данных пользователя
    public boolean authenticate(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    // Метод для получения ID пользователя
    public String getUserId() {
        return userId;
    }

    // Метод для изменения пароля
    public void changePassword(String oldPassword, String newPassword) {
        if (authenticate(oldPassword)) {
            this.password = newPassword;
            System.out.println("Password successfully changed.");
        } else {
            System.out.println("Authentication failed. Password not changed.");
        }
    }

    // Метод для получения информации об учетной записи
    public String getAccountDetails() {
        return "User ID: " + userId;
    }
}

// Прокси-класс для AccountModule
class AccountModuleProxy {
    private AccountModule accountModule;
    private boolean isAdmin;

    // Конструктор прокси-класса
    public AccountModuleProxy(AccountModule accountModule, boolean isAdmin) {
        this.accountModule = accountModule;
        this.isAdmin = isAdmin;
    }

    // Метод для проверки прав доступа
    private void checkAccess() {
        if (!isAdmin) {
            throw new SecurityException("Access denied. Only admin can perform this operation.");
        }
    }

    // Прокси для изменения пароля
    public void changePassword(String oldPassword, String newPassword) {
        checkAccess(); // Проверка прав доступа
        accountModule.changePassword(oldPassword, newPassword);
    }
}


