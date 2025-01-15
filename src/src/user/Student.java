package user;

public class Student extends User {
    @Override
    public int getNumberBooks() {
        return 3;  // Студент может взять не более 3 книг
    }

    @Override
    public int getAmountTime() {
        return 14;  // Студент может брать книги на 14 дней
    }
}
