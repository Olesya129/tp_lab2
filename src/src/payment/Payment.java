package payment;

import loan.Loan;
import user.User;

class Payment {
    private PaymentProcessor paymentProcessor;
    private Loan loan;
    private User user;

    public Payment(PaymentProcessor paymentProcessor, Loan loan, User user) {
        this.paymentProcessor = paymentProcessor;
        this.loan = loan;
        this.user = user;
    }

    public void processPenaltyPayment() {
        // Примерный штраф
        double penaltyAmount = 5.0; // Например, жестко зафиксированный штраф
        System.out.println("Штраф для пользователя: " + user.toString());
        System.out.println("Штраф для пользователя с loan (предположительно): " + penaltyAmount);
        paymentProcessor.processPayment(penaltyAmount);
    }
}
