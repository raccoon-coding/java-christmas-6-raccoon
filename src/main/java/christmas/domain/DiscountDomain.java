package christmas.domain;

import christmas.model.*;
import christmas.model.Date;
import christmas.repository.*;

import java.util.*;

import static christmas.constants.CovertConstant.IS_EMPTY;
import static christmas.constants.DiscountConstant.CHRISTMAS;
import static christmas.constants.DiscountConstant.FRIDAY;
import static christmas.constants.DiscountConstant.SATURDAY;
import static christmas.constants.DiscountConstant.SPECIAL;
import static christmas.constants.DiscountConstant.WEEKDAY;
import static christmas.constants.DiscountConstant.WEEKEND;

public class DiscountDomain {
    public void calculateDiscount(Date date, TotalPrice totalPrice) {
        serviceDiscount(date, totalPrice);
        christmasDiscount(date, totalPrice);
        weekdayDiscount(date, totalPrice);
        weekendDiscount(date, totalPrice);
    }

    private void serviceDiscount(Date date, TotalPrice totalPrice) {
        int discount = date.getSpecialDiscount();
        if(discount > IS_EMPTY){
            totalPrice.setDiscount(SPECIAL, discount);
        }
        totalPrice.setTotalDiscount(totalPrice.getTotalDiscount() + discount);
    }

    private void christmasDiscount(Date date, TotalPrice totalPrice) {
        int discount = date.getChristmasDiscount();
        if(discount > IS_EMPTY){
            totalPrice.setDiscount(CHRISTMAS, discount);
        }
        totalPrice.setTotalDiscount(totalPrice.getTotalDiscount() + discount);
    }

    private void weekdayDiscount(Date date, TotalPrice totalPrice){
        int weekdayDiscount = IS_EMPTY;

        if(!Objects.equals(date.getDay(),FRIDAY) && !Objects.equals(date.getDay(),SATURDAY)){
            GetDessert getDessert = new GetDessert();
            for(Menu menu : getDessert.getDessert()){
                weekdayDiscount += menu.getQuantity() * menu.getFixDiscount();
            }
        }

        weekdayDiscountSave(totalPrice, weekdayDiscount);
    }

    private void weekdayDiscountSave(TotalPrice totalPrice, int weekdayDiscount) {
        if(weekdayDiscount > IS_EMPTY){
            totalPrice.setDiscount(WEEKDAY, weekdayDiscount);
        }
        totalPrice.setTotalDiscount(totalPrice.getTotalDiscount() + weekdayDiscount);
    }

    private void weekendDiscount(Date date, TotalPrice totalPrice){
        int weekendDiscount = IS_EMPTY;

        if(Objects.equals(date.getDay(),FRIDAY) || Objects.equals(date.getDay(),SATURDAY)){
            GetMainFood getMainFood = new GetMainFood();
            for(Menu menu : getMainFood.getMainFood()){
                weekendDiscount += menu.getQuantity() * menu.getFixDiscount();
            }
        }

        weekendDiscountSave(totalPrice, weekendDiscount);
    }

    private void weekendDiscountSave(TotalPrice totalPrice, int weekendDiscount) {
        if(weekendDiscount > IS_EMPTY){
            totalPrice.setDiscount(WEEKEND, weekendDiscount);
        }
        totalPrice.setTotalDiscount(totalPrice.getTotalDiscount() + weekendDiscount);
    }
}
