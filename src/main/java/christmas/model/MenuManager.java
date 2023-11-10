package christmas.model;

import christmas.model.appetizer.Appetizer;
import christmas.model.dessert.Dessert;
import christmas.model.drink.Drink;
import christmas.model.mainFood.MainFood;

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

    public List<Menu> getAllMenuItems() {
        return allMenuItems;
    }

    public void addMenuItems(Menu menu) {
        allMenuItems.add(menu);
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
        allMenuItems.addAll(appetizerMenu.getAppetizers());

        MainFood mainFood = new MainFood();
        allMenuItems.addAll(mainFood.getMainFoods());

        Drink drink = new Drink();
        allMenuItems.addAll(drink.getDrinks());

        Dessert dessert = new Dessert();
        allMenuItems.addAll(dessert.getDesserts());
    }
}