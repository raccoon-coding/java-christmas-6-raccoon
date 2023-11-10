package christmas.model;

public interface Menu {
    String getName();
    double getPrice();
    int getQuantity();
    float getRateDiscount();
    int getFixDiscount();
    void setQuantity(int quantity);
}
