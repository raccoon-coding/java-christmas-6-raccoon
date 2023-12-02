package christmas.model;

import christmas.dto.PromotionRequest;
import christmas.model.constants.Badge;
import christmas.model.constants.Menus;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Promotion {
    private final Map<String, Integer> promotion;
    private final EnumMap<Menus, Integer> givenPromotion;
    private Badge badge;

    private Promotion(ReservationDate reservationDate, OrderMenus orderMenus) {
        this.promotion = new HashMap<>();
        this.givenPromotion = new EnumMap<>(Menus.class);
        createDatePromotion(reservationDate, orderMenus);
    }

    public static Promotion from(PromotionRequest promotionRequest) {
        return new Promotion(promotionRequest.date(), promotionRequest.orderMenus());
    }

    public Map<String, Integer> getPromotion() {
        return this.promotion;
    }

    public EnumMap<Menus, Integer> getGivenPromotion() {
        return this.givenPromotion;
    }

    public String getBadge() {
        return this.badge.getBadgeName();
    }

    public int getTotalDiscount() {
        return this.promotion.entrySet().stream()
                .mapToInt(Map.Entry::getValue)
                .sum();
    }

    private void createDatePromotion(ReservationDate date, OrderMenus orderMenus) {
        isChristmasDiscount(date.getDayOfWeek());
        isWeekDiscount(date.getWeek(), orderMenus);
        isSpecialDiscount(date);
        isPromotion(orderMenus);
        givenBadge();
    }

    private void isChristmasDiscount(int date) {
        if(date > 25){
            return;
        }
        promotion.put("크리스마스 디데이 할인", (date - 1) * 100 + 1_000);
    }

    private void isWeekDiscount(String dayOfWeek, OrderMenus orderMenus) {
        if(Objects.equals(dayOfWeek, "FRIDAY") && Objects.equals(dayOfWeek, "SATURDAY")){
            isHaveOrder("MainMenu", "주말 할인", orderMenus);
        }
        isHaveOrder("Dessert", "평일 할인", orderMenus);
    }

    private void isSpecialDiscount(ReservationDate date) {
        if(date.getWeek().equals("SUNDAY") || date.getDayOfWeek() == 25){
            promotion.put("특별 할인", 1_000);
        }
    }

    private void isHaveOrder(String menuType, String discountType,  OrderMenus orderMenus) {
        if(orderMenus.haveMenuType(menuType)){
            this.promotion.put(discountType, orderMenus.menuTypeCount(menuType) * 2_023);
        }
    }

    private void isPromotion(OrderMenus orderMenus) {
        if(orderMenus.getTotalPrice() > 120_000) {
            promotion.put("증정 이벤트", Menus.searchMenus("샴페인").getMenuPrice());
            this.givenPromotion.put(Menus.searchMenus("샴페인"), 1);
            return;
        }
        this.givenPromotion.put(Menus.searchMenus("없음"), 0);
    }

    private void givenBadge() {
        this.badge = Badge.getBadge(getTotalDiscount());
    }
}
