package christmas.dto;

import java.util.Map;

public record OrderMenusRequest(Map<String, Integer> orders) {
    public static OrderMenusRequest from(Map<String, Integer> orders){
        return new OrderMenusRequest(orders);
    }
}
