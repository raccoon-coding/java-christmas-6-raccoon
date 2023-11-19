package christmas.service;

import christmas.domain.ConvertDate;
import christmas.service.validation.CatchErrorRetry;
import christmas.view.InputView;

public class ReservationDateInit {
    private final InputView inputView;
    public ReservationDateInit() {
        this.inputView = new InputView();
    }
    public void run(){
        startOrderPlanner();
        enterDate();
    }
    private void startOrderPlanner() {
        inputView.startUI();
    }

    private void enterDate() {
        ConvertDate convertDate = new ConvertDate();
        CatchErrorRetry.executeWithRetry(
                () -> {
                    String date = inputView.readDate();
                    convertDate.convertDate(date);
                }
        );
    }
}
