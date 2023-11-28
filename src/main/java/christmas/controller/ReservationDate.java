package christmas.controller;

import christmas.model.Date;
import christmas.view.InputView;
import christmas.service.Reservation;

public class ReservationDate {
    private InputView inputView;
    public ReservationDate (InputView inputView) {
        this.inputView = inputView;
    }
    public Date run() {
        while(true){
            try{
                return booking(inputView);
            }
            catch (IllegalArgumentException e){
                System.out.println(ErrorMessage.DateError.printErrorMessage());
            }
        }
    }

    private Date booking(InputView inputView) {
        Reservation reservation = new Reservation();
        return reservation.run(inputView.enterReservationDay());
    }
}
