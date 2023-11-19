package christmas.Dto;

import java.util.Objects;

public class OrderMenu {
    private MenuNames menuNames;
    private int quantity;
    private int discount;

    public OrderMenu(String menuName, int quantity) {
        this.menuNames = MenuNames.requestMenuNamesByName(menuName);
        this.quantity = quantity;
        this.discount = 0;
    }

    public int requestMenuPrice() {
        return menuNames.requestPrice();
    }

    public int requestQuantity() {
        return quantity;
    }

    public int requestDiscount() { return discount; }

    public String requestMenuName() {
        return menuNames.requestName();
    }

    public void updateDiscount(String menuType, int discount) {
        if(Objects.equals(menuNames.requestType(), menuType)){
            this.discount = discount;
        }
    }
}
