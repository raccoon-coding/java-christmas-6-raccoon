package christmas.model.dessert;

import christmas.model.Menu;
import christmas.model.Menus;

public class Dessert {
    private Menus desserts;

    public Dessert() {
        desserts = new Menus();
        dessertsInit();
    }

    public Menu setDesserts(String menuName, double price) {
        return new DessertEntry(menuName, price);
    }

    public Menus getDesserts() {
        return desserts;
    }

    public static void setFixDiscount(int newFixDiscount) {
        DessertEntry.setFixDiscount(newFixDiscount);
    }

    private void dessertsInit() {
        desserts.addMenu(new DessertEntry("초코케이크", 15_000));
        desserts.addMenu(new DessertEntry("아이스크림", 5_000));
    }
}
