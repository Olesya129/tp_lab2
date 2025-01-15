package library;
import notification.Notification;
import notification.Observer;
import notification.Subject;
import book.Book;
import bookCopy.BookCopy;
import user.User;
import loan.Loan;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library implements Subject {
    private static Library instance;
    private List<Book> books;
    private List<User> users;
    private List<Loan> loans;
    private List<Observer> observers;

    private Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        loans = new ArrayList<>();
        observers = new ArrayList<>();
    }

    // Метод для получения единственного экземпляра библиотеки
    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    // Метод добавления книги в библиотеку
    public void addBook(Book book) {
        books.add(book);
    }

    // Метод добавления пользователя в библиотеку
    public void addUser(User user) {
        users.add(user);
        addObserver(user);  // Добавляем пользователя как наблюдателя
    }

    // Метод для выдачи книги пользователю
    public void loanBook(BookCopy bookCopy, User user) {
        long userBookCount = loans.stream()
                .filter(loan -> loan.getUser().equals(user))
                .count();

        if (userBookCount >= user.getNumberBooks()) {
            System.out.println("Превышен лимит на количество книг для пользователя.");
            return;
        }

        LocalDate issueDate = LocalDate.now();
        LocalDate dueDate = issueDate.plusDays(user.getAmountTime());  // срок займа
        Loan loan = new Loan(bookCopy, user, issueDate, dueDate);
        loans.add(loan);
        System.out.println("Книга успешно выдана пользователю.");

        Notification notification = new Notification("Книга выдана: " + bookCopy.getBook().getTitle());
        notifyObservers(notification.getMessage());
    }

    // Метод для возврата книги
    public void returnBook(BookCopy bookCopy) {
        loans.removeIf(loan -> loan.getBookCopy().equals(bookCopy));
        System.out.println("Книга возвращена.");

        Notification notification = new Notification("Книга возвращена: " + bookCopy.getBook().getTitle());
        notifyObservers(notification.getMessage());
    }

    // Реализация методов интерфейса Subject
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
