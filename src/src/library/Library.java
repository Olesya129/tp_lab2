package library;
import book.Book;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private static Library instance;
    private List<Book> books;
    private List<User> users;
    private List<Loan> loans;

    private Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        loans = new ArrayList<>();
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void loanBook(BookCopy bookCopy, User user) {
        LocalDate issueDate = LocalDate.now();
        LocalDate dueDate = issueDate.plusDays(user.getLoanPeriod());
        Loan loan = new Loan(bookCopy, user, issueDate, dueDate);
        loans.add(loan);
    }

    public void returnBook(BookCopy bookCopy) {
        for (Loan loan : loans) {
            if (loan.getBookCopy().equals(bookCopy)) {
                loans.remove(loan);
                break;
            }
        }
    }
}
