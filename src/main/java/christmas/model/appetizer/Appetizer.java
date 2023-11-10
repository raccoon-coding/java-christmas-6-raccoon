package christmas.model.appetizer;

import christmas.model.Menu;

import java.util.ArrayList;
import java.util.List;

public class Appetizer {
    private List<Menu> appetizers;

    public Appetizer() {
        appetizers = new ArrayList<>();
        appetizersInit();
    }

    public Menu setAppetizers(String menuName, double price) {
        return new AppetizerEntry(menuName, price);
    }

    public List<Menu> getAppetizers() {
        return List.copyOf(appetizers);
    }

    public static void setFixDiscount(int newFixDiscount) {
        AppetizerEntry.setFixDiscount(newFixDiscount);
    }

    public static void setRateDiscount(float newRateDiscount) {
        AppetizerEntry.setRateDiscount(newRateDiscount);
    }

    private void appetizersInit() {
        appetizers.add(new AppetizerEntry("양송이수프", 6_000));
        appetizers.add(new AppetizerEntry("타파스", 5_500));
        appetizers.add(new AppetizerEntry("시저샐러드", 8_000));
    }
}
