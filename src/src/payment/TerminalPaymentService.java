package payment;

// Класс для обработки платежей через терминал с существующим методом payAtTerminal
class TerminalPaymentService {
    public void payAtTerminal(double amount) {
        System.out.println("Оплата через терминал на сумму: " + amount);
    }
}