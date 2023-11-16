package christmas.service.validation;


import christmas.constants.ErrorMessage;
import christmas.model.drink.DrinkEntry;
import christmas.repository.UpdateMenu;

import java.util.Map;

import static christmas.constants.Covert.IS_EMPTY;
import static christmas.constants.Covert.MAX_QUANTITY;

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

    public void underCount(int totalQuantity) {
        if(totalQuantity < IS_EMPTY || totalQuantity > MAX_QUANTITY){
            throw new IllegalArgumentException(ErrorMessage.ENTER_MENU.getMessage());
        }
    }

    public void otherMenu(Map<String, Integer> menus){
        UpdateMenu updateMenuRepository = UpdateMenu.getInstance();
        boolean onlyDrink = true;
        for(Map.Entry<String, Integer> menu : menus.entrySet()){
            if(!(updateMenuRepository.getMenuItemByName(menu.getKey()) instanceof DrinkEntry)){
                onlyDrink = false;
                break;
            }
        }
        if(onlyDrink){
            throw new IllegalArgumentException(ErrorMessage.ENTER_MENU.getMessage());
        }
    }

    private void quantityIsEmpty(int quantity){
        if(quantity <= 0){
            throw new IllegalArgumentException(ErrorMessage.ENTER_MENU.getMessage());
        }
    }

    private void menuNameValidate(String menuName) {
        UpdateMenu updateMenuRepository = UpdateMenu.getInstance();
        if(updateMenuRepository.getMenuItemByName(menuName) == null){
            throw new IllegalArgumentException(ErrorMessage.ENTER_MENU.getMessage());
        }
    }
}
