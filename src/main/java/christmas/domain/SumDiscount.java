package christmas.domain;

import christmas.Dto.Discount.DiscountPolicy;
import christmas.Dto.OrderMenu;
import christmas.Dto.OrderMenus;

public class SumDiscount {
    public int total() {
        OrderMenus orderMenus = OrderMenus.getInstance();
        OrderMenu promotion = orderMenus.requestPromotion();
        return totalDiscount() + promotion.requestQuantity() * promotion.requestMenuPrice();
    }

    public int predictPrice() {
        OrderMenus orderMenus = OrderMenus.getInstance();
        return orderMenus.calculateTotalPrice() - totalDiscount();
    }

    private int totalDiscount() {
        DiscountPolicy discountPolicy = DiscountPolicy.getInstance();
        return discountPolicy.requestTotalDiscount();
    }
}
