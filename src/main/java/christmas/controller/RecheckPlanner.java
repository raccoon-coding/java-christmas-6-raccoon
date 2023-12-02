package christmas.controller;

import christmas.model.Consumer;
import christmas.view.OutputView;

public class RecheckPlanner {
    private OutputView outputView;
    private Consumer consumer;

    private RecheckPlanner(Consumer consumer, OutputView outputView) {
        this.consumer = consumer;
        this.outputView = outputView;
    }

    public static RecheckPlanner of(Consumer consumer, OutputView outputView){
        return new RecheckPlanner(consumer, outputView);
    }

    public void run() {
        orderMenus();
        totalPrice();
        promotion();
        discountContents();
        totalDiscount();
        badge();
    }

    private void orderMenus() {
        outputView.plannerInit(consumer.getDate());
        outputView.orderMenus(consumer.getOrderMenus());
    }

    private void totalPrice() {
        outputView.totalPrice(consumer.getTotalPrice());
    }

    private void promotion() {
        consumer.getGivenPromotion().keySet()
                        .forEach(promotion -> {
                            int price = consumer.getGivenPromotion().get(promotion);
                            outputView.promotion(promotion, price);
                        });
    }

    private void discountContents() {
        outputView.discountContents(consumer.getDiscountContent());
    }

    private void totalDiscount() {
        outputView.totalDiscount(consumer.getTotalDiscount());
        outputView.estimatedAmount(consumer.getEstimatedAmount());
    }

    private void badge() {
        outputView.getBadge(consumer.getBadge());
    }
}
