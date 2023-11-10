package christmas.service;

import christmas.service.validation.DataValidation;
import christmas.view.InputView;

public class OrderInit {
    private static OrderInit instance;

    private OrderInit() {}

    public static synchronized OrderInit getInstance() {
        if (instance == null) {
            instance = new OrderInit();
        }
        return instance;
    }
    public void run() {
        InputView inputView = new InputView();
        String date = inputView.readDate();

    }
}
