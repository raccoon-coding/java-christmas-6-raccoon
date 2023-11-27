package christmas.Model;

import christmas.Dto.Request.ConsumerRequest;

import java.util.List;

public class Consumer {
    private List<Order> orders;
    private String badge;
    private Menu promotion;
    private Date reservationDate;

    public Consumer of(ConsumerRequest consumerRequest){
        Consumer consumer = new Consumer();
        consumer.orders = consumerRequest.orders();
        consumer.badge = consumerRequest.badge();
        consumer.promotion = consumerRequest.promotion();
        return consumer;
    }
}
