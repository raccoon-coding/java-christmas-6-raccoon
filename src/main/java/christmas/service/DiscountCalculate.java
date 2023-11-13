package christmas.service;

import christmas.domain.*;
import christmas.repository.SaveDiscount;
import christmas.model.Date;
import christmas.model.TotalPrice;
import christmas.view.OutputView;

public class DiscountCalculate {
    private static DiscountCalculate instance;
    SaveDiscount saveDiscount;
    EventBadgeDomain eventBadge;
    private DiscountCalculate() {
        this.saveDiscount = new SaveDiscount();
        this.eventBadge = new EventBadgeDomain();
    }

    public static synchronized DiscountCalculate getInstance() {
        if (instance == null) {
            instance = new DiscountCalculate();
        }
        return instance;
    }

    public void run () {
        saveDiscount.saveDiscount();
        discountDomain();
        eventBadge.eventBadge();
        orderView();
    }

    private void discountDomain() {
        Date date = Date.getInstance();
        TotalPrice totalPrice = TotalPrice.getInstance();
        DiscountDomain discountDomain = new DiscountDomain();

        discountDomain.calculateDiscount(date, totalPrice);
    }

    private void orderView() {
        OutputView outputView = new OutputView();
        TotalPrice totalPrice = TotalPrice.getInstance();

        outputView.printPrice(totalPrice);
        outputView.givenEvent(totalPrice);
        outputView.totalDiscount(totalPrice);
    }
}
