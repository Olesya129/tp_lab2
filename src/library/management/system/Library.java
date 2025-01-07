package library.management.system;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

// Класс Library управляет фондами библиотеки и процессами выдачи и возврата книг
public class Library {
    // Статическое поле для хранения единственного экземпляра класса
    private static Library instance;

    // Коллекции для хранения книг, пользователей и информации о выдаче книг
    private List<Book> books;
    private List<User> users;
    private List<Loan> loans;

    // Приватный конструктор, чтобы предотвратить создание объектов извне класса
    private Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        loans = new ArrayList<>();
    }

    // Публичный статический метод для получения единственного экземпляра класса
    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    // Метод для добавления новой книги в библиотеку
    public void addBook(Book book) {
        books.add(book);
    }

    // Метод для добавления нового пользователя
    public void addUser(User user) {
        users.add(user);
    }

    // Метод для создания записи о выдаче книги
    public void loanBook(BookCopy bookCopy, User user) {
        LocalDate issueDate = LocalDate.now();  // Текущая дата
        LocalDate dueDate = issueDate.plusDays(user.getLoanPeriod()); // Дата возврата
        Loan loan = new Loan(bookCopy, user, issueDate, dueDate); // Создание нового займа
        loans.add(loan);  // Добавление займа в список
    }

    // Метод для возврата книги
    public void returnBook(BookCopy bookCopy) {
        // Логика возврата книги
        for (Loan loan : loans) {
            if (loan.getBookCopy().equals(bookCopy)) {
                loans.remove(loan);
                break;
            }
        }
    }
}
