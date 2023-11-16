package christmas.repository;

import christmas.model.MenuManager;

public class SetFixDiscount {
    public void setAppetizer(int discount) {
        MenuManager menuManager = MenuManager.getInstance();
        menuManager.setAppetizerDiscount(discount);
    }

    public void setMainFood(int discount) {
        MenuManager menuManager = MenuManager.getInstance();
        menuManager.setMainFoodDiscount(discount);
    }

    public void setDrink(int discount) {
        MenuManager menuManager = MenuManager.getInstance();
        menuManager.setDrinkDiscount(discount);
    }

    public void setDessert(int discount) {
        MenuManager menuManager = MenuManager.getInstance();
        menuManager.setDessertDiscount(discount);
    }
}
