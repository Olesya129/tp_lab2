package payment;

// Адаптер для интеграции TerminalPaymentService с интерфейсом PaymentProcessor
class TerminalPaymentAdapter implements PaymentProcessor {
    private TerminalPaymentService terminalPaymentService;

    public TerminalPaymentAdapter() {
        this.terminalPaymentService = new TerminalPaymentService();
    }

    @Override
    public void processPayment(double amount) {
        terminalPaymentService.payAtTerminal(amount);
    }
}
