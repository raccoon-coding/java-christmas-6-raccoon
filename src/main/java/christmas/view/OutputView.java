package christmas.view;

import christmas.model.Order;

import java.util.List;
import java.util.Map;

import static christmas.view.OutputViewConstants.Badge;
import static christmas.view.OutputViewConstants.BadgeInit;
import static christmas.view.OutputViewConstants.BeforeTotalPrice;
import static christmas.view.OutputViewConstants.Discount;
import static christmas.view.OutputViewConstants.DiscountContent;
import static christmas.view.OutputViewConstants.EstimatedPay;
import static christmas.view.OutputViewConstants.OrderedMenuInit;
import static christmas.view.OutputViewConstants.Price;
import static christmas.view.OutputViewConstants.Promotion;
import static christmas.view.OutputViewConstants.TotalDiscount;
import static christmas.view.OutputViewConstants.oneOrderedMenu;

public class OutputView {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    public void orderedMenu(List<Order> orders) {
        System.out.println(OrderedMenuInit);
        orders.forEach(order -> System.out.println(
                String.format(oneOrderedMenu, order.requestOrderName(), order.requestQuantity())
        ));
    }

    public void beforeTotalPrice(int beforeTotalPrice) {
        System.out.println(BeforeTotalPrice);
        System.out.printf(Price, beforeTotalPrice);
        System.out.printf(LINE_SEPARATOR);
    }

    public void givePromotion(Order promotion) {
        System.out.println(Promotion);
        if(promotion.requestQuantity() == 0){
            System.out.printf(Badge, promotion.requestOrderName());
        }
        if(promotion.requestQuantity() > 0){
            System.out.printf(oneOrderedMenu, promotion.requestOrderName(), promotion.requestQuantity());
        }
        System.out.printf(LINE_SEPARATOR);
    }

    public void discountContent(Map<String, Integer> discount) {
        System.out.println(DiscountContent);
        discount.forEach((key, value) -> System.out.println(
                String.format(Discount, key, value)));
    }

    public void totalDiscount(int totalDiscount){
        System.out.println(TotalDiscount);
        System.out.printf(Price, totalDiscount);
        System.out.printf(LINE_SEPARATOR);
    }

    public void estimatedPay(int estimated) {
        System.out.println(EstimatedPay);
        System.out.printf(Price, estimated);
        System.out.printf(LINE_SEPARATOR);
    }

    public void giveBadge(String badge) {
        System.out.println(BadgeInit);
        System.out.printf(Badge, badge);
        System.out.printf(LINE_SEPARATOR);
    }
}
