package christmas.service;

import christmas.domain.BadgeDomain;
import christmas.domain.DiscountDomain;
import christmas.dto.request.ConsumerRequest;
import christmas.dto.response.DateResponse;
import christmas.model.Consumer;
import christmas.model.Date;
import christmas.model.Order;

import java.util.List;

public class ConsumerOrder {
    private List<Order> consumerOrders;
    private Date reservationDate;
    public ConsumerOrder(List<Order> consumerOrders, Date reservationDate) {
        this.consumerOrders = consumerOrders;
        this.reservationDate = reservationDate;
    }
    public Consumer run(DateResponse dateResponse) {
        ConsumerRequest consumerRequest = new ConsumerRequest(consumerOrders, giveBadge(dateResponse),
                givePromotion(), reservationDate);
        return Consumer.of(consumerRequest);
    }

    private String giveBadge(DateResponse dateResponse) {
        BadgeDomain badgeDomain = new BadgeDomain();
        return badgeDomain.giveBadge(calculateDiscount(dateResponse));
    }

    private int calculateDiscount(DateResponse dateResponse) {
        DiscountDomain discountDomain = new DiscountDomain();
        return discountDomain.specialDiscount(dateResponse.day(), dateResponse.dayOfWeek());
    }

    private Order givePromotion() {
        DiscountDomain discountDomain = new DiscountDomain();
        return discountDomain.givePromotion(consumerOrders);
    }
}
