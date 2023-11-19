package christmas.view.OutputView;

import static christmas.view.OutputView.OutputConstants.LINE_SEPARATOR;
import static christmas.view.OutputView.OutputConstants.PLANNER_START;

public class ReservationDateView {
    public void runUI(int day) {
        System.out.printf(LINE_SEPARATOR);
        System.out.printf(PLANNER_START, day);
        System.out.printf(LINE_SEPARATOR);
    }
}
