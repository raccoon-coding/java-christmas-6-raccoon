package christmas;

import christmas.controller.Planner;

public class Application {
    public static void main(String[] args) {
        Planner planner = Planner.getInstance();
        planner.run();
    }
}
