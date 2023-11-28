package christmas.controller;

import christmas.dto.response.DateResponse;
import christmas.model.Date;
import christmas.model.Order;
import christmas.service.OrderMenu;
import christmas.service.Reservation;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class MenuOrder {
    public List<Order> run(InputView inputView, DateResponse dateResponse) {
        while(true){
            try{
                return orderMenu(inputView, dateResponse);
            }
            catch (IllegalArgumentException e){
                System.out.println(ErrorMessage.OrderError.printErrorMessage());
            }
        }

    }
    private List<Order> orderMenu(InputView inputView, DateResponse dateResponse) {
        OrderMenu orderMenu = new OrderMenu();
        return orderMenu.run(dateResponse, inputView.enterOrderMenu());
    }
}
