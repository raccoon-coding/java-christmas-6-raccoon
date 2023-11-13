package christmas.service;

import christmas.domain.ConvertMenu;
import christmas.domain.CalculationMenuDomain;
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
        recheckMenu();
        discount();
    }

    private void init() {
        String menus = enterMenu();
        validationMenu(menus);
        convertMenu(menus);
    }

    private void recheckMenu() {
        OutputView outputView = new OutputView();
        outputView.printMenu();
    }

    private void discount() {
        CalculationMenuDomain enterMenuDomain = new CalculationMenuDomain();
        enterMenuDomain.calculationMenuDomain();
    }

    private String enterMenu() {
        InputView inputView = new InputView();
        return inputView.enterMenu();
    }

    private void validationMenu(String menus) {
        MenuValidation menuValidation = new MenuValidation();
        menuValidation.validateMenu(menus);
    }

    private void convertMenu(String menus) {
        ConvertMenu convertMenu = new ConvertMenu();
        convertMenu.convertMenu(menus);
    }
}
