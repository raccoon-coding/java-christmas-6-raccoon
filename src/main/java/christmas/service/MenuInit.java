package christmas.service;

import christmas.service.validation.MenuValidation;
import christmas.view.InputView;

public class MenuInit {
    public void run() {
        InputView inputView = new InputView();
        String menus = inputView.enterMenu();
        MenuValidation menuValidation = new MenuValidation();
        menuValidation.validateMenu(menus);
    }
}
