package memento;

// Memento: сохраняет состояние
public class SolverState {
    private final String state; // Состояние системы

    public SolverState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
