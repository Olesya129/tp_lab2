package report;

import book.Book;
import java.util.List;

// Интерфейс стратегии формирования отчетов
public interface ReportStrategy {
    void generateReport(List<Book> books);
}
