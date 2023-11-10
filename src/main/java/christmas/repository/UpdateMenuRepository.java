package christmas.repository;

import christmas.model.Menu;
import christmas.model.MenuManager;

public class UpdateMenuRepository {
    public Menu getMenuItemByName(String name) {
        MenuManager menuManager = MenuManager.getInstance();
        for (Menu menu : menuManager.getAllMenuItems()) {
            if(menu.getName().equalsIgnoreCase(name)) {
                return menu;
            }
        }
        return null;
    }

    public void updateQuantity(String itemName, int quantity) {
        Menu menu = getMenuItemByName(itemName);
        if(menu != null) {
            menu.setQuantity(quantity);
        }
    }
}
