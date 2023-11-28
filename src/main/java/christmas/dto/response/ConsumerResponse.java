package christmas.dto.response;

import christmas.model.Order;

public record ConsumerResponse(Order promotion, String badge) {
}
