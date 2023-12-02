package christmas.model;

import christmas.dto.ReservationDateRequest;

import java.time.LocalDate;

public class ReservationDate {
    private final LocalDate localDate;
    private ReservationDate(int date) {
        this.localDate = LocalDate.of(2023, 12, date);
    }
    public static ReservationDate from(ReservationDateRequest reservationDateRequest){
        return new ReservationDate(reservationDateRequest.date());
    }

    public int getDayOfWeek() {
        return localDate.getDayOfMonth();
    }

    public String getWeek() {
        return localDate.getDayOfWeek().name();
    }
}
