package christmas.model.appetizer;

import christmas.model.Menu;
import christmas.model.MenuManager;
import christmas.model.Menus;

import java.util.ArrayList;
import java.util.List;

import static christmas.constants.CovertConstant.IS_EMPTY;

public class Appetizer {
    private Menus appetizers;

    public Appetizer() {
        appetizers = new Menus();
        appetizersInit();
    }

    public Menu setAppetizers(String menuName, double price) {
        return new AppetizerEntry(menuName, price);
    }

    public Menus getAppetizers() {
        return appetizers;
    }

    public static void setFixDiscount(int newFixDiscount) {
        AppetizerEntry.setFixDiscount(newFixDiscount);
    }

    private void appetizersInit() {
        appetizers.addMenu(new AppetizerEntry("양송이수프", 6_000));
        appetizers.addMenu(new AppetizerEntry("타파스", 5_500));
        appetizers.addMenu(new AppetizerEntry("시저샐러드", 8_000));
    }
}
