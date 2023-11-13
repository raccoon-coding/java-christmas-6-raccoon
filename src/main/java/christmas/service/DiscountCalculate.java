package christmas.service;

import christmas.dto.SaveDiscount;
import christmas.model.Date;
import christmas.model.Menu;
import christmas.model.TotalPrice;
import christmas.repository.GetDessert;
import christmas.repository.GetMainFood;
import christmas.view.OutputView;

import java.util.Objects;

import static christmas.constants.DiscountConstant.CHRISTMAS;
import static christmas.constants.DiscountConstant.FRIDAY;
import static christmas.constants.DiscountConstant.SATURDAY;
import static christmas.constants.DiscountConstant.SPECIAL;
import static christmas.constants.DiscountConstant.WEEKDAY;
import static christmas.constants.DiscountConstant.WEEKEND;

public class DiscountCalculate {
    private static DiscountCalculate instance;
    SaveDiscount saveDiscount;
    EventBadge eventBadge;
    private DiscountCalculate() {
        this.saveDiscount = new SaveDiscount();
        this.eventBadge = new EventBadge();
    }

    public static synchronized DiscountCalculate getInstance() {
        if (instance == null) {
            instance = new DiscountCalculate();
        }
        return instance;
    }

    public void run () {
        saveDiscount.saveDiscount();
        Date date = Date.getInstance();
        TotalPrice totalPrice = TotalPrice.getInstance();
        calculateDiscount(date, totalPrice);
        eventBadge.eventBadge();
        orderView();
    }

    private void calculateDiscount(Date date, TotalPrice totalPrice) {
        serviceDiscount(date, totalPrice);
        christmasDiscount(date, totalPrice);
        weekdayDiscount(date, totalPrice);
        weekendDiscount(date, totalPrice);
    }

    private void orderView() {
        OutputView outputView = OutputView.getInstance();
        outputView.totalDiscount();
    }

    private void serviceDiscount(Date date, TotalPrice totalPrice) {
        int discount = date.getSpecialDiscount();
        if(discount > 0){
            totalPrice.setDiscount(SPECIAL, discount);
        }
        totalPrice.setTotalDiscount(totalPrice.getTotalDiscount() + discount);
    }

    private void christmasDiscount(Date date, TotalPrice totalPrice) {
        int discount = date.getChristmasDiscount();
        if(discount > 0){
            totalPrice.setDiscount(CHRISTMAS, discount);
        }
        totalPrice.setTotalDiscount(totalPrice.getTotalDiscount() + discount);
    }

    private void weekdayDiscount(Date date, TotalPrice totalPrice){
        int weekdayDiscount = 0;
        if(!Objects.equals(date.getDay(),FRIDAY) && !Objects.equals(date.getDay(),SATURDAY)){
            GetDessert getDessert = new GetDessert();
            for(Menu menu : getDessert.getDessert()){
                weekdayDiscount += menu.getQuantity() * menu.getFixDiscount();
            }
        }
        if(weekdayDiscount > 0){
            totalPrice.setDiscount(WEEKDAY, weekdayDiscount);
        }
        totalPrice.setTotalDiscount(totalPrice.getTotalDiscount() + weekdayDiscount);
    }

    private void weekendDiscount(Date date, TotalPrice totalPrice){
        int weekendDiscount = 0;
        if(Objects.equals(date.getDay(),FRIDAY) || Objects.equals(date.getDay(),SATURDAY)){
            GetMainFood getMainFood = new GetMainFood();
            for(Menu menu : getMainFood.getMainFood()){
                weekendDiscount += menu.getQuantity() * menu.getFixDiscount();
            }
        }
        if(weekendDiscount > 0){
            totalPrice.setDiscount(WEEKEND, weekendDiscount);
        }
        totalPrice.setTotalDiscount(totalPrice.getTotalDiscount() + weekendDiscount);
    }
}
