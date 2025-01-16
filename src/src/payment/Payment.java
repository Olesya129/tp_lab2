package payment;

import user.User;

class Payment {
    private Object paymentService;
    private User user;

    public Payment(Object paymentService, User user) {
        this.paymentService = paymentService;
        this.user = user;
    }

    public void processPenaltyPayment() {
        double penaltyAmount = 5.0;  // Например, штраф
        System.out.println("Штраф для пользователя: " + user.toString());
        System.out.println("Штраф для пользователя с loan (предположительно): " + penaltyAmount);

        // Адаптация и выполнение платежа
        if (paymentService instanceof OnlinePaymentService) {
            ((OnlinePaymentService) paymentService).payOnline(penaltyAmount);
        } else if (paymentService instanceof TerminalPaymentService) {
            ((TerminalPaymentService) paymentService).payAtTerminal(penaltyAmount);
        } else {
            throw new IllegalArgumentException("Неизвестный тип сервиса оплаты");
        }
    }
}
