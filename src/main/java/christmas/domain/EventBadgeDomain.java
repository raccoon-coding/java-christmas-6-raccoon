package christmas.domain;

import christmas.model.TotalPrice;

import java.util.Objects;

import static christmas.constants.DiscountConstant.GIFT_EVENT;

public class EventBadgeDomain {
    public static final int STAR_MIN = 5_000;
    public static final int TREE_MIN = 10_000;
    public static final int SANTA_MIN = 20_000;
    public static final String STAR = "별";
    public static final String TREE = "트리";
    public static final String SANTA = "산타";

    public void eventBadge(){
        TotalPrice totalPrice = TotalPrice.getInstance();
        double discount = totalPrice.getTotalDiscount() + totalPrice.getDiscount().get(GIFT_EVENT);
        santa(totalPrice, discount);
        tree(totalPrice, discount);
        star(totalPrice, discount);
    }

    private void star(TotalPrice totalPrice, double discount) {

        if(discount >= STAR_MIN && Objects.equals(totalPrice.getBadge(), null)){
            totalPrice.setBadge(STAR);
        }
    }

    private void tree(TotalPrice totalPrice, double discount) {
        if(discount >= TREE_MIN && Objects.equals(totalPrice.getBadge(), null)){
            totalPrice.setBadge(TREE);
        }
    }
    private void santa(TotalPrice totalPrice, double discount) {
        if(discount >= SANTA_MIN && Objects.equals(totalPrice.getBadge(), null)){
            totalPrice.setBadge(SANTA);
        }
    }
}
