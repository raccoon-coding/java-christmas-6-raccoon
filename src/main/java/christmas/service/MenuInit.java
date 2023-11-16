package christmas.service;

import christmas.domain.ConvertMenu;
import christmas.domain.CalculationMenu;
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
        while(true) {
            try {
                init();
                recheckMenu();
                discount();
                return;
            }
            catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void init() {
        String menus = enterMenu();
        convertMenu(menus);
    }

    private void recheckMenu() {
        OutputView outputView = new OutputView();
        outputView.printMenu();
    }

    private void discount() {
        CalculationMenu enterMenuDomain = new CalculationMenu();
        enterMenuDomain.calculationMenuDomain();
    }

    private String enterMenu() {
        InputView inputView = new InputView();
        return inputView.enterMenu();
    }

    private void convertMenu(String menus) {
        ConvertMenu convertMenu = new ConvertMenu();
        convertMenu.convertMenu(menus);
    }
}
