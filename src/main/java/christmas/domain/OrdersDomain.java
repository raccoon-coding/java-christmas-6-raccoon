package christmas.domain;

import christmas.model.Menus;
import christmas.model.Order;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class OrdersDomain {
    public List<Order> createOrders(List<Map<String, Integer>> orderMenuList, String dayOfWeek,
                                    Map<String, String> weekDiscount) {
        Menus menus = Menus.getInstance();
        String discountMenuType = dateDiscount(dayOfWeek, weekDiscount);
        List<Order> orders = orderMenuList.stream()
                .map(order -> createOneOrder(menus, order, discountMenuType))
                .collect(Collectors.toList());
        validateOrders(orders);

        return orders;
    }

    private Order createOneOrder(Menus menus, Map<String, Integer> order, String discountMenuType) {
        OneOrderDomain oneOrderDomain = new OneOrderDomain();
        return oneOrderDomain.createOneOrder(menus, order, discountMenuType);
    }

    private void validateOrders(List<Order> orders) {
        ValidateOrders validateOrders = new ValidateOrders();
        validateOrders.validateOrders(orders);
    }

    private String dateDiscount(String dayOfWeek, Map<String, String> weekDiscount) {
        String dayPolicy = null;
        dayPolicy = isWeekDay(dayOfWeek, dayPolicy);
        dayPolicy = isWeekEnd(dayOfWeek, dayPolicy);
        return weekDiscount.getOrDefault(dayPolicy, "없음");
    }
    public String isWeekEnd(String dayOfWeek, String dayPolicy) {
        if(Objects.equals(dayOfWeek, "FRIDAY") || Objects.equals(dayOfWeek, "SATURDAY")){
            return "주말 할인";
        }
        return dayPolicy;
    }

    public String isWeekDay(String dayOfWeek, String dayPolicy) {
        if(!Objects.equals(dayOfWeek, "FRIDAY") && !Objects.equals(dayOfWeek, "SATURDAY")) {
            return "평일 할인";
        }
        return dayPolicy;
    }
}
