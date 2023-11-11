package christmas.controller;

import christmas.service.DateInit;
import christmas.service.DiscountCalculate;
import christmas.service.MenuInit;

public class Order {
    private static Order instance;

    private Order() {
    }

    public static synchronized Order getInstance() {
        if (instance == null) {
            instance = new Order();
        }
        return instance;
    }

    public void run() {
        orderInitService();
    }

    private void orderInitService(){
        DateInit dateInit = DateInit.getInstance();
        dateInit.run();
        MenuInit menuInit = MenuInit.getInstance();
        menuInit.run();
        DiscountCalculate discountCalculate = DiscountCalculate.getInstance();
        discountCalculate.run();
    }
}
