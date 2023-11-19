package christmas.domain;

import christmas.Dto.Discount.DiscountPolicy;
import christmas.Dto.OrderMenu;
import christmas.Dto.OrderMenus;

import java.util.Objects;

import static christmas.constants.Badge.FIRST_BADGE;
import static christmas.constants.Badge.FIRST_BADGE_MIN;
import static christmas.constants.Badge.SECOND_BADGE;
import static christmas.constants.Badge.SECOND_BADGE_MIN;
import static christmas.constants.Badge.THIRD_BADGE;
import static christmas.constants.Badge.THIRD_BADGE_MIN;
import static christmas.view.OutputView.OutputConstants.NULL_EVENT;

public class EventBadge {

    public void eventBadge(){
        OrderMenus orderMenus = OrderMenus.getInstance();
        int totalDiscount = setUp(orderMenus);

        first(orderMenus, totalDiscount);
        second(orderMenus, totalDiscount);
        third(orderMenus, totalDiscount);
    }

    private int setUp(OrderMenus orderMenus) {
        DiscountPolicy discountPolicy = DiscountPolicy.getInstance();
        OrderMenu promotion = orderMenus.requestPromotion();
        return discountPolicy.requestTotalDiscount() + promotion.requestQuantity() * promotion.requestMenuPrice();
    }

    private void third(OrderMenus orderMenus, int totalPrice) {
        if(totalPrice >= THIRD_BADGE_MIN && Objects.equals(orderMenus.requestBadge(), NULL_EVENT)){
            orderMenus.setBadge(THIRD_BADGE);
        }
    }

    private void second(OrderMenus orderMenus, int totalPrice) {
        if(totalPrice >= SECOND_BADGE_MIN && Objects.equals(orderMenus.requestBadge(), NULL_EVENT)){
            orderMenus.setBadge(SECOND_BADGE);
        }
    }
    private void first(OrderMenus orderMenus, int totalPrice) {
        if(totalPrice >= FIRST_BADGE_MIN && Objects.equals(orderMenus.requestBadge(), NULL_EVENT)){
            orderMenus.setBadge(FIRST_BADGE);
        }
    }
}
