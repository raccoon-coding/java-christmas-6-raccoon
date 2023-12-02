package christmas.view;

import java.util.Map;

import static christmas.view.constants.OutputConstants.BADGE;
import static christmas.view.constants.OutputConstants.BADGE_INIT;
import static christmas.view.constants.OutputConstants.DISCOUNT_CONTENT;
import static christmas.view.constants.OutputConstants.DISCOUNT_CONTENT_INIT;
import static christmas.view.constants.OutputConstants.ESTIMATED_AMOUNT;
import static christmas.view.constants.OutputConstants.ESTIMATED_AMOUNT_INIT;
import static christmas.view.constants.OutputConstants.MENU_AND_COUNT;
import static christmas.view.constants.OutputConstants.ORDER_MENU_INIT;
import static christmas.view.constants.OutputConstants.PRICE;
import static christmas.view.constants.OutputConstants.PROMOTION_INIT;
import static christmas.view.constants.OutputConstants.TOTAL_DISCOUNT_INIT;
import static christmas.view.constants.OutputConstants.TOTAL_PRICE_INIT;
import static christmas.view.constants.OutputConstants.USER_PLANNER_INIT;

public class OutputView {
    public void plannerInit(int date) {
        System.out.printf(USER_PLANNER_INIT, date);
    }

    public void orderMenus(Map<String, Integer> orders) {
        System.out.println(ORDER_MENU_INIT);
        orders.forEach((menuName, menuCounts) -> System.out.printf(MENU_AND_COUNT, menuName, menuCounts));
    }

    public void totalPrice(int totalPrice) {
        System.out.println(TOTAL_PRICE_INIT);
        System.out.printf(PRICE, totalPrice);
    }

    public void promotion(String promotionName, int promotionPrice){
        System.out.println(PROMOTION_INIT);
        System.out.printf(MENU_AND_COUNT, promotionName, promotionPrice);
    }

    public void discountContents(Map<String, Integer> discount) {
        System.out.println(DISCOUNT_CONTENT_INIT);
        discount.forEach((discountName, discountPrice) -> System.out.printf(DISCOUNT_CONTENT, discountName, discountPrice));
    }

    public void totalDiscount(int totalDiscount) {
        System.out.println(TOTAL_DISCOUNT_INIT);
        System.out.printf(PRICE, totalDiscount);
    }

    public void estimatedAmount(int estimatedAmount){
        System.out.println(ESTIMATED_AMOUNT_INIT);
        System.out.printf(ESTIMATED_AMOUNT, estimatedAmount);
    }

    public void getBadge(String badge) {
        System.out.println(BADGE_INIT);
        System.out.printf(BADGE, badge);
    }
}
