package christmas.controller;

public class Order {
    private static Order instance;

    private Order() {
    }

    public static Order getInstance() {
        if (instance == null) {
            instance = new Order();
        }
        return instance;
    }

    public void run() {
        orderInitService();
    }

    private void orderInitService(){

    }
}
