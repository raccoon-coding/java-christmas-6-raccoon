package christmas.repository;

import christmas.model.Menu;
import christmas.model.MenuManager;
import christmas.model.dessert.DessertEntry;

import java.util.ArrayList;
import java.util.List;

public class GetDessert {
    public List<Menu> getDessert() {
        List<Menu> dessert = new ArrayList<>();
        MenuManager menuManager = MenuManager.getInstance();
        for(Menu menu : menuManager.getAllMenuItems()){
            if (menu instanceof DessertEntry && menu.getQuantity() > 0){
                dessert.add(menu);
            }
        }
        return dessert;
    }
}
