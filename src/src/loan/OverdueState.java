package loan;

public class OverdueState implements State {
    @Override
    public void handle(Loan loan) {
        // Логика для состояния "Просрочена"
        System.out.println("Книга просрочена.");
    }
}
