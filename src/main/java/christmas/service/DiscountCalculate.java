package christmas.service;

import christmas.dto.SaveDiscount;
import christmas.model.Date;
import christmas.model.Menu;
import christmas.model.TotalPrice;
import christmas.repository.GetDessert;
import christmas.repository.GetMainFood;
import christmas.view.OutputView;

import java.util.Objects;

public class DiscountCalculate {
    private static DiscountCalculate instance;

    private DiscountCalculate() {}

    public static synchronized DiscountCalculate getInstance() {
        if (instance == null) {
            instance = new DiscountCalculate();
        }
        return instance;
    }

    public void run () {
        SaveDiscount saveDiscount = new SaveDiscount();
        saveDiscount.saveDiscount();
        double totalDiscount = 0;
        totalDiscount = serviceDiscount() + christmasDiscount() + weekdayDiscount() + weekendDiscount();
        TotalPrice totalPrice = TotalPrice.getInstance();
        totalPrice.setTotalDiscount(totalDiscount);
        EventBadge eventBadge = new EventBadge();
        eventBadge.eventBadge(totalDiscount);
        OutputView outputView = new OutputView();
        outputView.totalDiscount();
    }

    private int serviceDiscount() {
        Date date = Date.getInstance();
        int discount = date.getSpecialDiscount();
        if(discount > 0){
            TotalPrice totalPrice = TotalPrice.getInstance();
            totalPrice.setDiscount("특별 할인", discount);
        }
        return discount;
    }

    private int christmasDiscount() {
        Date date = Date.getInstance();
        int discount = date.getChristmasDiscount();
        if(discount > 0){
            TotalPrice totalPrice = TotalPrice.getInstance();
            totalPrice.setDiscount("크리스마스 디데이 할인", discount);
        }
        return discount;
    }

    private int weekdayDiscount(){
        Date date = Date.getInstance();
        int weekdayDiscount = 0;
        if(!Objects.equals(date.getDay(),"금요일") && !Objects.equals(date.getDay(),"토요일")){
            GetDessert getDessert = new GetDessert();
            for(Menu menu : getDessert.getDessert()){
                weekdayDiscount += menu.getQuantity() * menu.getFixDiscount();
            }
        }
        if(weekdayDiscount > 0){
            TotalPrice totalPrice = TotalPrice.getInstance();
            totalPrice.setDiscount("평일 할인", weekdayDiscount);
        }
        return weekdayDiscount;
    }

    private int weekendDiscount(){
        Date date = Date.getInstance();
        int weekendDiscount = 0;
        if(Objects.equals(date.getDay(),"금요일") || Objects.equals(date.getDay(),"토요일")){
            GetMainFood getMainFood = new GetMainFood();
            for(Menu menu : getMainFood.getMainFood()){
                weekendDiscount += menu.getQuantity() * menu.getFixDiscount();
            }
        }
        if(weekendDiscount > 0){
            TotalPrice totalPrice = TotalPrice.getInstance();
            totalPrice.setDiscount("주말 할인", weekendDiscount);
        }
        return weekendDiscount;
    }
}
