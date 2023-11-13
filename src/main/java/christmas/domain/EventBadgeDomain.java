package christmas.domain;

import christmas.model.TotalPrice;

import java.util.Objects;

public class EventBadgeDomain {
    public static final int STAR_MIN = 5_000;
    public static final int TREE_MIN = 10_000;
    public static final int SANTA_MIN = 20_000;
    public static final String STAR = "별";
    public static final String TREE = "트리";
    public static final String SANTA = "산타";

    public void eventBadge(){
        TotalPrice totalPrice = TotalPrice.getInstance();
        santa(totalPrice);
        tree(totalPrice);
        star(totalPrice);
    }

    private void star(TotalPrice totalPrice) {
        double discount = totalPrice.getTotalDiscount();
        if(discount >= STAR_MIN && Objects.equals(totalPrice.getBadge(), null)){
            totalPrice.setBadge(STAR);
        }
    }

    private void tree(TotalPrice totalPrice) {
        double discount = totalPrice.getTotalDiscount();
        if(discount >= TREE_MIN && Objects.equals(totalPrice.getBadge(), null)){
            totalPrice.setBadge(TREE);
        }
    }
    private void santa(TotalPrice totalPrice) {
        double discount = totalPrice.getTotalDiscount();
        if(discount >= SANTA_MIN && Objects.equals(totalPrice.getBadge(), null)){
            totalPrice.setBadge(SANTA);
        }
    }
}
