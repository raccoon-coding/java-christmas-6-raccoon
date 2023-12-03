package christmas.model;

import christmas.dto.PromotionRequest;
import christmas.model.constants.Badge;
import christmas.model.constants.Menus;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static christmas.model.constants.ModelConstants.CHRISTMAS_DATE;
import static christmas.model.constants.ModelConstants.CHRISTMAS_DISCOUNT;
import static christmas.model.constants.ModelConstants.CHRISTMAS_DISCOUNT_BASE;
import static christmas.model.constants.ModelConstants.CHRISTMAS_UNIT;
import static christmas.model.constants.ModelConstants.DONT_HAVE_MENU;
import static christmas.model.constants.ModelConstants.PROMOTION;
import static christmas.model.constants.ModelConstants.PROMOTION_MENU;
import static christmas.model.constants.ModelConstants.PROMOTION_MENU_COUNT;
import static christmas.model.constants.ModelConstants.PROMOTION_MINIMUM;
import static christmas.model.constants.ModelConstants.SPECIAL_DAY;
import static christmas.model.constants.ModelConstants.SPECIAL_DISCOUNT;
import static christmas.model.constants.ModelConstants.SPECIAL_DISCOUNT_UNIT;
import static christmas.model.constants.ModelConstants.WEEKDAY_DISCOUNT;
import static christmas.model.constants.ModelConstants.WEEKDAY_DISCOUNT_MENU;
import static christmas.model.constants.ModelConstants.WEEKEND_DISCOUNT;
import static christmas.model.constants.ModelConstants.WEEKEND_DISCOUNT_MENU;
import static christmas.model.constants.ModelConstants.WEEKEND_FIRST;
import static christmas.model.constants.ModelConstants.WEEKEND_SECOND;
import static christmas.model.constants.ModelConstants.WEEK_DISCOUNT_UNIT;

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
        if(date > CHRISTMAS_DATE){
            return;
        }
        promotion.put(CHRISTMAS_DISCOUNT, (date - 1) * CHRISTMAS_UNIT + CHRISTMAS_DISCOUNT_BASE);
    }

    private void isWeekDiscount(String dayOfWeek, OrderMenus orderMenus) {
        if(Objects.equals(dayOfWeek, WEEKEND_FIRST) && Objects.equals(dayOfWeek, WEEKEND_SECOND)){
            isHaveOrder(WEEKEND_DISCOUNT_MENU, WEEKEND_DISCOUNT, orderMenus);
        }
        isHaveOrder(WEEKDAY_DISCOUNT_MENU, WEEKDAY_DISCOUNT, orderMenus);
    }

    private void isSpecialDiscount(ReservationDate date) {
        if(date.getWeek().equals(SPECIAL_DAY) || date.getDayOfWeek() == CHRISTMAS_DATE){
            promotion.put(SPECIAL_DISCOUNT, SPECIAL_DISCOUNT_UNIT);
        }
    }

    private void isHaveOrder(String menuType, String discountType,  OrderMenus orderMenus) {
        if(orderMenus.haveMenuType(menuType)){
            this.promotion.put(discountType, orderMenus.menuTypeCount(menuType) * WEEK_DISCOUNT_UNIT);
        }
    }

    private void isPromotion(OrderMenus orderMenus) {
        if(orderMenus.getTotalPrice() > PROMOTION_MINIMUM) {
            promotion.put(PROMOTION, Menus.searchMenus(PROMOTION_MENU).getMenuPrice());
            this.givenPromotion.put(Menus.searchMenus(PROMOTION_MENU), PROMOTION_MENU_COUNT);
            return;
        }
        this.givenPromotion.put(Menus.searchMenus(DONT_HAVE_MENU), 0);
    }

    private void givenBadge() {
        this.badge = Badge.getBadge(getTotalDiscount());
    }
}
