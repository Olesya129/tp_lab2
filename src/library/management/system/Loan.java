package library.management.system;

import java.time.LocalDate;

// Класс Loan управляет процессом выдачи книг
public class Loan {
    private BookCopy bookCopy;   // Экземпляр книги
    private User user;           // Пользователь, взявший книгу
    private LocalDate issueDate; // Дата выдачи книги
    private LocalDate dueDate;   // Дата возврата книги
    private LoanState state;     // Текущее состояние выдачи

    // Конструктор
    public Loan(BookCopy bookCopy, User user, LocalDate issueDate, LocalDate dueDate) {
        this.bookCopy = bookCopy;
        this.user = user;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.state = new IssuedState(); // Изначально книга выдана
    }

    // Геттеры
    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public LoanState getState() {
        return state;
    }

    // Методы для изменения состояния
    public void setState(LoanState newState) {
        this.state = newState;
    }

    // Обновление состояния (вызывается, например, при проверке даты)
    public void updateState() {
        state.handleState(this);
    }

    // Информация о выдаче
    public String getLoanDetails() {
        return "Book: " + bookCopy.getDescription() + ", User: " + user.getName() +
                ", Due Date: " + dueDate + ", State: " + state.getStateName();
    }
}

// Абстрактное состояние LoanState
abstract class LoanState {
    public abstract void handleState(Loan loan);  // Метод для обработки состояния
    public abstract String getStateName();       // Имя текущего состояния
}

// Состояние "Выдана"
class IssuedState extends LoanState {
    @Override
    public void handleState(Loan loan) {
        if (LocalDate.now().isAfter(loan.getDueDate())) {
            loan.setState(new OverdueState());
        }
    }

    @Override
    public String getStateName() {
        return "Issued";
    }
}

// Состояние "Просрочена"
class OverdueState extends LoanState {
    @Override
    public void handleState(Loan loan) {
        // Логика может включать уведомление пользователя
        System.out.println("Book is overdue! Notify the user.");
    }

    @Override
    public String getStateName() {
        return "Overdue";
    }
}

// Состояние "Возвращена"
class ReturnedState extends LoanState {
    @Override
    public void handleState(Loan loan) {
        // Логика возврата
        System.out.println("Book has already been returned.");
    }

    @Override
    public String getStateName() {
        return "Returned";
    }
}
