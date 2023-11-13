package christmas.model;

import java.util.*;

public class TotalPrice {
    private static TotalPrice instance;
    private Map<String, Integer> discount = new HashMap<>();
    private double totalDiscount;
    private double totalPrice;
    private String badge;

    private TotalPrice() {
        this.totalDiscount = 0;
        this.totalPrice = 0;
    }

    public static synchronized TotalPrice getInstance() {
        if (instance == null) {
            instance = new TotalPrice();
        }
        return instance;
    }

    public void setDiscount(String discountName, int discount) {
        this.discount.put(discountName, discount);
    }

    public Map<String, Integer> getDiscount() {
        return Collections.unmodifiableMap(discount);
    }

    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public double getTotalPrice() {
        return totalPrice - totalDiscount;
    }
    public void setBadge(String badge) {
        this.badge = badge;
    }
    public String getBadge() {
        return badge;
    }
}
