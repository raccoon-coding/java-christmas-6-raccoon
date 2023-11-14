package christmas.model;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TotalPrice {
    private static TotalPrice instance;
    private Map<String, Integer> discount;
    private double totalDiscount;
    private double totalPrice;
    private double totalEvent;
    private String badge;

    private TotalPrice() {
        this.totalDiscount = 0;
        this.totalPrice = 0;
        this.discount = new HashMap<>();
        this.totalEvent = 0;
        this.badge = null;
    }

    public static synchronized TotalPrice getInstance() {
        if (instance == null) {
            instance = new TotalPrice();
        }
        return instance;
    }

    public void refresh() {
        this.totalDiscount = 0;
        this.totalPrice = 0;
        this.discount.clear();
        this.totalEvent = 0;
        this.badge = null;
    }

    public void setDiscount(String discountName, int discount) {
        this.discount.put(discountName, discount);
    }
    public void setTotalDiscount(double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public void setBadge(String badge) {
        this.badge = badge;
    }
    public void setTotalEvent(double totalEvent) {this.totalEvent = totalEvent;}
    public Map<String, Integer> getDiscount() {
        return Collections.unmodifiableMap(discount);
    }
    public double getTotalDiscount() {
        return totalDiscount;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public String getBadge() {
        return badge;
    }
    public double getPrice() {
        return totalPrice + totalDiscount;
    }
    public double getTotalEvent() {
        return totalEvent;
    }
}
