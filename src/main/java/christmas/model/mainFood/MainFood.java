package christmas.model.mainFood;

import christmas.model.Menu;
import christmas.model.drink.DrinkEntry;

import java.util.ArrayList;
import java.util.List;

public class MainFood {
    private List<Menu> mainFoods;

    public MainFood() {
        mainFoods = new ArrayList<>();
        mainFoodsInit();
    }

    public Menu setMainFoods(String menuName, double price) {
        return new MainFoodEntry(menuName, price);
    }

    public List<Menu> getMainFoods() {
        return List.copyOf(mainFoods);
    }

    public static void setFixDiscount(int newFixDiscount) {
        MainFoodEntry.setFixDiscount(newFixDiscount);
    }

    public static void setRateDiscount(float newRateDiscount) {
        MainFoodEntry.setRateDiscount(newRateDiscount);
    }

    private void mainFoodsInit() {
        mainFoods.add(new MainFoodEntry("티본스테이크", 55_000));
        mainFoods.add(new MainFoodEntry("바비큐립", 54_000));
        mainFoods.add(new MainFoodEntry("해산물파스타", 35_000));
        mainFoods.add(new MainFoodEntry("크리스마스파스타", 25_000));
    }
}
