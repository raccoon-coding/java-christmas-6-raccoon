package christmas.service;

import christmas.domain.DiscountDomain;
import christmas.domain.OrdersDomain;
import christmas.dto.response.ConsumerResponse;
import christmas.dto.response.DateResponse;
import christmas.model.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlannerData {
    private ConsumerResponse consumerResponse;
    private DateResponse dateResponse;
    private Map<String, Integer> discount;
    public PlannerData(ConsumerResponse consumerResponse, DateResponse dateResponse) {
        this.consumerResponse = consumerResponse;
        this.dateResponse = dateResponse;
    }

    public Map<String, Integer> run(List<Order> orders) {
        this.discount = new HashMap<>();
        DiscountDomain discountDomain = new DiscountDomain();
        int special = discountDomain.specialDiscount(this.dateResponse.day(), this.dateResponse.dayOfWeek());
        if(special > 0) {
            this.discount.put("특별 할인", 1_000);
        }
        int christmas = discountDomain.haveChristmasDiscount(dateResponse.day());
        if(christmas > 0){
            this.discount.put("크리스마스 디데이 할인", christmas);
        }
        if(this.consumerResponse.promotion().requestQuantity() > 0){
            this.discount.put("증정 이벤트", this.consumerResponse.promotion().requestOrderPrice());
        }
        String dayPolicy = discountWeek();
        setWeekDiscount(dayPolicy, orders);
        return this.discount;
    }

    private String discountWeek() {
        OrdersDomain ordersDomain = new OrdersDomain();
        String dayPolicy = null;
        dayPolicy = ordersDomain.isWeekDay(this.dateResponse.dayOfWeek(), dayPolicy);
        dayPolicy = ordersDomain.isWeekEnd(this.dateResponse.dayOfWeek(), dayPolicy);
        return dayPolicy;
    }

    private void setWeekDiscount(String dayPolicy, List<Order> orders) {
        int totalDiscount = orders.stream()
                .filter(order -> order.requestDiscount() != 0)
                .mapToInt(order -> order.requestDiscount() * order.requestQuantity())
                .sum();
        if(totalDiscount > 0){
            this.discount.put(dayPolicy, totalDiscount);
        }
    }
}
