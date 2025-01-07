package library.management.system;

public class Payment {

    // Интерфейс для различных платежных систем (Адаптер)
    public interface PaymentSystem {
        void pay(double amount);
    }

    // Онлайн платежная система
    public static class OnlinePaymentSystem implements PaymentSystem {
        @Override
        public void pay(double amount) {
            System.out.println("Online payment of " + amount + " has been successfully processed.");
        }
    }

    // Платежная система через терминал
    public static class TerminalPaymentSystem implements PaymentSystem {
        @Override
        public void pay(double amount) {
            System.out.println("Payment of " + amount + " has been successfully processed via terminal.");
        }
    }

    private PaymentSystem paymentSystem; // Текущая платежная система

    // Метод для установки платежной системы
    public void setPaymentSystem(PaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    // Метод для расчета штрафа
    public double calculateFine(int overdueDays, double finePerDay) {
        return overdueDays * finePerDay;
    }

    // Метод для осуществления оплаты штрафа
    public void processPayment(int overdueDays, double finePerDay) {
        double fine = calculateFine(overdueDays, finePerDay);
        if (paymentSystem != null) {
            paymentSystem.pay(fine); // Используем текущую платежную систему для оплаты штрафа
        } else {
            System.out.println("No payment system selected.");
        }
    }

}
