package christmas.service;

import christmas.domain.ConvertMenu;
import christmas.service.validation.CatchErrorRetry;
import christmas.view.InputView;

public class OrderInit {
    public void run() {
        ConvertMenu convertMenu = new ConvertMenu();
        InputView inputView = new InputView();

        enterMenu(convertMenu, inputView);
    }

    private void enterMenu(ConvertMenu convertMenu, InputView inputView) {
        CatchErrorRetry.executeWithRetry(
                () -> {
                    String enterMenus = inputView.enterMenu();
                    convertMenu.convertMenu(enterMenus);
                }
        );
    }
}
