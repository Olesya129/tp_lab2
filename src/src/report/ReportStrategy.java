package report;

import book.Book;
import java.util.List;

public interface ReportStrategy {
    void generateReport(List<Book> books);
}
