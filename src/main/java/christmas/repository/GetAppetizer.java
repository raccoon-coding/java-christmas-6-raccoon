package christmas.repository;

import christmas.model.Menu;
import christmas.model.MenuManager;
import christmas.model.appetizer.AppetizerEntry;

import java.util.ArrayList;
import java.util.List;

import static christmas.constants.CovertConstant.IS_EMPTY;

public class GetAppetizer {
    public List<Menu> getAppetizer() {
        List<Menu> Appetizer = new ArrayList<>();
        MenuManager menuManager = MenuManager.getInstance();
        for(Menu menu : menuManager.getAllMenuItems()){
            if (menu instanceof AppetizerEntry && menu.getQuantity() > IS_EMPTY){
                Appetizer.add(menu);
            }
        }
        return Appetizer;
    }
}
