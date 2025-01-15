package report;

import book.Book;
import java.util.List;

class DateReportStrategy implements ReportStrategy {
    @Override
    public void generateReport(List<Book> books) {
        // Логика для отчета по дате выпуска книг
        System.out.println("Generating Date-based Report...");
    }
}
