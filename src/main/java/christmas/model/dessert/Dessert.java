package christmas.model.dessert;

import christmas.model.Menu;

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

    private void dessertsInit() {
        desserts.add(new DessertEntry("초코케이크", 15_000));
        desserts.add(new DessertEntry("아이스크림", 5_000));
    }
}
