package christmas.model;

import christmas.dto.request.ConsumerRequest;

import java.util.List;

public class Consumer {
    private List<Order> orders;
    private String badge;
    private Order promotion;
    private Date reservationDate;

    public static Consumer of(ConsumerRequest consumerRequest){
        Consumer consumer = new Consumer();
        consumer.orders = consumerRequest.orders();
        consumer.badge = consumerRequest.badge();
        consumer.promotion = consumerRequest.promotion();
        consumer.reservationDate = consumerRequest.reservationDate();
        return consumer;
    }

    public String requestBadge() {
        return this.badge;
    }
    public Order requestPromotion() {
        return this.promotion;
    }
    public List<Order> requestOrders() {return this.orders; }
}
