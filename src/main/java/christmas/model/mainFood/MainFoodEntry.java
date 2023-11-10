package christmas.model.mainFood;

import christmas.model.Menu;

public class MainFoodEntry implements Menu {
    private String name;
    private double price;
    private int quantity;

    public MainFoodEntry(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public double getPrice() {
        return price;
    }
    @Override
    public int getQuantity() {
        return quantity;
    }
    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}