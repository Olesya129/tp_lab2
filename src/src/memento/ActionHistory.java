package memento;

// Caretaker: управляет историей состояний
import java.util.Stack;

public class ActionHistory {
    private final Stack<SolverState> history = new Stack<>();

    public void save(SolverState state) {
        history.push(state);
        System.out.println("Состояние добавлено в историю.");
    }

    public SolverState undo() {
        if (!history.isEmpty()) {
            SolverState lastState = history.pop();
            System.out.println("Последнее состояние удалено из истории.");
            return lastState;
        }
        System.out.println("История пуста!");
        return null;
    }
}