package payment;

// Адаптер для интеграции OnlinePaymentService с интерфейсом PaymentProcessor
class OnlinePaymentAdapter implements PaymentProcessor {
    private OnlinePaymentService onlinePaymentService;

    public OnlinePaymentAdapter() {
        this.onlinePaymentService = new OnlinePaymentService();
    }

    @Override
    public void processPayment(double amount) {
        onlinePaymentService.payOnline(amount);
    }
}
