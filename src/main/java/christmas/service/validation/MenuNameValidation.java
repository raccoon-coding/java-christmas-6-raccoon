package christmas.service.validation;


import christmas.constants.ErrorMessage;
import christmas.repository.UpdateMenuRepository;

import java.util.Map;

public class MenuNameValidation {
    public void validateMenu(String menuName, int quantity) {
        quantityIsEmpty(quantity);
        menuNameValidate(menuName);
    }

    public void sameMenu(Map<String, Integer> menu, String menuName) {
        if (menu.containsKey(menuName)) {
            throw new IllegalArgumentException(ErrorMessage.ENTER_MENU.getMessage());
        }
    }

    private void quantityIsEmpty(int quantity){
        if(quantity <= 0){
            throw new IllegalArgumentException(ErrorMessage.ENTER_MENU.getMessage());
        }
    }

    private void menuNameValidate(String menuName) {
        UpdateMenuRepository updateMenuRepository = UpdateMenuRepository.getInstance();
        if(updateMenuRepository.getMenuItemByName(menuName) == null){
            throw new IllegalArgumentException(ErrorMessage.ENTER_MENU.getMessage());
        }
    }
}
