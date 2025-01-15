package loan;


import bookCopy.BookCopy;
import user.User;

import java.time.LocalDate;

public class Loan {
    private BookCopy bookCopy;
    private User user;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private State currentState;

    public Loan(BookCopy bookCopy, User user, LocalDate issueDate, LocalDate dueDate) {
        this.bookCopy = bookCopy;
        this.user = user;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.currentState = new IssuedState(); // Начальное состояние "Выдана"
    }

    // Метод для изменения состояния
    public void setState(State state) {
        this.currentState = state;
    }

    // Метод для вызова поведения текущего состояния
    public void process() {
        currentState.handle(this);
    }

    // Геттеры для получения информации о книге и пользователе
    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}
