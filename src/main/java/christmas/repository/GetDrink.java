package christmas.repository;

import christmas.model.Menu;
import christmas.model.MenuManager;
import christmas.model.drink.DrinkEntry;

import java.util.ArrayList;
import java.util.List;

import static christmas.constants.Covert.IS_EMPTY;

public class GetDrink {
    public List<Menu> getDrink() {
        List<Menu> drink = new ArrayList<>();
        MenuManager menuManager = MenuManager.getInstance();
        for(Menu menu : menuManager.getAllMenuItems()){
            if (menu instanceof DrinkEntry && menu.getQuantity() > IS_EMPTY){
                drink.add(menu);
            }
        }
        return drink;
    }
}
