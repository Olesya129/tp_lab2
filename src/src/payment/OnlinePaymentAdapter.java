package payment;

// Adapter (Адаптеры)
// Адаптер для интеграции OnlinePaymentService с интерфейсом PaymentProcessor
class OnlinePaymentAdapter implements PaymentProcessor {
    private OnlinePaymentService onlinePaymentService;

    public OnlinePaymentAdapter() {
        this.onlinePaymentService = new OnlinePaymentService();
    }

    @Override
    public void processPayment(double amount) {
        // Адаптер вызывает существующий метод из OnlinePaymentService
        onlinePaymentService.payOnline(amount);
    }
}

