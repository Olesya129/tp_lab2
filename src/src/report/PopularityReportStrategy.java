package report;

import book.Book;
import java.util.List;

class PopularityReportStrategy implements ReportStrategy {
    @Override
    public void generateReport(List<Book> books) {
        // Логика для отчета по популярности книг
        System.out.println("Generating Popularity Report...");
    }
}
