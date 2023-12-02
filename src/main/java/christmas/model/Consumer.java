package christmas.model;

import christmas.dto.ConsumerRequest;

import java.util.Map;
import java.util.stream.Collectors;

public class Consumer {
    private final OrderMenus orderMenus;
    private final Promotion promotion;
    private final ReservationDate reservationDate;

    private Consumer(ReservationDate reservationDate, OrderMenus orderMenus, Promotion promotion){
        this.reservationDate = reservationDate;
        this.orderMenus = orderMenus;
        this.promotion = promotion;
    }

    public static Consumer from(ConsumerRequest consumerRequest){
        return new Consumer(consumerRequest.reservationDate(), consumerRequest.orderMenus(), consumerRequest.promotion());
    }

    public int getDate() {
        return this.reservationDate.getDayOfWeek();
    }

    public Map<String, Integer> getOrderMenus() {
        return orderMenus.getOrderMenus().entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().getMenuName(),
                        Map.Entry::getValue
                ));
    }

    public int getTotalPrice() {
        return this.orderMenus.getTotalPrice();
    }

    public Map<String, Integer> getGivenPromotion() {
        return this.promotion.getGivenPromotion().entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> entry.getKey().getMenuName(),
                        Map.Entry::getValue
                ));
    }

    public Map<String, Integer> getDiscountContent() {
        return this.promotion.getPromotion();
    }

    public int getTotalDiscount() {
        return this.promotion.getTotalDiscount();
    }

    public int getEstimatedAmount() {
        int givenPromotionPrice = this.promotion.getGivenPromotion().entrySet().stream()
                .mapToInt(entry -> entry.getKey().getMenuPrice() * entry.getValue())
                .sum();
        return getTotalPrice() - getTotalDiscount() + givenPromotionPrice;
    }

    public String getBadge() {
        return this.promotion.getBadge();
    }
}
