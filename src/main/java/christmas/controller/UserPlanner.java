package christmas.controller;

import christmas.dto.response.ConsumerResponse;
import christmas.dto.response.DateResponse;
import christmas.model.Consumer;
import christmas.model.Date;
import christmas.model.Order;
import christmas.service.ConsumerOrder;
import christmas.service.PlannerData;
import christmas.view.OutputView;

import java.util.List;
import java.util.Map;

public class UserPlanner {
    private OutputView outputView;
    private DateResponse dateResponse;
    private ConsumerResponse consumerResponse;
    public UserPlanner (OutputView outputView) {
        this.outputView = outputView;
    }
    public Consumer run(List<Order> orders, Date date) {
        Consumer consumer = createConsumer(orders, date);
        checkOrdered(orders);
        int totalPrice = beforeTotalPrice(orders);
        givePromotion(consumer);
        PlannerData plannerData = new PlannerData(this.consumerResponse, this.dateResponse);
        discountContent(plannerData.run(orders));
        return  consumer;
    }

    private Consumer createConsumer(List<Order> orders, Date date) {
        ConsumerOrder consumerOrder = new ConsumerOrder(orders, date);
        this.dateResponse = new DateResponse(date.requestDay(), date.requestDayOfWeek(),
                date.requestWeekDiscount());
        return consumerOrder.run(this.dateResponse);
    }

    private void checkOrdered(List<Order> orders) {
        outputView.orderedMenu(orders);
    }

    private int beforeTotalPrice(List<Order> orders) {
        int totalPrice = orders.stream()
                .mapToInt(order -> order.requestQuantity() * order.requestOrderPrice())
                .sum();
        outputView.beforeTotalPrice(totalPrice);
        return totalPrice;
    }
    private void givePromotion(Consumer consumer) {
        this.consumerResponse = new ConsumerResponse(consumer.requestPromotion(), consumer.requestBadge());
        outputView.givePromotion(this.consumerResponse.promotion());
    }

    private void discountContent(Map<String, Integer> discountMap) {
        outputView.discountContent(discountMap);
    }

    private void totalPromotion() {
        outputView.totalDiscount();
    }

    private void estimatedPay(int totalPrice) {
        outputView.estimatedPay(totalPrice - );
    }

    private void giveBadge() {
        outputView.giveBadge(consumerResponse.badge());
    }
}
