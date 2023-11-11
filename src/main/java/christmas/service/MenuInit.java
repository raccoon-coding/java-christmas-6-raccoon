package christmas.service;

import christmas.dto.ConvertMenu;
import christmas.model.Menu;
import christmas.model.MenuManager;
import christmas.model.TotalPrice;
import christmas.service.validation.MenuValidation;
import christmas.view.InputView;
import christmas.view.OutputView;

public class MenuInit {
    private static MenuInit instance;

    private MenuInit() {}

    public static synchronized MenuInit getInstance() {
        if (instance == null) {
            instance = new MenuInit();
        }
        return instance;
    }

    public void run() {
        init();
        OutputView outputView = new OutputView();
        outputView.printMenu();
        double totalPrice = sumPrice();
        givenEvent(totalPrice);
    }
    private void init() {
        InputView inputView = new InputView();
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
            if(menu.getQuantity() > 0) {
                total += menu.getQuantity() * menu.getPrice();
            }
        }
        OutputView outputView = new OutputView();
        outputView.printPrice(total);
        TotalPrice totalPrice = TotalPrice.getInstance();
        totalPrice.setTotalPrice(total);
        return total;
    }

    private void givenEvent(double totalPrice){
        if(totalPrice > 120_000){
            OutputView outputView = new OutputView();
            outputView.givenEvent();
        }
    }
}
