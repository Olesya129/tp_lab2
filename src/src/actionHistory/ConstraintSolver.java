package actionHistory;

// Originator: управляет состоянием и создает Memento
public class ConstraintSolver {
    private String currentState;

    public void setState(String state) {
        this.currentState = state;
        System.out.println("Состояние обновлено: " + state);
    }

    public SolverState saveState() {
        System.out.println("Состояние сохранено.");
        return new SolverState(currentState);
    }

    public void restoreState(SolverState memento) {
        this.currentState = memento.getState();
        System.out.println("Состояние восстановлено: " + currentState);
    }
}