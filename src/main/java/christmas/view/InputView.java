package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.service.validation.DataValidation;

import static christmas.constants.Interface.enterMenuName;
import static christmas.constants.Interface.initInterface;

public class InputView {
    public String readDate() {
        System.out.println(initInterface);
        return Console.readLine();
    }

    public String enterMenu() {
        System.out.println(enterMenuName);
        return Console.readLine();
    }
}
