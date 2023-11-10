package christmas.model.dessert;

import christmas.model.Menu;
import christmas.model.appetizer.AppetizerEntry;

import java.util.ArrayList;
import java.util.List;

public class Dessert {
    private List<Menu> desserts;

    public Dessert() {
        desserts = new ArrayList<>();
        dessertsInit();
    }

    public Menu setDesserts(String menuName, double price) {
        return new DessertEntry(menuName, price);
    }

    public List<Menu> getDesserts() {
        return List.copyOf(desserts);
    }

    public static void setFixDiscount(int newFixDiscount) {
        DessertEntry.setFixDiscount(newFixDiscount);
    }

    public static void setRateDiscount(float newRateDiscount) {
        DessertEntry.setRateDiscount(newRateDiscount);
    }

    private void dessertsInit() {
        desserts.add(new DessertEntry("초코케이크", 15_000));
        desserts.add(new DessertEntry("아이스크림", 5_000));
    }
}
