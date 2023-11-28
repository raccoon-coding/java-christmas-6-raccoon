package christmas.domain;

import christmas.model.Menu;
import christmas.model.Order;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidateOrders {
    public void validateOrders(List<Order> orders) {
        validateOrderCount(orders);
        validateSameOrder(orders);
    }

    public void validateOneOrder(Menu menu) {
        if(menu.requestMenuName() == null){
            throw new IllegalArgumentException();
        }
    }

    private void validateOrderCount(List<Order> orders){
        long totalQuantity = orders.stream()
                .mapToLong(Order::requestQuantity)
                .sum();
        if(totalQuantity > 20){
            throw new IllegalArgumentException();
        }
    }

    private void validateSameOrder(List<Order> orders) {
        Set<String> orderNames = new HashSet<>();

        orders.stream()
                .filter(order -> !orderNames.add(order.requestOrderName()))
                .findFirst()
                .ifPresent(order -> {
                    throw new IllegalArgumentException("Duplicate order name found: " + order.requestOrderName());
                });

    }
}
