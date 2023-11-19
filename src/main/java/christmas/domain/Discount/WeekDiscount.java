package christmas.domain.Discount;

import christmas.Dto.Date;
import christmas.Dto.Discount.DiscountPolicy;
import christmas.Dto.Discount.EachDiscount;
import christmas.Dto.OrderMenus;

import java.util.Objects;

import static christmas.constants.Discount.Friday;
import static christmas.constants.Discount.Saturday;
import static christmas.constants.Discount.WEEKDAY;
import static christmas.constants.Discount.WEEKEND;

public class WeekDiscount {
    private final String WeekdayDiscountType = "Dessert";
    private final String WeekendDiscountType = "MainMenu";
    private final int WeekDiscount = 2023;
    public void haveWeekDiscount() {
        Date date = Date.getInstance();
        OrderMenus orderMenus = OrderMenus.getInstance();
        String dayOfWeek = date.requestDayOfWeek();

        IsWeekday(orderMenus, dayOfWeek);
        IsWeekend(orderMenus, dayOfWeek);
    }

    private void IsWeekday(OrderMenus orderMenus, String dayOfWeek) {
        if(!Objects.equals(dayOfWeek, Friday) && !Objects.equals(dayOfWeek,Saturday)){
            orderMenus.updateMenuDiscount(WeekdayDiscountType, WeekDiscount);
            saveWeekdayDiscount(orderMenus);
        }
    }

    private void saveWeekdayDiscount(OrderMenus orderMenus) {
        int totalDiscount = orderMenus.calculateDiscount();
        DiscountPolicy discountPolicy = DiscountPolicy.getInstance();

        EachDiscount eachDiscount = EachDiscount.createOneDiscount(WEEKDAY, totalDiscount);
        discountPolicy.addTotalDiscount(eachDiscount);
    }

    private void IsWeekend(OrderMenus orderMenus, String dayOfWeek){
        if(Objects.equals(dayOfWeek, Friday) || Objects.equals(dayOfWeek,Saturday)){
            orderMenus.updateMenuDiscount(WeekendDiscountType, WeekDiscount);
            saveWeekendDiscount(orderMenus);
        }
    }

    private void saveWeekendDiscount(OrderMenus orderMenus) {
        int totalDiscount = orderMenus.calculateDiscount();
        DiscountPolicy discountPolicy = DiscountPolicy.getInstance();

        EachDiscount eachDiscount = EachDiscount.createOneDiscount(WEEKEND, totalDiscount);
        discountPolicy.addTotalDiscount(eachDiscount);
    }
}
