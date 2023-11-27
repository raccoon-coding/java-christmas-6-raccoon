package christmas.Dto.Request;

import christmas.Model.Menu;
import christmas.Model.Order;

import java.util.List;

public record ConsumerRequest(List<Order> orders, String badge, Menu promotion) {
}
