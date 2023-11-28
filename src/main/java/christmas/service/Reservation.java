package christmas.service;

import christmas.domain.DateDomain;
import christmas.dto.request.DateRequest;
import christmas.model.Date;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Reservation {
    public Date run(int day){
        DateDomain dateDomain = new DateDomain();
        validateDate(day);
        String dayOfWeek = calculationDayOfWeek(dateDomain, day);
        return  Date.of(new DateRequest(day, dayOfWeek));
    }

    private String calculationDayOfWeek(DateDomain dateDomain, int day) {
        return dateDomain.calculationDayOfWeek(day);
    }
    private void validateDate(int day){
        if(day > 31 || day<0){
            throw new IllegalArgumentException();
        }
    }
}
