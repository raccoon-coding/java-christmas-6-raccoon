package christmas.domain;

import christmas.model.MenuManager;
import christmas.model.Menu;
import christmas.model.TotalPrice;

import static christmas.constants.CovertConstant.IS_EMPTY;
import static christmas.constants.DiscountConstant.GIFT_EVENT;
import static christmas.constants.DiscountConstant.GIFT_PRICE;

public class CalculationMenuDomain {
    public static final int MINIMUM_PRICE = 120_000;

    public void calculationMenuDomain() {
        double totalPrice = sumPrice();
        saveTotalPrice(totalPrice);
        givenEvent();
    }

    private double sumPrice() {
        MenuManager menuManager = MenuManager.getInstance();
        double total = 0;

        for(Menu menu : menuManager.getAllMenuItems()){
            if(menu.getQuantity() > IS_EMPTY) {
                total += menu.getQuantity() * menu.getPrice();
            }
        }

        return total;
    }

    private void saveTotalPrice(double total) {
        TotalPrice totalPrice = TotalPrice.getInstance();
        totalPrice.setTotalPrice(total);
    }

    private void givenEvent(){
        TotalPrice totalPrice = TotalPrice.getInstance();

        if(totalPrice.getTotalPrice() > MINIMUM_PRICE){
            totalPrice.setDiscount(GIFT_EVENT, GIFT_PRICE);
            totalPrice.setTotalEvent(totalPrice.getTotalEvent() + (GIFT_PRICE * (-1)));
        }
    }
}
