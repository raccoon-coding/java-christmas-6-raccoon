package christmas.model.appetizer;

import christmas.model.Menu;

public class AppetizerEntry implements Menu {
    private String name;
    private double price;
    private int quantity;
    private static int fixDiscount;


    public AppetizerEntry(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantity = 0;
    }

    public static void setFixDiscount(int newFixDiscount) {
        fixDiscount = newFixDiscount;
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
    public int getFixDiscount() {
        return fixDiscount;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
