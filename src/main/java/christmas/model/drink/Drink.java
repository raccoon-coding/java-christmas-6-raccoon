package christmas.model.drink;

import christmas.model.Menu;
import christmas.model.Menus;

public class Drink {
    private Menus drinks;

    public Drink() {
        drinks = new Menus();
        drinksInit();
    }

    public Menu setDrinks(String menuName, double price){
        return new DrinkEntry(menuName, price);
    }

    public Menus getDrinks() {
        return drinks;
    }

    public static void setFixDiscount(int newFixDiscount) {
        DrinkEntry.setFixDiscount(newFixDiscount);
    }

    private void drinksInit() {
        drinks.addMenu(new DrinkEntry("제로콜라", 3_000));
        drinks.addMenu(new DrinkEntry("레드와인", 60_000));
        drinks.addMenu(new DrinkEntry("샴페인", 25_000));
    }
}
