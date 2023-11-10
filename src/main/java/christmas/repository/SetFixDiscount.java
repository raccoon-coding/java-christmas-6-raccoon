package christmas.repository;

import christmas.model.MenuManager;
import christmas.model.appetizer.Appetizer;
import christmas.model.dessert.Dessert;
import christmas.model.drink.Drink;
import christmas.model.mainFood.MainFood;

public class SetFixDiscount {
    private final float rateDiscount = 0;
    public void setAppetizer(int discount) {
        MenuManager menuManager = MenuManager.getInstance();
        menuManager.setAppetizerDiscount(discount, rateDiscount);
    }

    public void setMainFood(int discount) {
        MenuManager menuManager = MenuManager.getInstance();
        menuManager.setAppetizerDiscount(discount, rateDiscount);
    }

    public void setDrink(int discount) {
        MenuManager menuManager = MenuManager.getInstance();
        menuManager.setAppetizerDiscount(discount, rateDiscount);
    }

    public void setDessert(int discount) {
        MenuManager menuManager = MenuManager.getInstance();
        menuManager.setAppetizerDiscount(discount, rateDiscount);
    }
}
