package report;

import book.Book;
import java.util.List;

public class Report {
    private ReportStrategy reportStrategy;

    public void setReportStrategy(ReportStrategy reportStrategy) {
        this.reportStrategy = reportStrategy;
    }

    public void generateReport(List<Book> books) {
        if (reportStrategy != null) {
            reportStrategy.generateReport(books);
        }
    }

    public void generateLibraryReport() {
        // Имитируем вызов метода getBooks() из Library
        System.out.println("Fetching books from Library...");
        // Предполагаем, что получили список книг
        List<Book> books = List.of(); // Здесь предполагаемая пустая коллекция для демонстрации
        generateReport(books);
    }
}
