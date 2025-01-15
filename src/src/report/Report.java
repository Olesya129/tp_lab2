package report;

import book.Book;
import java.util.List;

// Класс для использования стратегии
class Report {
    private ReportStrategy reportStrategy;

    public void setReportStrategy(ReportStrategy reportStrategy) {
        this.reportStrategy = reportStrategy;
    }

    public void generateReport(List<Book> books) {
        if (reportStrategy != null) {
            reportStrategy.generateReport(books);
        }
    }
}