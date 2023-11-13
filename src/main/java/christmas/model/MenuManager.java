package christmas.model;

import christmas.model.appetizer.Appetizer;
import christmas.model.dessert.Dessert;
import christmas.model.drink.Drink;
import christmas.model.mainFood.MainFood;

import java.util.List;

public class MenuManager {
    private static MenuManager instance;
    private Menus allMenuItems;

    private MenuManager() {
        allMenuItems = new Menus();
        menuManagerInit();
    }

    public static synchronized MenuManager getInstance() {
        if (instance == null) {
            instance = new MenuManager();
        }
        return instance;
    }

    public List<Menu> getAllMenuItems() {
        return allMenuItems.getMenus();
    }

    public void addMenuItems(Menu menu) {
        allMenuItems.addMenu(menu);
    }

    public void setAppetizerDiscount(int fixDiscount, float rateDiscount) {
        Appetizer.setFixDiscount(fixDiscount);
        Appetizer.setRateDiscount(rateDiscount);
    }

    public void setDessertDiscount(int fixDiscount, float rateDiscount) {
        Dessert.setFixDiscount(fixDiscount);
        Dessert.setRateDiscount(rateDiscount);
    }

    public void setDrinkDiscount(int fixDiscount, float rateDiscount) {
        Drink.setFixDiscount(fixDiscount);
        Drink.setRateDiscount(rateDiscount);
    }

    public void setMainFoodDiscount(int fixDiscount, float rateDiscount) {
        MainFood.setFixDiscount(fixDiscount);
        MainFood.setRateDiscount(rateDiscount);
    }

    private void menuManagerInit(){
        Appetizer appetizerMenu = new Appetizer();
        allMenuItems.addMenus(appetizerMenu.getAppetizers());

        MainFood mainFood = new MainFood();
        allMenuItems.addMenus(mainFood.getMainFoods());

        Drink drink = new Drink();
        allMenuItems.addMenus(drink.getDrinks());

        Dessert dessert = new Dessert();
        allMenuItems.addMenus(dessert.getDesserts());
    }
}