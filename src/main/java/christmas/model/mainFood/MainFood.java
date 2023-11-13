package christmas.model.mainFood;

import christmas.model.Menu;
import christmas.model.MenuManager;
import christmas.model.Menus;
import christmas.model.drink.DrinkEntry;

import java.util.ArrayList;
import java.util.List;

import static christmas.constants.CovertConstant.IS_EMPTY;

public class MainFood {
    private Menus mainFoods;

    public MainFood() {
        mainFoods = new Menus();
        mainFoodsInit();
    }

    public Menu setMainFoods(String menuName, double price) {
        return new MainFoodEntry(menuName, price);
    }

    public Menus getMainFoods() {
        return mainFoods;
    }

    public static void setFixDiscount(int newFixDiscount) {
        MainFoodEntry.setFixDiscount(newFixDiscount);
    }

    public static void setRateDiscount(float newRateDiscount) {
        MainFoodEntry.setRateDiscount(newRateDiscount);
    }

    private void mainFoodsInit() {
        mainFoods.addMenu(new MainFoodEntry("티본스테이크", 55_000));
        mainFoods.addMenu(new MainFoodEntry("바비큐립", 54_000));
        mainFoods.addMenu(new MainFoodEntry("해산물파스타", 35_000));
        mainFoods.addMenu(new MainFoodEntry("크리스마스파스타", 25_000));
    }
}
