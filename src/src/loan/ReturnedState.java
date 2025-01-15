package loan;

public class ReturnedState implements State {
    @Override
    public void handle(Loan loan) {
        // Логика для состояния "Возвращена"
        System.out.println("Книга возвращена.");
    }
}