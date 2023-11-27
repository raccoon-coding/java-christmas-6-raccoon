package christmas.View;

import camp.nextstep.edu.missionutils.Console;
import christmas.View.ViewValidation.DayValidation;
import christmas.View.ViewValidation.MenuValidation;

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
        String input = Console.readLine();
        MenuValidation menuValidation = new MenuValidation();
        return menuValidation.enterOrderMenuIsFormat(input);
    }
}
