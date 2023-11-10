package christmas.model.drink;

import christmas.model.Menu;
import christmas.model.dessert.DessertEntry;

import java.util.ArrayList;
import java.util.List;

public class Drink {
    private List<Menu> drinks;

    public Drink() {
        drinks = new ArrayList<>();
        drinksInit();
    }

    public Menu setDrinks(String menuName, double price){
        return new DrinkEntry(menuName, price);
    }

    public List<Menu> getDrinks() {
        return List.copyOf(drinks);
    }

    public static void setFixDiscount(int newFixDiscount) {
        DrinkEntry.setFixDiscount(newFixDiscount);
    }

    public static void setRateDiscount(float newRateDiscount) {
        DrinkEntry.setRateDiscount(newRateDiscount);
    }

    private void drinksInit() {
        drinks.add(new DrinkEntry("제로콜라", 3_000));
        drinks.add(new DrinkEntry("레드와인", 60_000));
        drinks.add(new DrinkEntry("샴페인", 25_000));
    }
}
