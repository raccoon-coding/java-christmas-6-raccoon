package christmas.Dto;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Objects;

import static christmas.constants.Covert.CHRISTMAS_DAY;
import static christmas.constants.Covert.SPECIAL_BADGE;
import static christmas.constants.Discount.Sunday;
import static christmas.view.OutputView.OutputConstants.NULL_EVENT;


public class Date {
    private static int day;
    private static String dayOfWeek;
    private static String specialDay;
    private static Date instance;

    private Date() {
    }

    public static synchronized Date getInstance() {
        if (instance == null) {
            instance = new Date();
        }
        return instance;
    }

    public void reservationDate(DayOfWeek dayOfWeek, int day) {
        Date.day = day;
        Date.dayOfWeek = dayOfWeek.toString();
        Date.specialDay = NULL_EVENT;
    }

    public int requestDay() {
        return day;
    }

    public String requestDayOfWeek() {
        return dayOfWeek;
    }

    public void equalSpecialDay() {
        if(Objects.equals(dayOfWeek, Sunday) || Objects.equals(day, CHRISTMAS_DAY)){
            specialDay = SPECIAL_BADGE;
        }
    }

    public String requestSpecialDay() {
        return specialDay;
    }
}
