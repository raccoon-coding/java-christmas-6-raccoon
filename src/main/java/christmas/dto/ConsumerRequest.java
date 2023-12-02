package christmas.dto;

import christmas.model.OrderMenus;
import christmas.model.Promotion;
import christmas.model.ReservationDate;

public record ConsumerRequest(ReservationDate reservationDate, OrderMenus orderMenus, Promotion promotion) {
    public static ConsumerRequest of(ReservationDate reservationDate, OrderMenus orderMenus, Promotion promotion){
        return new ConsumerRequest(reservationDate, orderMenus, promotion);
    }
}
