package payment;

// Adaptee (Адаптируемые классы)
// Класс для обработки онлайн-платежей с существующим методом payOnline
class OnlinePaymentService {
    public void payOnline(double amount) {
        System.out.println("Оплата онлайн на сумму: " + amount);
    }
}