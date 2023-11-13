package christmas.service;

import christmas.dto.ConvertMenu;
import christmas.model.Menu;
import christmas.model.MenuManager;
import christmas.model.TotalPrice;
import christmas.service.validation.MenuValidation;
import christmas.view.InputView;
import christmas.view.OutputView;

import static christmas.constants.CovertConstant.IS_EMPTY;
import static christmas.constants.DiscountConstant.GIFT_EVENT;
import static christmas.constants.DiscountConstant.GIFT_PRICE;

public class MenuInit {
    private static MenuInit instance;
    public static final int MINIMUM_PRICE = 120_000;

    private MenuInit() {}


    public static synchronized MenuInit getInstance() {
        if (instance == null) {
            instance = new MenuInit();
        }
        return instance;
    }

    public void run() {
        init();
        OutputView outputView = OutputView.getInstance();
        outputView.printMenu();
        double totalPrice = sumPrice();
        givenEvent(totalPrice);
    }
    private void init() {
        InputView inputView = InputView.getInstance();
        String menus = inputView.enterMenu();
        MenuValidation menuValidation = new MenuValidation();
        menuValidation.validateMenu(menus);
        ConvertMenu convertMenu = new ConvertMenu();
        convertMenu.convertMenu(menus);
    }

    private double sumPrice() {
        MenuManager menuManager = MenuManager.getInstance();
        double total = 0;
        for(Menu menu : menuManager.getAllMenuItems()){
            if(menu.getQuantity() > IS_EMPTY) {
                total += menu.getQuantity() * menu.getPrice();
            }
        }
        OutputView outputView = OutputView.getInstance();
        outputView.printPrice(total);
        TotalPrice totalPrice = TotalPrice.getInstance();
        totalPrice.setTotalPrice(total);
        return total;
    }

    private void givenEvent(double sumPrice){
        if(sumPrice > MINIMUM_PRICE){
            OutputView outputView = OutputView.getInstance();
            outputView.givenEvent();
            TotalPrice totalPrice = TotalPrice.getInstance();
            totalPrice.setDiscount(GIFT_EVENT, GIFT_PRICE);
            totalPrice.setTotalDiscount(GIFT_PRICE);
        }
    }
}
