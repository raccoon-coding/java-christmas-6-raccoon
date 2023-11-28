package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.view.viewValidation.DayValidation;
import christmas.view.viewValidation.MenuValidation;

import java.util.List;
import java.util.Map;

public class InputView {
    public int enterReservationDay(){
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        DayValidation dayValidation = new DayValidation();
        return dayValidation.enterDayIsInt(input);
    }

    public List<Map<String, Integer>> enterOrderMenu() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String input = Console.readLine();
        MenuValidation menuValidation = new MenuValidation();
        return menuValidation.enterOrderMenuIsFormat(input);
    }
}
