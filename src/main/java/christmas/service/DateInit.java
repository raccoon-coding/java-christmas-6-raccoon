package christmas.service;

import christmas.dto.ConvertDate;
import christmas.dto.ConvertMenu;
import christmas.view.InputView;

public class DateInit {
    private static DateInit instance;

    private DateInit() {}

    public static synchronized DateInit getInstance() {
        if (instance == null) {
            instance = new DateInit();
        }
        return instance;
    }

    public void run() {
        InputView inputView = InputView.getInstance();
        String date = inputView.readDate();
        ConvertDate convertDate = new ConvertDate();
        convertDate.convertDate(date);
    }
}
