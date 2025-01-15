package loan;

public class IssuedState implements State {
    @Override
    public void handle(Loan loan) {
        // Логика для состояния "Выдана"
        System.out.println("Книга выдана.");
    }
}