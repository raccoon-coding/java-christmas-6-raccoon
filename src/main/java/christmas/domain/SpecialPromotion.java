package christmas.domain;

import christmas.Dto.OrderMenus;

public class SpecialPromotion {
    public static final int MINIMUM_PRICE = 120_000;

    public void calculationMenuDomain() {
        OrderMenus orderMenus = OrderMenus.getInstance();
        givenPromotion(orderMenus);
    }

    private void givenPromotion(OrderMenus orderMenus){
        int totalPrice = orderMenus.calculateTotalPrice();
        if(totalPrice >= MINIMUM_PRICE){
            orderMenus.givePromotion();
        }
    }
}
