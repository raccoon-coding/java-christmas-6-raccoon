package christmas.repository;

import christmas.model.Menu;
import christmas.model.MenuManager;
import christmas.model.appetizer.Appetizer;
import christmas.model.dessert.Dessert;
import christmas.model.drink.Drink;
import christmas.model.mainFood.MainFood;

public class MenuRepository {
    public void addMenu(String foodType, String menuName, int price) {
        addAppetizer(foodType, menuName, price);
        addMainFood(foodType, menuName, price);
        addDrink(foodType, menuName, price);
        addDessert(foodType, menuName, price);
    }

    private void addAppetizer(String foodType, String menuName, int price) {
        if(foodType.equals("Appetizer")){
            saveNewMenu(new Appetizer().setAppetizers(menuName, price));
        }
    }

    private void addMainFood(String foodType, String menuName, int price) {
        if(foodType.equals("MainFood")){
            saveNewMenu(new MainFood().setMainFoods(menuName, price));
        }
    }

    private void addDrink(String foodType, String menuName, int price) {
        if(foodType.equals("Drink")){
            saveNewMenu(new Drink().setDrinks(menuName, price));
        }
    }

    private void addDessert(String foodType, String menuName, int price) {
        if(foodType.equals("Dessert")){
            saveNewMenu(new Dessert().setDesserts(menuName, price));
        }
    }

    private void saveNewMenu(Menu menu) {
        MenuManager menuManager = MenuManager.getInstance();
        menuManager.addMenuItems(menu);
    }
}
