package christmas.Model;

import christmas.Dto.Request.DateRequest;

public class Date {
    private int day;
    private String dayOfWeek;

    public static Date of(DateRequest dateRequest){
        Date date = new Date();
        date.day = dateRequest.day();
        date.dayOfWeek = dateRequest.dayOfWeek();
        return date;
    }
}
