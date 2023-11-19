package christmas.service;

import christmas.Dto.Date;
import christmas.Dto.OrderMenu;
import christmas.Dto.OrderMenus;
import christmas.domain.SumDiscount;
import christmas.domain.TotalPromotion;
import christmas.view.OutputView.ChristmasPromotionView;
import christmas.view.OutputView.EachDiscountView;
import christmas.view.OutputView.EventBadgeView;
import christmas.view.OutputView.OrderedMenuView;
import christmas.view.OutputView.ReservationDateView;
import christmas.view.OutputView.TotalDiscountView;
import christmas.view.OutputView.TotalPriceView;

public class CheckReservationMenu {
    public void run() {
        plannerStartUI();
        orderedMenuUI();
        totalPriceUI();
        christmasPromotionUI();
        eachDiscountUI();
        totalDiscountUI();
        eventBadgeUI();
    }

    private void plannerStartUI() {
        ReservationDateView reservationDateView = new ReservationDateView();
        Date date = Date.getInstance();
        reservationDateView.runUI(date.requestDay());
    }

    private void orderedMenuUI() {
        OrderedMenuView orderedMenuView = new OrderedMenuView();
        OrderMenus orderMenus = OrderMenus.getInstance();

        orderedMenuView.runUI(orderMenus.requestOrderMenu());
    }

    private void totalPriceUI() {
        TotalPriceView totalPriceView = new TotalPriceView();
        OrderMenus orderMenus = OrderMenus.getInstance();

        totalPriceView.runUI(orderMenus.calculateTotalPrice());
    }

    private void christmasPromotionUI() {
        ChristmasPromotionView christmasPromotionView = new ChristmasPromotionView();
        OrderMenus orderMenus = OrderMenus.getInstance();
        OrderMenu promotion = orderMenus.requestPromotion();

        christmasPromotionView.runUI(promotion.requestMenuName(), promotion.requestQuantity());
    }

    private void eachDiscountUI() {
        EachDiscountView eachDiscountView = new EachDiscountView();
        TotalPromotion totalPromotion = new TotalPromotion();

        eachDiscountView.runUI(totalPromotion.createTotalPromotion());
    }

    private void totalDiscountUI() {
        TotalDiscountView totalDiscountView = new TotalDiscountView();
        SumDiscount sumDiscount = new SumDiscount();
        int totalDiscount = sumDiscount.total();

        totalDiscountView.runUI(-totalDiscount, sumDiscount.predictPrice());
    }

    private void eventBadgeUI() {
        EventBadgeView eventBadgeView = new EventBadgeView();
        OrderMenus orderMenus = OrderMenus.getInstance();

        eventBadgeView.runUI(orderMenus.requestBadge());
    }
}
