package actionHistory;

import loan.Loan;

class ActionRecord {
    private final String action;
    private final Loan loan;

    public ActionRecord(String action, Loan loan) {
        this.action = action;
        this.loan = loan;
    }

    public String getAction() {
        return action;
    }

    public Loan getLoan() {
        return loan;
    }
}