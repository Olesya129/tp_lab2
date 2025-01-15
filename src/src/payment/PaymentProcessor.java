package payment;
// Target (Целевой интерфейс)
// Определяет единый интерфейс для обработки платежей, который будет использовать клиент
interface PaymentProcessor {
    void processPayment(double amount);
}

