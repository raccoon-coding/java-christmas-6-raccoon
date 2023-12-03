package christmas.view.validate;

import christmas.view.constants.ErrorMessage;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static christmas.view.constants.InputConstants.DATE_END;
import static christmas.view.constants.InputConstants.DATE_START;
import static christmas.view.constants.InputConstants.MENU_COUNT_SEPARATOR;
import static christmas.view.constants.InputConstants.MENU_SEPARATOR;
import static java.lang.Integer.parseInt;

public class InputValidate {
    public int isDate(String enterDate) {
        try {
            int date = parseInt(enterDate);
            isDateLange(date);
            return date;
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.IS_DATE.getErrorMessage());
        }
    }

    public Map<String, Integer> isMenuFormat(String enterMenus) {
        try {
            return Arrays.stream(enterMenus.split(MENU_SEPARATOR))
                    .map(oneMenu -> oneMenu.split(MENU_COUNT_SEPARATOR))
                    .collect(Collectors.toMap(oneMenu -> oneMenu[0],
                            oneMenu -> isCount(oneMenu[1])));
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.IS_MENU.getErrorMessage());
        }
    }

    private void isDateLange(int date) {
        if(date < DATE_START || date > DATE_END) {
            throw new IllegalArgumentException(ErrorMessage.IS_DATE.getErrorMessage());
        }
    }

    private int isCount(String enterCount) {
        try {
            int count = parseInt(enterCount);
            isCountLange(count);
            return count;
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.IS_MENU.getErrorMessage());
        }
    }

    private void isCountLange(int count){
        if(count < 0 || count > 20){
            throw new IllegalArgumentException(ErrorMessage.IS_MENU.getErrorMessage());
        }
    }
}
