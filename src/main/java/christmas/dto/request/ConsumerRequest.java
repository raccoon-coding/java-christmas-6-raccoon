package christmas.dto.request;

import christmas.model.Date;
import christmas.model.Order;

import java.util.List;

public record ConsumerRequest(List<Order> orders, String badge, Order promotion, Date reservationDate) {
}
