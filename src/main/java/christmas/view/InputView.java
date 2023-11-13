package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.model.TotalPrice;
import christmas.service.validation.DataValidation;

import static christmas.constants.Interface.enterMenuName;
import static christmas.constants.Interface.initInterface;

public class InputView {
    private static InputView instance;
    private InputView() {
    }
    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public String readDate() {
        System.out.println(initInterface);
        return Console.readLine();
    }

    public String enterMenu() {
        System.out.println(enterMenuName);
        return Console.readLine();
    }
}
