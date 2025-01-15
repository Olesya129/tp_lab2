package user;

public class Librarian extends User {
    @Override
    public int getNumberBooks() {
        return Integer.MAX_VALUE;  // Библиотекарь может взять неограниченное количество книг
    }

    @Override
    public int getAmountTime() {
        return Integer.MAX_VALUE;  // Библиотекарь может брать книги на неопределенный срок
    }
}
