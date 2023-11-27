package christmas.Service;

import christmas.Dto.Request.DateRequest;
import christmas.Model.Date;
import christmas.View.InputView;
import christmas.View.OutputView;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Reservation {
    private InputView inputView;
    public OutputView outputView;
    public Reservation(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Date run(){
        int day = enterReservationDay();
        String dayOfWeek = calculationDayOfWeek(day);
        return  Date.of(new DateRequest(day, dayOfWeek));
    }

    private int enterReservationDay() {
        return inputView.enterReservationDay();
    }

    private String calculationDayOfWeek(int day) {
        LocalDate date = LocalDate.of(2023, 12, day);

        DayOfWeek dayOfWeek = date.getDayOfWeek();

        return dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault());
    }
}
