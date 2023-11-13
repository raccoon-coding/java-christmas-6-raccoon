package christmas.view;

import christmas.model.Menu;
import christmas.model.MenuManager;
import christmas.model.TotalPrice;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static christmas.constants.CovertConstant.IS_EMPTY;
import static christmas.constants.DiscountConstant.GIFT_EVENT;
import static christmas.constants.Output.NULL_EVENT;
import static christmas.constants.Output.ORDER_MENU;
import static christmas.constants.Output.ORDER_MENU_COUNT;
import static christmas.constants.Output.EMPTY_DISCOUNT_PRICE;
import static christmas.constants.Output.PRICE_FORMAT;
import static christmas.constants.Output.NEGATIVE;
import static christmas.constants.Output.FREE_MENU_INIT;
import static christmas.constants.Output.FREE_MENU;
import static christmas.constants.Output.DISCOUNT_CONTEXT_INIT;
import static christmas.constants.Output.DISCOUNT_CONTEXT;
import static christmas.constants.Output.TOTAL_DISCOUNT;
import static christmas.constants.Output.EVENT_BADGE;
import static christmas.constants.Output.PREDICT_PRICE;

public class OutputView {
    public void printMenu() {
        System.out.println(ORDER_MENU);
        MenuManager menuManager = MenuManager.getInstance();
        List<Menu> menus = menuManager.getAllMenuItems();
        for(Menu menu : menus){
            if(menu.getQuantity() > IS_EMPTY) {
                System.out.printf(ORDER_MENU_COUNT, menu.getName(), menu.getQuantity());
            }
        }
    }

    public void printPrice(TotalPrice totalPrice){
        System.out.println(EMPTY_DISCOUNT_PRICE);
        System.out.println(new DecimalFormat(PRICE_FORMAT).format(totalPrice.getTotalPrice()));
    }

    public void givenEvent(TotalPrice totalPrice){
        if(totalPrice.getDiscount().containsKey(GIFT_EVENT)){
            System.out.println(FREE_MENU_INIT);
            System.out.println(FREE_MENU);
        }
    }

    public void totalDiscount(TotalPrice totalPrice) {
        sumDiscount(totalPrice);
        totalDiscountView(totalPrice);
        eventBadge(totalPrice);
    }

    private void sumDiscount(TotalPrice totalPrice) {
        haveDiscount(totalPrice);
        emptyDiscount(totalPrice);
    }

    private void haveDiscount(TotalPrice totalPrice) {
        if (!totalPrice.getDiscount().isEmpty()) {
            System.out.println(DISCOUNT_CONTEXT_INIT);
            for (Map.Entry<String, Integer> discount : totalPrice.getDiscount().entrySet()) {
                System.out.printf(DISCOUNT_CONTEXT,
                        discount.getKey(), new DecimalFormat(PRICE_FORMAT).format(discount.getValue()));
            }
        }
    }

    private void emptyDiscount(TotalPrice totalPrice){
        if (totalPrice.getDiscount().isEmpty()){
            System.out.println(DISCOUNT_CONTEXT_INIT);
            System.out.println(NULL_EVENT);
        }
    }

    private void totalDiscountView(TotalPrice totalPrice){
        System.out.println(TOTAL_DISCOUNT);
        System.out.println(new DecimalFormat(NEGATIVE + PRICE_FORMAT).format(totalPrice.getTotalDiscount()));
        System.out.println(PREDICT_PRICE);
        System.out.println(new DecimalFormat(PRICE_FORMAT).format(totalPrice.getPrice()));
    }

    private void eventBadge(TotalPrice totalPrice){
        System.out.println(EVENT_BADGE);
        emptyBadge(totalPrice);
        haveBadge(totalPrice);
    }

    private void emptyBadge(TotalPrice totalPrice) {
        if(Objects.equals(totalPrice.getBadge(), null)){
            System.out.println(NULL_EVENT);
        }
    }

    private void haveBadge(TotalPrice totalPrice){
        if(!Objects.equals(totalPrice.getBadge(), null)){
            System.out.println(totalPrice.getBadge());
        }
    }
}
