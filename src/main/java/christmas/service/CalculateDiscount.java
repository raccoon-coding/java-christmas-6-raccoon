package christmas.service;

import christmas.domain.Discount.ChristmasDiscount;
import christmas.domain.Discount.SpecialDiscount;
import christmas.domain.Discount.WeekDiscount;
import christmas.domain.EventBadge;
import christmas.domain.SpecialPromotion;

public class CalculateDiscount {
    public void run() {
        weekDiscountCalculation();
        christmasDiscountCalculation();
        specialDiscountCalculation();
        specialPromotionCalculation();
        eventBadgeCalculation();
    }

    private void christmasDiscountCalculation() {
        ChristmasDiscount christmasDiscount = new ChristmasDiscount();
        christmasDiscount.haveChristmasDiscount();
    }

    private void specialDiscountCalculation() {
        SpecialDiscount specialDiscount = new SpecialDiscount();
        specialDiscount.haveSpecialDiscount();
    }

    private void weekDiscountCalculation() {
        WeekDiscount weekDiscount = new WeekDiscount();
        weekDiscount.haveWeekDiscount();
    }

    private void specialPromotionCalculation() {
        SpecialPromotion specialPromotion = new SpecialPromotion();
        specialPromotion.calculationMenuDomain();
    }

    private void eventBadgeCalculation() {
        EventBadge eventBadge = new EventBadge();
        eventBadge.eventBadge();
    }
}
