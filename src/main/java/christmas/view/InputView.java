package christmas.view;

import christmas.view.validate.InputValidate;

import java.util.Map;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static christmas.view.constants.InputConstants.ENTER_DATE;
import static christmas.view.constants.InputConstants.ORDER_MENUS;
import static christmas.view.constants.InputConstants.PLANNER_INIT;

public class InputView {
    private final InputValidate inputValidate;

    public InputView() {
        this.inputValidate = new InputValidate();
    }

    public void plannerInit() {
        System.out.println(PLANNER_INIT);
    }

    public int enterDate() {
        System.out.println(ENTER_DATE);
        return inputValidate.isDate(readLine());
    }

    public Map<String, Integer> enterMenus() {
        System.out.println(ORDER_MENUS);
        return inputValidate.isMenuFormat(readLine());
    }
}
