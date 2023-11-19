package christmas;

import christmas.controller.MenuOrder;

public class Application {
    public static void main(String[] args) {
        MenuOrder order = MenuOrder.getInstance();
        order.run();
    }
}
