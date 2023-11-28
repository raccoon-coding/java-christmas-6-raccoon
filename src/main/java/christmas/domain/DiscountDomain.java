package christmas.domain;

import christmas.dto.request.OrderRequest;
import christmas.dto.response.DateResponse;
import christmas.dto.response.MenusResponse;
import christmas.model.Menu;
import christmas.model.Menus;
import christmas.model.Order;

import java.util.List;
import java.util.Objects;

public class DiscountDomain {
    public int haveChristmasDiscount(int day) {
        if(day < 26){
            return (day - 1) * 100 + 1000;
        }
        return 0;
    }

    public int specialDiscount(int day, String dayOfWeek) {
        if(day == 25 || Objects.equals(dayOfWeek, "SUNDAY")){
            return 1000;
        }
        return 0;
    }

    public Order givePromotion(List<Order> orders) {
        int totalPrice = orders.stream()
                .mapToInt(order -> order.requestOrderPrice() * order.requestQuantity())
                .sum();
        Menus menus = Menus.getInstance();
        if (totalPrice > 120_000) {
            OrderRequest orderRequest = new OrderRequest(menus.searchMenu(new MenusResponse("샴페인")), 1, null);
            return Order.of(orderRequest);
        }
        return Order.of(new OrderRequest(menus.searchMenu(new MenusResponse("없음")), 0, null));
    }
}
