package christmas.view;

import camp.nextstep.edu.missionutils.Console;

import static christmas.constants.StartPlanner.enterMenuName;
import static christmas.constants.StartPlanner.enterReservationDate;
import static christmas.constants.StartPlanner.startPlanner;

public class InputView {
    public void startUI() {
        System.out.println(startPlanner);
    }
    public String readDate() {
        System.out.println(enterReservationDate);
        return Console.readLine();
    }

    public String enterMenu() {
        System.out.println(enterMenuName);
        return Console.readLine();
    }
}
