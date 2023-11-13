package christmas.repository;

import christmas.model.Menu;
import christmas.model.MenuManager;
import christmas.model.appetizer.Appetizer;
import christmas.model.dessert.Dessert;
import christmas.model.drink.Drink;
import christmas.model.mainFood.MainFood;

import static christmas.constants.MenuConstant.APPETIZER;
import static christmas.constants.MenuConstant.MAIN_FOOD;
import static christmas.constants.MenuConstant.DESSERT;
import static christmas.constants.MenuConstant.DRINK;

public class MenuRepository {
    public void addMenu(String foodType, String menuName, int price) {
        addAppetizer(foodType, menuName, price);
        addMainFood(foodType, menuName, price);
        addDrink(foodType, menuName, price);
        addDessert(foodType, menuName, price);
    }

    private void addAppetizer(String foodType, String menuName, int price) {
        if(foodType.equals(APPETIZER)){
            saveNewMenu(new Appetizer().setAppetizers(menuName, price));
        }
    }

    private void addMainFood(String foodType, String menuName, int price) {
        if(foodType.equals(MAIN_FOOD)){
            saveNewMenu(new MainFood().setMainFoods(menuName, price));
        }
    }

    private void addDrink(String foodType, String menuName, int price) {
        if(foodType.equals(DESSERT)){
            saveNewMenu(new Drink().setDrinks(menuName, price));
        }
    }

    private void addDessert(String foodType, String menuName, int price) {
        if(foodType.equals(DRINK)){
            saveNewMenu(new Dessert().setDesserts(menuName, price));
        }
    }

    private void saveNewMenu(Menu menu) {
        MenuManager menuManager = MenuManager.getInstance();
        menuManager.addMenuItems(menu);
    }
}
