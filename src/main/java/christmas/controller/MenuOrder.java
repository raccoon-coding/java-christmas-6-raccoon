package christmas.controller;

import christmas.service.CalculateDiscount;
import christmas.service.CheckReservationMenu;
import christmas.service.OrderInit;
import christmas.service.ReservationDateInit;

public class MenuOrder {
    private static MenuOrder instance;

    private MenuOrder() {
    }

    public static synchronized MenuOrder getInstance() {
        if (instance == null) {
            instance = new MenuOrder();
        }
        return instance;
    }

    public void run() {
        enterDate();
        enterMenu();
        CalculateDiscount();
        reservationUI();
    }

    private void enterDate(){
        ReservationDateInit reservationDateInit = new ReservationDateInit();
        reservationDateInit.run();
    }

    private void enterMenu() {
        OrderInit orderInit = new OrderInit();
        orderInit.run();
    }

    private void reservationUI() {
        CheckReservationMenu checkReservationMenu = new CheckReservationMenu();
        checkReservationMenu.run();
    }

    private void CalculateDiscount() {
        CalculateDiscount calculateDiscount = new CalculateDiscount();
        calculateDiscount.run();
    }
}
