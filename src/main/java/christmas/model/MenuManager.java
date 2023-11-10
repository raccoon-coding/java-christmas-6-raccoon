package christmas.model;

import christmas.model.appetizer.Appetizer;
import christmas.model.appetizer.AppetizerEntry;
import christmas.model.dessert.Dessert;
import christmas.model.drink.Drink;
import christmas.model.mainFood.MainFood;
import christmas.model.mainFood.MainFoodEntry;

import java.util.ArrayList;
import java.util.List;

public class MenuManager {
    private static MenuManager instance;
    private List<Menu> allMenuItems;

    private MenuManager() {
        allMenuItems = new ArrayList<>();
        menuManagerInit();
    }

    public static synchronized MenuManager getInstance() {
        if (instance == null) {
            instance = new MenuManager();
        }
        return instance;
    }

    public Menu getMenuItemByName(String name) {
        for (Menu menu : allMenuItems) {
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

    public void addMenu(String foodType, String menuName, int price) {
        addAppetizer(foodType, menuName, price);
        addMainFood(foodType, menuName, price);
        addDrink(foodType, menuName, price);
        addDessert(foodType, menuName, price);
    }

    private void menuManagerInit(){
        Appetizer appetizerMenu = new Appetizer();
        allMenuItems.addAll(appetizerMenu.getAppetizers());
        MainFood mainFood = new MainFood();
        allMenuItems.addAll(mainFood.getMainFoods());
        Drink drink = new Drink();
        allMenuItems.addAll(drink.getDrinks());
        Dessert dessert = new Dessert();
        allMenuItems.addAll(dessert.getDesserts());
    }

    private void addAppetizer(String foodType, String menuName, int price) {
        if(foodType.equals("Appetizer")){
            allMenuItems.add(new Appetizer().setAppetizers(menuName, price));
        }
    }

    private void addMainFood(String foodType, String menuName, int price) {
        if(foodType.equals("MainFood")){
            allMenuItems.add(new MainFood().setMainFoods(menuName, price));
        }
    }

    private void addDrink(String foodType, String menuName, int price) {
        if(foodType.equals("Drink")){
            allMenuItems.add(new Drink().setDrinks(menuName, price));
        }
    }

    private void addDessert(String foodType, String menuName, int price) {
        if(foodType.equals("Dessert")){
            allMenuItems.add(new Dessert().setDesserts(menuName, price));
        }
    }
}