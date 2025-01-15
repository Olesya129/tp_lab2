package actionHistory;

import loan.Loan;
import user.User;


import java.util.Stack;

public class ActionHistory {
    private final Stack<SolverState> history = new Stack<>();
    private final User user;

    public ActionHistory(User user) {
        this.user = user;
    }

    public void save(SolverState state) {
        history.push(state);
        System.out.println("Состояние добавлено в историю для пользователя: " + user);
    }

    public SolverState undo() {
        if (!history.isEmpty()) {
            SolverState lastState = history.pop();
            System.out.println("Последнее состояние удалено из истории для пользователя: " + user);
            return lastState;
        }
        System.out.println("История пуста для пользователя: " + user);
        return null;
    }
}
