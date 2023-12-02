package christmas.controller;

import christmas.dto.ConsumerRequest;
import christmas.dto.OrderMenusRequest;
import christmas.dto.PromotionRequest;
import christmas.dto.ReservationDateRequest;
import christmas.model.Consumer;
import christmas.model.OrderMenus;
import christmas.model.Promotion;
import christmas.model.ReservationDate;
import christmas.view.InputView;

import java.util.Map;

public class EnterReservation {
    private InputView inputView;

    private EnterReservation(InputView inputView){
        this.inputView = inputView;
    }

    public static EnterReservation from(InputView inputView){
        return new EnterReservation(inputView);
    }

    public Consumer run() {
        ReservationDate reservationDate = enterReservationDate();
        OrderMenus orderMenus = enterOrderMenus();
        Promotion promotion = calculationPromotion(reservationDate, orderMenus);

        return createConsumer(reservationDate, orderMenus, promotion);
    }

    private ReservationDate enterReservationDate() {
        int date = inputView.enterDate();
        return ReservationDate.from(ReservationDateRequest.from(date));
    }

    private OrderMenus enterOrderMenus() {
        Map<String, Integer> orders = inputView.enterMenus();
        return OrderMenus.from(OrderMenusRequest.from(orders));
    }

    private Promotion calculationPromotion(ReservationDate reservationDate, OrderMenus orderMenus) {
        return Promotion.from(PromotionRequest.of(reservationDate, orderMenus));
    }

    private Consumer createConsumer(ReservationDate reservationDate, OrderMenus orderMenus, Promotion promotion) {
        return Consumer.from(ConsumerRequest.of(reservationDate, orderMenus, promotion));
    }
}
