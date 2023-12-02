package christmas.dto;

import christmas.model.OrderMenus;
import christmas.model.ReservationDate;

public record PromotionRequest(ReservationDate date, OrderMenus orderMenus) {
    public static PromotionRequest of(ReservationDate date, OrderMenus orderMenus) {
        return new PromotionRequest(date, orderMenus);
    }
}
