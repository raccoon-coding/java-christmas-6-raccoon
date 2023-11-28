package christmas.controller;

import christmas.dto.response.DateResponse;
import christmas.model.Consumer;
import christmas.model.Date;
import christmas.model.Order;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class Planner {
    private static Planner instance;
    private InputView inputView;
    private OutputView outputView;
    private Planner() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public static Planner getInstance() {
        if (instance == null) {
            instance = new Planner();
        }
        return instance;
    }
    public void run() {
        Date reservationDate = reservation();
        List<Order> orders = createOrders(reservationDate);
        createUserPlanner(orders, reservationDate);
    }

    private Date reservation() {
        ReservationDate reservationDate = new ReservationDate(inputView);
        return reservationDate.run();
    }

    private List<Order> createOrders(Date reservationDate) {
        MenuOrder menuOrder = new MenuOrder();
        DateResponse dateResponse = new DateResponse(reservationDate.requestDay(), reservationDate.requestDayOfWeek(),
                reservationDate.requestWeekDiscount());
        return menuOrder.run(inputView ,dateResponse);
    }

    private Consumer createUserPlanner(List<Order> orders, Date reservationDate) {
        UserPlanner userPlanner = new UserPlanner(outputView);
        return userPlanner.run(orders, reservationDate);
    }
}
