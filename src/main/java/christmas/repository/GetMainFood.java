package christmas.repository;

import christmas.model.Menu;
import christmas.model.MenuManager;
import christmas.model.mainFood.MainFoodEntry;

import java.util.ArrayList;
import java.util.List;

import static christmas.constants.CovertConstant.IS_EMPTY;

public class GetMainFood {
    public List<Menu> getMainFood() {
        List<Menu> mainFood = new ArrayList<>();
        MenuManager menuManager = MenuManager.getInstance();
        for(Menu menu : menuManager.getAllMenuItems()){
            if (menu instanceof MainFoodEntry && menu.getQuantity() > IS_EMPTY){
                System.out.println(menu.getName());
                mainFood.add(menu);
            }
        }
        return mainFood;
    }
}
