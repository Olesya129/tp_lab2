package user;

public class Professor extends User {
    @Override
    public int getNumberBooks() {
        return 10;  // Преподаватель может взять до 10 книг
    }

    @Override
    public int getAmountTime() {
        return 30;  // Преподаватель может брать книги на 30 дней
    }
}

