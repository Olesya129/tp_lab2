package library.management.system;

import java.util.ArrayList;
import java.util.List;

// Интерфейс стратегии для отчетов
interface ReportStrategy {
    void generateReport(List<String> actions);
}

// Конкретная стратегия: отчет по дате
class DateReportStrategy implements ReportStrategy {
    @Override
    public void generateReport(List<String> actions) {
        System.out.println("Generating report by date:");
        // Здесь будет логика формирования отчета по дате
        for (String action : actions) {
            System.out.println(action); // В реальной системе будет сортировка по дате
        }
    }
}

// Конкретная стратегия: отчет по популярности
class PopularityReportStrategy implements ReportStrategy {
    @Override
    public void generateReport(List<String> actions) {
        System.out.println("Generating report by popularity:");
        // Здесь будет логика формирования отчета по популярности
        for (String action : actions) {
            System.out.println(action); // В реальной системе будет анализ по популярности
        }
    }
}

// Класс для отчетности
public class Report {
    private ReportStrategy reportStrategy; // Текущая стратегия формирования отчета

    // Конструктор
    public Report(ReportStrategy reportStrategy) {
        this.reportStrategy = reportStrategy;
    }

    // Метод для изменения стратегии отчета
    public void setReportStrategy(ReportStrategy reportStrategy) {
        this.reportStrategy = reportStrategy;
    }

    // Метод для генерации отчета
    public void generate(List<String> actions) {
        reportStrategy.generateReport(actions);
    }
}
