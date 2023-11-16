package christmas;

import christmas.controller.Order;

public class Application {
    public static void main(String[] args) {
        Order order = Order.getInstance();
        order.run();
    }
}
