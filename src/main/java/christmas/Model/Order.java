package christmas.Model;

import christmas.Dto.Request.OrderRequest;

public class Order {
    private Menu orderMenu;
    private int quantity;
    private int discount;

    public Order of(OrderRequest orderRequest){
        Order newOrder = new Order();
        newOrder.orderMenu = orderRequest.orderMenu();
        newOrder.discount = 0;
        newOrder.quantity = orderRequest.quantity();
        return newOrder;
    }

    public int requestDiscount() {
        return this.discount;
    }
    public int requestQuantity() {
        return this.discount;
    }
}
