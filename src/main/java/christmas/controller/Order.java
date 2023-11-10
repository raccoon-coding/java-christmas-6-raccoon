package christmas.controller;

import christmas.service.OrderInit;

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
        OrderInit orderInit = OrderInit.getInstance();
        orderInit.run();
    }
}
