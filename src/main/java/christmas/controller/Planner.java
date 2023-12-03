package christmas.controller;

import christmas.model.Consumer;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.function.Supplier;

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
        Consumer consumer = enterData();
        recheckData(consumer);
    }

    public static <T> T retry(Supplier<T> supplier) {
        while(true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Consumer enterData() {
        return EnterReservation.from(inputView).run();
    }

    private void recheckData(Consumer consumer) {
        RecheckPlanner.of(consumer, outputView).run();
    }
}
