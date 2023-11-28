package christmas.model;

import christmas.dto.request.OrderRequest;

import java.util.Objects;

public class Order {
    private Menu orderMenu;
    private int quantity;
    private int discount;

    public static Order of(OrderRequest orderRequest){
        Order newOrder = new Order();
        newOrder.orderMenu = orderRequest.orderMenu();
        newOrder.discount = discountType(newOrder, orderRequest.menuType());
        newOrder.quantity = orderRequest.quantity();
        return newOrder;
    }
    public String requestOrderName() {
        return this.orderMenu.requestMenuName();
    }
    public int requestDiscount() {
        return this.discount;
    }
    public int requestQuantity() {
        return this.quantity;
    }
    public int requestOrderPrice() {
        return this.orderMenu.requestMenuPrice();
    }

    private static int discountType(Order order, String menuType) {
        if(Objects.equals(menuType, order.orderMenu.requestMenuType().searchMenuType())){
            return 2023;
        }
        return 0;
    }
}
