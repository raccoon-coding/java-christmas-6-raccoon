package christmas.repository;

import christmas.model.Date;

import java.util.Objects;

import static christmas.constants.Covert.IS_EMPTY;
import static christmas.constants.Discount.WEEK_DISCOUNT;
import static christmas.constants.Discount.FRIDAY;
import static christmas.constants.Discount.SATURDAY;
import static christmas.constants.Discount.CHRISTMAS_DAY;
import static christmas.constants.Discount.CHRISTMAS_DISCOUNT;
import static christmas.constants.Discount.SUNDAY;
import static christmas.constants.Discount.SPECIAL_DISCOUNT;

public class SaveDiscount {
    public void saveDiscount() {
        Date date = Date.getInstance();
        String day = date.getDay();
        int nDays = date.getnDays();
        discountWeek(day);
        saveDiscount(day, nDays);
    }

    private void discountWeek(String day){
        discountWeekday(day);
        discountWeekend(day);
    }

    private void discountWeekday(String day) {
        if(!Objects.equals(day, FRIDAY) && !Objects.equals(day, SATURDAY)){
            SetFixDiscount setFixDiscount = new SetFixDiscount();
            setFixDiscount.setDessert(WEEK_DISCOUNT);
        }
    }

    private void discountWeekend(String day) {
        if (Objects.equals(day, FRIDAY) || Objects.equals(day, SATURDAY)) {
            SetFixDiscount setFixDiscount = new SetFixDiscount();
            setFixDiscount.setMainFood(WEEK_DISCOUNT);
        }
    }

    private void saveDiscount(String day, int nDays) {
        int christmasDiscount = discountChristmas(nDays);
        int specialDiscount = specialDiscount(day, nDays);
        Date date = Date.getInstance();
        date.setDiscount(christmasDiscount, specialDiscount);
    }

    private int discountChristmas(int nDays){
        if(nDays > CHRISTMAS_DAY){
            return IS_EMPTY;
        }
        return (nDays - 1) * CHRISTMAS_DISCOUNT + SPECIAL_DISCOUNT;
    }

    private int specialDiscount(String day, int nDays) {
        if(Objects.equals(day, SUNDAY) || Objects.equals(nDays, CHRISTMAS_DAY)){
            return SPECIAL_DISCOUNT;
        }
        return IS_EMPTY;
    }
}
