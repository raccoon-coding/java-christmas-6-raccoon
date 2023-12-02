package christmas.controller;

import christmas.view.InputView;
import christmas.view.OutputView;

public class Planner {
    private static Planner instance;
    private final InputView inputView;
    private final OutputView outputView;
    private Planner() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public static Planner getInstance() {
        if (instance == null) {
            instance = new Planner();
        }
        return instance;
    }

    public void run() {

    }
}
