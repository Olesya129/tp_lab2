package library.management.system;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    private String name;               // Имя пользователя
    private String userId;             // Уникальный идентификатор пользователя
    private List<BookCopy> borrowedBooks; // Список выданных книг

    // Конструктор для базового класса
    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
        this.borrowedBooks = new ArrayList<>();
    }

    // Геттеры для имени и идентификатора
    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    // Метод для добавления книги в список выданных
    public void borrowBook(BookCopy bookCopy) {
        if (canBorrow()) {  // Проверка лимитов
            borrowedBooks.add(bookCopy);
            bookCopy.setAvailable(false);  // Книга становится недоступной
            System.out.println(name + " borrowed: " + bookCopy.getBook().getTitle());
        } else {
            System.out.println(name + " cannot borrow more books.");
        }
    }

    // Метод для возврата книги
    public void returnBook(BookCopy bookCopy) {
        if (borrowedBooks.remove(bookCopy)) {
            bookCopy.setAvailable(true);  // Книга становится доступной
            System.out.println(name + " returned: " + bookCopy.getBook().getTitle());
        } else {
            System.out.println(name + " does not have this book.");
        }
    }

    // Шаблонный метод для проверки возможности взять книгу
    public boolean canBorrow() {
        return borrowedBooks.size() < getBorrowLimit();
    }

    // Абстрактный метод для получения лимита на количество книг
    protected abstract int getBorrowLimit();

    // Абстрактный метод для получения срока возврата
    public abstract int getLoanPeriod();

    // Метод для отображения списка выданных книг
    public void displayBorrowedBooks() {
        System.out.println(name + " borrowed books:");
        for (BookCopy bookCopy : borrowedBooks) {
            System.out.println(" - " + bookCopy.getBook().getDescription());
        }
    }
}

// Класс Student, наследник User
class Student extends User {
    private static final int BORROW_LIMIT = 3; // Лимит на количество книг
    private static final int LOAN_PERIOD = 14; // Срок возврата (в днях)

    public Student(String name, String userId) {
        super(name, userId);
    }

    @Override
    protected int getBorrowLimit() {
        return BORROW_LIMIT;
    }

    @Override
    public int getLoanPeriod() {
        return LOAN_PERIOD;
    }
}

// Класс Professor, наследник User
class Professor extends User {
    private static final int BORROW_LIMIT = 10; // Лимит на количество книг
    private static final int LOAN_PERIOD = 30; // Срок возврата (в днях)

    public Professor(String name, String userId) {
        super(name, userId);
    }

    @Override
    protected int getBorrowLimit() {
        return BORROW_LIMIT;
    }

    @Override
    public int getLoanPeriod() {
        return LOAN_PERIOD;
    }
}

// Класс Librarian, наследник User
class Librarian extends User {
    public Librarian(String name, String userId) {
        super(name, userId);
    }

    @Override
    protected int getBorrowLimit() {
        return 0; // Библиотекари не берут книги
    }

    @Override
    public int getLoanPeriod() {
        return 0; // Срок возврата не применяется
    }

    @Override
    public void borrowBook(BookCopy bookCopy) {
        System.out.println(getName() + " is a librarian and does not borrow books.");
    }

    @Override
    public void returnBook(BookCopy bookCopy) {
        System.out.println(getName() + " is a librarian and does not return books.");
    }
}
