package christmas.Service;

import christmas.Model.Order;
import christmas.View.InputView;
import christmas.View.OutputView;

import java.util.List;

public class OrderMenu {
    private InputView inputView;
    public OutputView outputView;

    public OrderMenu(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public List<Order> run() {

    }
}
