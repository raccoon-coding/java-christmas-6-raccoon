package christmas.Controller;

import christmas.Model.Date;
import christmas.Service.Reservation;
import christmas.View.InputView;
import christmas.View.OutputView;

public class MenuOrder {
    private static MenuOrder instance;

    private MenuOrder() {
    }

    public static MenuOrder getInstance() {
        if (instance == null) {
            instance = new MenuOrder();
        }
        return instance;
    }

    public void run() {

    }

    private void booking(InputView inputView, OutputView outputView) {
        Reservation reservation = new Reservation(inputView, outputView);
        Date reservationDate = reservation.run();
    }
}
