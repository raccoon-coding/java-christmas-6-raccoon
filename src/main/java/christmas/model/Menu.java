package christmas.model;

public interface Menu {
    String getName();
    double getPrice();
    int getQuantity();
    int getFixDiscount();
    void setQuantity(int quantity);
}
