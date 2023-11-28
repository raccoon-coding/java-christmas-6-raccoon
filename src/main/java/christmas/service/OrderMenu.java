package christmas.service;

import christmas.domain.OrdersDomain;
import christmas.dto.response.DateResponse;
import christmas.model.Order;

import java.util.List;
import java.util.Map;

public class OrderMenu {
    public List<Order> run(DateResponse dateResponse, List<Map<String, Integer>> enterOrder) {
        return createOrders(dateResponse, enterOrder);
    }

    private List<Order> createOrders(DateResponse dateResponse, List<Map<String, Integer>> enterOrder) {
        OrdersDomain ordersDomain = new OrdersDomain();
        return ordersDomain.createOrders(enterOrder, dateResponse.dayOfWeek(), dateResponse.weekDiscount());
    }
}
