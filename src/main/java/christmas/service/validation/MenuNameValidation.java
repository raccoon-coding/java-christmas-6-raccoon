package christmas.service.validation;

import christmas.constants.ErrorMessage;

import java.util.Map;
import java.util.Objects;

import static christmas.Dto.MenuNames.requestMenuName;
import static christmas.constants.Covert.IS_EMPTY;
import static christmas.constants.Covert.MAX_QUANTITY;
import static christmas.view.OutputView.OutputConstants.NULL_EVENT;

public class MenuNameValidation {
    public void underCount(int totalQuantity) {
        if(totalQuantity > MAX_QUANTITY){
            throw new IllegalArgumentException(ErrorMessage.ENTER_MENU.getMessage());
        }
    }

    public void validateMenuQuantity(int quantity) {
        if(quantity <= IS_EMPTY){
            throw new IllegalArgumentException(ErrorMessage.ENTER_MENU.getMessage());
        }
    }

    public void validateMenuName(String menuName) {
        if(Objects.equals(requestMenuName(menuName), NULL_EVENT)){
            throw new IllegalArgumentException(ErrorMessage.ENTER_MENU.getMessage());
        }
    }

    public void sameMenu(Map<String, Integer> menu, String menuName) {
        if (menu.containsKey(menuName)) {
            throw new IllegalArgumentException(ErrorMessage.ENTER_MENU.getMessage());
        }
    }
}
