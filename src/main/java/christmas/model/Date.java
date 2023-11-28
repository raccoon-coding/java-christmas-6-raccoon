package christmas.model;

import christmas.dto.request.DateRequest;

import java.util.HashMap;
import java.util.Map;

public class Date {
    private int day;
    private String dayOfWeek;
    private Map<String, String> weekDiscount;

    public static Date of(DateRequest dateRequest){
        Date date = new Date();
        initDiscount(date);
        date.day = dateRequest.day();
        date.dayOfWeek = dateRequest.dayOfWeek();
        return date;
    }

    public String requestDayOfWeek() {
        return this.dayOfWeek;
    }

    public int requestDay() {
        return this.day;
    }
    public Map<String, String> requestWeekDiscount() {
        return this.weekDiscount;
    }

    private static void initDiscount(Date date) {
        date.weekDiscount = new HashMap<>();
        date.weekDiscount.put("없음", "없음");
        date.weekDiscount.put("평일 할인", "Dessert");
        date.weekDiscount.put("주말 할인", "MainMenu");
    }
}
