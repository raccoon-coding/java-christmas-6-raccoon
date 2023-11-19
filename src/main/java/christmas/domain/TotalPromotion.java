package christmas.domain;

import christmas.Dto.Discount.DiscountPolicy;
import christmas.Dto.Discount.EachDiscount;
import christmas.Dto.OrderMenu;
import christmas.Dto.OrderMenus;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static christmas.constants.Covert.IS_EMPTY;

public class TotalPromotion {
    public Map<String, Integer> createTotalPromotion() {
        Map<String, Integer> totalPromotion = new HashMap<>(setUpTotalPromotion());
        return haveChristmasPromotion(totalPromotion);
    }

    private Map<String, Integer> setUpTotalPromotion() {
        DiscountPolicy discountPolicy = DiscountPolicy.getInstance();
        return discountPolicy.requestTotalDiscountsContent().stream()
                .collect(Collectors.toMap(EachDiscount::getDiscountName, EachDiscount::getDiscountPrice));
    }

    private Map<String, Integer> haveChristmasPromotion(Map<String, Integer> totalPromotion) {
        OrderMenus orderMenus = OrderMenus.getInstance();
        OrderMenu promotion = orderMenus.requestPromotion();
        if (promotion.requestQuantity() != IS_EMPTY) {
            totalPromotion.put(promotion.requestMenuName(), promotion.requestMenuPrice() * promotion.requestQuantity());
        }
        return totalPromotion;
    }
}
